/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ims.transactionEngine.InventoryService;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.ims.dao.entity.ImsLogindetails;
import org.ims.dao.entity.ImsManageorderdetails;
import org.ims.dao.entity.ImsManageorders;
import org.ims.dao.entity.ImsStockdetails;
import org.ims.dao.entitydao.ImsDealerDetailsDAO;
import org.ims.dao.entitydao.ImsManageorderdetailsDAO;
import org.ims.dao.entitydao.ImsManageordersDAO;
import org.ims.dao.entitydao.ImsProductdetailsDAO;
import org.ims.dao.entitydao.ImsSupplierDetailsDAO;
import org.ims.transactionEngine.model.OrderDetailsModel;
import org.ims.transactionEngine.model.OrderManagementModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Suresh Kumar V
 */
public class OrderManagementService {
    @Autowired
    ImsManageordersDAO imsmanageorders;
    @Autowired
    ImsProductdetailsDAO imsProductdetailsDAO ;
    @Autowired
    ImsDealerDetailsDAO imsDealerDetailsDAO;
    @Autowired
    ImsSupplierDetailsDAO imsSupplierDetailsDAO;
    @Autowired
    ImsManageorderdetailsDAO  imsManageorderdetailsDAO;
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public ImsManageorders saveOrder(OrderManagementModel Orders, ImsLogindetails logininfo,int OrderType) throws Exception {
        ImsManageorders order = new ImsManageorders();
        String generatedorderno;
        if (Orders.getGeneratedOrderNo()==null){
        	generatedorderno=imsGenerateOrderNumber();
                order.setGeneratedOrderNo(generatedorderno);
        }else{
        	order.setGeneratedOrderNo(Orders.getGeneratedOrderNo());
        	generatedorderno=order.getGeneratedOrderNo();
                order.setOderNumber(imsmanageorders.findOne(" GeneratedOrderNo='"+ Orders.getGeneratedOrderNo() +"'").getOderNumber());
                
        }
        
        List<ImsManageorderdetails> orderdetails = new ArrayList<ImsManageorderdetails>();
        
        order.setOrderFor(Orders.getOrderFor());
        order.setOrderRaisedBy(Orders.getDealerorsupplierno());
        order.setOrderRaisedDate(Orders.getOrderdate());
        if(OrderType==1) // FORM ORDER
        {
            order.setOrderStatus(1); // 1 =Order Raised 2=OrderRaised and Invoice// 3=Cleared 4=Cancelled
        }else if (OrderType==2) //FROM INVOICE
        {
            order.setOrderStatus(2); // 1 =Order Raised 2=OrderRaised and Invoice// 3=Cleared 4=Cancelled
        }
        order.setOrderType(OrderType);
        for (OrderDetailsModel orders : Orders.getproducts()) {
            ImsManageorderdetails orderdetail = new ImsManageorderdetails();
            if (Orders.getGeneratedOrderNo()!=null){
        	orderdetail.setId(orders.getId());
            }            
            orderdetail.setImsManageorders(order);
            orderdetail.setImsProductdetails(imsProductdetailsDAO.findOne(("productCode='" + orders.getProductcode()) + "'"));
            orderdetail.setOrderQuantity(orders.getOrderQuantity());
            orderdetail.setTotalPrice(orders.getAmount());
            orderdetail.setImsLogindetails(logininfo);
            orderdetail.setEnteredDate(Orders.getEnteredDate());
            orderdetail.setUnitPrice(orders.getUnitPrice());
			orderdetail.setDiscount(orders.getDiscount());
			orderdetail.setVat(orders.getVAT());
			orderdetail.setTotalPrice(orders.getTotalPrice());
			orderdetail.setMarginPrecnt(orders.getMarginPrecnt());
			orderdetail.setMarginAmt(orders.getMarginAmt());
			orderdetail.setDealerPrice(orders.getDealerPrice());
            orderdetails.add(orderdetail);
        }
        order.setImsManageorderdetailses(new HashSet<>(orderdetails));
        order.setEnteredDate(Orders.getEnteredDate());
        order.setImsLogindetails(logininfo);
        imsmanageorders.SaveOrUpdateOrder(order);
        return order;

    }
  
    public List<OrderManagementModel> getOrderList(String key,String Value) throws Exception {
        List<OrderManagementModel> ordList = new ArrayList<>();
        List<ImsManageorders> orders=null;
        if(key.equalsIgnoreCase("ALL")){
         orders = imsmanageorders.findAll();
        }
        if(key.equalsIgnoreCase("OrderRaisedBy")){
         orders = imsmanageorders.findAllByValue(" OrderRaisedBy='" +Value +"'");
        }
        if(key.equalsIgnoreCase("OrderFor")){
         orders = imsmanageorders.findAllByValue(" OrderFor='" +Value +"'");
        }
        if(key.equalsIgnoreCase("OrderStatus")){
         orders = imsmanageorders.findAllByValue(" OrderStatus='" +Value+"'");
        }
        
        for (ImsManageorders order : orders) {
            OrderManagementModel ordObj = new OrderManagementModel();
            List<OrderDetailsModel> ordDetailList = new ArrayList<>();
            ordObj.setOrderNumber(order.getOderNumber());
            ordObj.setDealerorsupplierno(order.getOrderRaisedBy());
            if(order.getOrderRaisedBy().contains("DE")){
            ordObj.setDealerorsuppliername(imsDealerDetailsDAO.findOne(" DealerNumber='" + order.getOrderRaisedBy() + "'").getCompanyName());
            }
            if(order.getOrderRaisedBy().contains("SE")){
            ordObj.setDealerorsuppliername(imsSupplierDetailsDAO.findOne(" SupplierNumber='" + order.getOrderRaisedBy() + "'").getCompanyName());
            }
            ordObj.setOrderFor(order.getOrderFor());
            ordObj.setOrderdate(order.getOrderRaisedDate());
            ordObj.setGeneratedOrderNo(order.getGeneratedOrderNo());
            ordObj.setOrderstatus(order.getOrderStatus());
//            order.getImsManageorderdetailses().size();
            Set<ImsManageorderdetails> ordDetails =  order.getImsManageorderdetailses();
//            List<ImsManageorderdetails> ordDetails=imsManageorderdetailsDAO.findAllByValue(" OrderNumber='"+order.getOderNumber().toString() + "'");
            for (ImsManageorderdetails ordDetail : ordDetails) {
                OrderDetailsModel orddetailModel = new OrderDetailsModel();
                orddetailModel.setId(ordDetail.getId());
                orddetailModel.setOrderNumber(ordDetail.getImsManageorders().getOderNumber());
                orddetailModel.setProductcode(ordDetail.getImsProductdetails().getProductCode());
                orddetailModel.setProductname(ordDetail.getImsProductdetails().getProductName());
                orddetailModel.setUnits(ordDetail.getImsProductdetails().getUnits());
                orddetailModel.setOrderQuantity(ordDetail.getOrderQuantity());
                orddetailModel.setAmount(ordDetail.getTotalPrice());
                orddetailModel.setBasicRate(ordDetail.getUnitPrice());
                orddetailModel.setDiscount(ordDetail.getDiscount());
                orddetailModel.setDispatchedQuantity(ordDetail.getDispatchedQuantity());
                orddetailModel.setEnteredDate(ordDetail.getEnteredDate());
                orddetailModel.setParticulars(ordDetail.getParticulars());
                orddetailModel.setVAT(ordDetail.getVat());
                ordDetailList.add(orddetailModel);
            }
            ordObj.setproducts(ordDetailList);
            ordObj.setEnteredBy(order.getImsLogindetails().getUserName());
            ordObj.setEnteredDate(order.getEnteredDate());
            ordList.add(ordObj);
        }
        return ordList;
    }
     public String imsGenerateOrderNumber() {
        String imsv_newdealerno = "";
        int tmpdealerno;
        List<Map> data = imsmanageorders.imsGetMaxOrderNumber();
        if (!data.isEmpty()) {
            Map imsdealerinfo = data.get(0);
            if (Integer.parseInt(imsdealerinfo.get("GeneratedOrderNo").toString()) == 0) {
                imsv_newdealerno = paddzero("1");
            } else {
                tmpdealerno = Integer.parseInt(imsdealerinfo.get("GeneratedOrderNo").toString()) + 1;
                imsv_newdealerno = paddzero(Integer.toString(tmpdealerno));
            }
        }

        return imsv_newdealerno;
    }

    private String paddzero(String tmp) {

        int len = 0;
        String zero = "";
        len = tmp.length();

        for (int i = 1; i <= (10 - (len + 7)); i++) {
            zero = zero + "0";
        }
        return "ORD" + zero + tmp;
    }
    
}
