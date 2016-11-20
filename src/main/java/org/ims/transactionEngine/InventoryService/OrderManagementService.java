/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ims.transactionEngine.InventoryService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.ims.dao.entity.ImsLogindetails;
import org.ims.dao.entity.ImsManageorderdetails;
import org.ims.dao.entity.ImsManageorders;
import org.ims.dao.entitydao.ImsManageordersDAO;
import org.ims.dao.entitydao.ImsProductdetailsDAO;
import org.ims.transactionEngine.model.OrderDetailsModel;
import org.ims.transactionEngine.model.OrderManagementModel;

/**
 * 
 * @author Suresh Kumar V
 */
public class OrderManagementService {
    ImsManageordersDAO imsmanageorders=new ImsManageordersDAO();
    ImsProductdetailsDAO imsProductdetailsDAO=new ImsProductdetailsDAO();
    
    public boolean saveOrder(OrderManagementModel Orders,ImsLogindetails logininfo){
        ImsManageorders order=new ImsManageorders();
        
        List<ImsManageorderdetails> orderdetails=new ArrayList<ImsManageorderdetails>();
        order.setOrderFor(Orders.getOrderFor());
        order.setOrderRaisedBy(Orders.getDealerorsupplierno());
        order.setOrderRaisedDate(Orders.getOrderdate());
        order.setOrderStatus(1);
        order.setOrderType(1);
        for (OrderDetailsModel orders : Orders.getproducts()) {
         ImsManageorderdetails orderdetail=new ImsManageorderdetails();
         orderdetail.setImsManageorders(order);
         orderdetail.setImsProductdetails(imsProductdetailsDAO.findOne(("productCode='"+orders.getProductcode())+"'"));
         orderdetail.setOrderQuantity(orders.getOrderQuantity());
         orderdetail.setImsLogindetails(logininfo);
         orderdetail.setEnteredDate(Orders.getEnteredDate());
         orderdetails.add(orderdetail);
        }
        order.setImsManageorderdetailses(new HashSet<>(orderdetails));
        order.setEnteredDate(Orders.getEnteredDate());
        order.setImsLogindetails(logininfo);
        imsmanageorders.create(order);
        return true;
        
    }
}
