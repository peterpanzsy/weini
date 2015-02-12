package com.weini.manage.business;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.weini.manage.dao.BoxModelDao;
import com.weini.manage.dao.DispatchingDao;
import com.weini.manage.dao.MenuDao;
import com.weini.manage.dao.OrderDao;
import com.weini.manage.dao.OrderRefundDao;
import com.weini.manage.dao.SonOrderDao;
import com.weini.manage.dao.SorderDispatchingDao;
import com.weini.manage.dao.UserDao;
import com.weini.manage.entity.TDispatching;
import com.weini.manage.entity.TOrder;
import com.weini.manage.entity.TOrderrefund;
import com.weini.manage.entity.TSOrder;
import com.weini.manage.entity.TSorderDispatching;
import com.weini.manage.entity.TTrackpage;
import com.weini.tools.HibernateSessionManager;
import com.weini.tools.Tools;


public class OrderService extends GeneralService {
	private OrderDao orderdao = new OrderDao(this.session);
	private SonOrderDao sonorderdao = new SonOrderDao(this.session);
	private BoxModelDao boxdao = new BoxModelDao(this.session);
	private UserDao userdao = new UserDao(this.session);
	private OrderRefundDao refunddao = new OrderRefundDao(this.session);
	private SorderDispatchingDao sonDisDao = new SorderDispatchingDao(this.session);
	private DispatchingDao disDao = new DispatchingDao(this.session);
	private MenuDao menuDao = new MenuDao(this.session);
	/**
	 * 根据用户的id获取本月的订单记录
	 * @param userID 用户id
	 * @return
	 */
	public List<TSOrder> getMonthOrderByUserID(int userID,int year,int month){
		List<TSOrder> res = new ArrayList<TSOrder>();
		try{
			res = this.sonorderdao.searchMonthSonOrder(userID, year, month);
		}catch(Exception e){
			e.printStackTrace();
		}
		this.close();
		return res;
	}
	//TODO 等待修改
	/**
	 * 获取子订单根据父订单的id
	 * @param orderID 父订单id
	 * @return
	 */
	public List<TSOrder> getSonOrderByOrderID(String orderID){
		List<TSOrder> res = new ArrayList<TSOrder>();
		try{
//			res = this.sonorderdao.getSOrderByOrderID(orderID);
		}catch(Exception e){
			e.printStackTrace();
		}
		this.close();
		return res;
	}
		/**
		 * 获取用户当天的子订单id
		 * @param 
		 * @return -1 失败，否则，订单id
		 */
		public int getTodaySonOrderByUserId(int userId){
			int res = -1;
			Calendar cale = Calendar.getInstance();
			String time = (new SimpleDateFormat("yyyy-MM-dd")).format(cale.getTime());
			try{
				res = this.sonorderdao.getSonOrderIDByUserIdAndDate(userId, time);
			}catch(Exception e){
				e.printStackTrace();
			}
			this.close();
			return res;
		}
	/**
	 * 增加一个订单
	 * 	如果是isFirst订单，则需要更新用户的忌口和饭量
	 * 	增加一个订单
	 * 	增加对应的子订单
	 * 注意：需要根据用户选择的中西餐，以及用户的性别，动态生成菜品id
	 * @param order 订单对象
	 * @param orderIsFirst 是否是first订单
	 * @param userID 用户id
	 * @param userHeatID 用户讨厌食物的id
	 * @param userAppetite 用户的饭量
	 * @param userPungent 麻辣程度
	 * @param userSex 用户性别
	 * @return 成功返回订单id，失败返回null
	 */
	public String addUserOrder(TOrder order,int orderIsFirst,int userID,int userHeatID,int userAppetite,int userPungent){
		String res = null;
		HibernateSessionManager.getThreadLocalTransaction();
		//设置默认值
		order.setOrderPayStatus(0);
		order.setSOrderConsumeStatus(0);
		order.setOrderStatus(0);
		order.setOrderSettleStatus(0);
		//生成菜品id
		int menuID = this.getRandomMenuID(order.getOrderMenuWestern(), order.getOrderDispatchingId());
		if(menuID > 0){
			order.setOrderMenuinfoId(menuID);
		}else{
			this.roll();
			return res;
		}
		float boxPrice = 0;
		int box_type = 0;
		String userheat = "";
//		第一次订单
//		更新user表中的用户的userHeatID,userApptite
		try{
			if(orderIsFirst == 1){
				//失败的话可以忍受
				this.userdao.updateUserTaste(userID, userHeatID, userAppetite,userPungent);
				userheat = this.userdao.getUserHeatByID(userHeatID);
			}
			List<Object> temp = this.boxdao.getBoxPriceAndTypeByBoxID(order.getBoxId());
			if(temp.size() == 2){
				boxPrice = (float)temp.get(0);
				box_type = (int)temp.get(1);
				//设置盒子模式价格
				order.setBoxPrice(boxPrice);
				//增加订单
				// 获取订单id
				String notice = "注意：";
				if(!userheat.equals("")){
					notice += "不吃："+ (userheat+" ");
				}
				notice += "饭量："+Tools.getUserAppetite(userAppetite)+" ";
				notice += "辣度："+Tools.getUserPungent(userPungent);
				order.setOrderNotice(notice);
				if(this.orderdao.insertOrder(order) > 0){
					TSOrder sonOrder = new TSOrder();
					sonOrder.setFOrderNum(order.getOrderNum());
					sonOrder.setMenuId(order.getOrderMenuinfoId());
					sonOrder.setSOrderStatus(0);
					sonOrder.setSOrderConsumeEvaluate("");
					sonOrder.setSOrderLogisticsEvaluate("");
					sonOrder.setSOrderIsdispatchingStateOpen(1);
					sonOrder.setSOrderNotice(notice);
					sonOrder.setSOrderDispatchingId(order.getOrderDispatchingId());
					sonOrder.setUserId(order.getUserId());
					//循环增加子订单
					List<String> dates = Tools.getDatesNotWeekend(box_type);
					for(int i = 1;i <= box_type;i++){
						//动态设置whichday
						sonOrder.setSOrderWhichday(i);
						sonOrder.setSOrderDispatchingDate((new SimpleDateFormat("yyyy-MM-dd")).parse(dates.get(i-1)));
						if(this.sonorderdao.insertSonOrder(sonOrder) <= 0){
							this.roll();
							return res;
						}
					}
					this.close();
					res = order.getOrderNum();
					return res;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		this.roll();
		return res;
	}
	/**
	 * 根据订单编号获取订单的支付状态
	 * @param orderNum 订单编号
	 * @return 执行失败，返回-1，支付成功返回1，支付失败返回0
	 */
	public int getOrderStatusByOrderNum(String orderNum){
		int res = -1;
		try{
			res = this.orderdao.getOrderPayStatusByOrderNum(orderNum);
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
	
	/**
	 * 根据用户的id查找用户的记录
	 * @param pageStart 页面开始的记录数
	 * @param pagelimit 限制条数
	 * @return 执行失败 null;成功返回list
	 */
	public List<TOrder> getUserOrderListLimit(int userID,int pageStart,int pageLimit){
		List<TOrder> res = new ArrayList<TOrder>();
		try{
			res = this.orderdao.getUserOrderLimit(userID,pageStart,pageLimit);
		}catch(Exception e){
			e.printStackTrace();
			res = null;
		}
		this.close();
		return res;
	}
	/**
	 * 根据订单的id查找订单
	 * @param orderNum 订单编号
	 * @return 执行失败 null;成功返回list
	 */
	public TOrder getOrderDetailByOrderNum(String orderNum){
		TOrder res = null;
		try{
			res = this.orderdao.getOrderDetailByOrderNum(orderNum);
		}catch(Exception e){
			e.printStackTrace();
		}
		this.close();
		return res;
	}
	/**
	 * 用户申请退款
	 * @param orderNum
	 * @return
	 * 1、设置订单的状态为3
	 * 2、更新子订单的状态(将未消费的子订单设置为0)
	 * 3、给退款表记录中插入数据
	 */
	public boolean UserApplyRefund(String orderNum,int reason){
		boolean flag = false;
		HibernateSessionManager.getThreadLocalTransaction();
		try{
			//设置订单状态和子订单状态
			if(this.orderdao.updateOrderStatus(orderNum,3) > 0 && 
					this.sonorderdao.updateSonNotConsumeOrderStatus(orderNum) > 0){
				//插入退款表
				TOrderrefund refund = new TOrderrefund();
				refund.setOrderNum(orderNum);
				refund.setOrderrefundReason(reason);
				refund.setOrderrefundStatus(0);
				refund.setOrderrefundResult(0);
				if(this.refunddao.insertOrderRefund(refund) > 0){
					this.close();
					flag = true;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			this.roll();
		}
		return flag;
	}
	/**
	 * TODO 等待修改
	 * @param userID
	 * @param start
	 * @param end
	 * @param pageStart
	 * @param pageLimit
	 * @return
	 */
	public List<Object[]> searchUserOrderByDate(int userID,String start,String end,int pageStart,int pageLimit){
		List<Object[]> res = null;
		try{
			res = this.orderdao.getUserOrderByDate(userID, start, end, pageStart, pageLimit);
		}catch(Exception e){
			e.printStackTrace();
			res = null;
		}
		this.close();
		return res;
	}
	/**
	 * 根据子订单的id获取子订单分派状态
	 * @param sonOrderID 子订单id
	 * @return 返回值第一个表示状态是否开启
	 */
	public List<TSorderDispatching> getSonOrderDispatchStatus(int sonOrderID){
		List<TSorderDispatching> res = new ArrayList<TSorderDispatching>();
		//查看父订单的分配状态功能是否开启
		try{
			if(sonorderdao.getOrderDisStatusIsOpenBySonOrderID(sonOrderID) == 1){
				//获取子订单的分派列表
				res = this.sonDisDao.findSorderDispatchingBySOrderId(sonOrderID);
			}
		}catch(Exception e){
			e.printStackTrace();
			res = null;
		}
		this.close();
		return res;
		
	}
	/**
	 * 根据用户的中西餐选择以及地址信息获取随机的菜品
	 * @param menuWestern 菜品是否为西餐
	 * @param dispatchID 订单地址id
	 * @return
	 */
	private int getRandomMenuID(int menuWestern,int dispatchID){
		int res = -1;
		//根据订单的地址id获取商圈id
		int bussAreaID = -1;
		TDispatching tdis = this.disDao.findDispatchingById(dispatchID);
		if(tdis!= null){
			bussAreaID = tdis.getDispatchingBusinessAreaid();
			//根据获取的商圈id获取菜品列表，然后随机选取菜品id
			List<Integer> menuids = this.menuDao.findMenuIdsByBussAreaID(bussAreaID,menuWestern);
			if(menuids != null && menuids.size() > 0){
				int num = (int)(Math.random() * menuids.size());
				res = menuids.get(num);
			}
		}
		return res;
	}
}
