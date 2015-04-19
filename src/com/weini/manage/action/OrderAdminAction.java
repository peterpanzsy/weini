package com.weini.manage.action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.weini.manage.business.OrderAdminService;
import com.weini.manage.entity.TOrder;


public class OrderAdminAction extends ActionSupport {
    List<TOrder> dataList;
    String result;
    String dateStart;
    String dateEnd;
    int orderTotal;
    double orderSum;
    OrderAdminService orderAdminService = new OrderAdminService();


    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String listOrder() {//根据角色获取账户列表
        dataList = orderAdminService.getOrderList(dateStart,dateEnd);
        return "SUCCESS";
    }

    public String countOrder() {
        DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        try {
            Date start = format.parse(dateStart);
            Date end = format.parse(dateEnd);
            orderTotal = orderAdminService.getOrderTotal(start,end);
            orderSum = orderAdminService.getOrderSum(start,end);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        orderAdminService.close();
        return "SUCCESS";
    }

    public double getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(double orderSum) {
        this.orderSum = orderSum;
    }

    public int getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(int orderTotal) {
        this.orderTotal = orderTotal;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public List<TOrder> getDataList() {
        return dataList;
    }

    public void setDataList(List<TOrder> dataList) {
        this.dataList = dataList;
    }
}
