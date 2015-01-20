package com.weini.manage.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;

import com.weini.manage.business.Box;
import com.weini.manage.business.BoxType;
import com.weini.manage.business.BusinessArea;
import com.weini.manage.business.OfficeBuilding;
import com.weini.manage.business.User;


public class CSBoxDao extends GeneralDao {

	public CSBoxDao() {
		super();
	}
	
	public List<BoxType> getBoxList(Integer cityId){
		SQLQuery q;
		String sql = ("SELECT t2.typeid,t2.typename,t2.desc1,t2.desc2,t2.desc3,t2.desc4,t2.time"
				+ " FROM  t_boxtype t2 WHERE t2.typeid IN"+""
				+ "(SELECT t1.box_type FROM t_box t1 WHERE box_cityid = ? ) ;" );
		q =session.createSQLQuery(sql);
		q.setInteger(0, cityId);
		List l = q.list();
		List<BoxType> re=new ArrayList<BoxType>();
		for(int i=0;i<l.size();i++){
			Object[] row=(Object[])l.get(i);
			BoxType temp = new BoxType();
			temp.setTypeId((Integer)row[0]);
			temp.setTypeName((String)row[1]);
			temp.setDesc1((String)row[2]);
			temp.setDesc2((String)row[3]);
			temp.setDesc3((String)row[4]);
			temp.setDesc4((String)row[5]);
			temp.setTime((Integer)row[6]);
			re.add(temp);
		}
		return re;
	}

	public List getAreaList(Integer typeId) {
		SQLQuery q;
		String sql = ("SELECT t.businessArea_id,t.businessArea_name FROM t_businessarea t WHERE	businessArea_id IN"+
		"(SELECT bussinessarea_id FROM t_box WHERE box_type = ? );") ;
	
		q =session.createSQLQuery(sql);
		q.setInteger(0, typeId);
		List l = q.list();
		List<BusinessArea> re=new ArrayList();
		for(int i=0;i<l.size();i++){
			Object[] row=(Object[])l.get(i);
			BusinessArea temp = new BusinessArea();
			temp.setBusinessAreaId((Integer)row[0]);
			temp.setBusinessAreaName((String)row[1]);
			re.add(temp);
		}
			return re;
		}
	/**
	 * 由商业区Id得到相应的写字楼列表
	 * @param busId
	 * @return
	 */
	public List getOfficeBuildingList(Integer busId) {
		SQLQuery q;
		String sql = ("SELECT officeBuilding_id,officeBuilding_name,officeBuilding_longitude,officeBuilding_latitude,officeBuilding_radius "+
					" FROM t_officebuilding WHERE businessArea_id = ?");
		q =session.createSQLQuery(sql);
		q.setInteger(0, busId);
		List l = q.list();
		List<OfficeBuilding> re = new ArrayList<>();
		for(int i=0;i<l.size();i++){
			Object[] row = (Object[])l.get(i);
			OfficeBuilding ob = new OfficeBuilding();
			ob.setId((Integer)row[0]);
			ob.setName((String)row[1]);
			ob.setLongitude((Float)row[2]);
			ob.setLatitude((Float)row[3]);
			ob.setRadius((Float)row[4]);
			re.add(ob);
		}
		return re;
	}
}
