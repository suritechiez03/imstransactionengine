/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ims.transactionEngine.InventoryService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.ims.dao.entity.ImsInvoiceMaster;
import org.ims.dao.entity.ImsLogindetails;
import org.ims.dao.entity.ImsManageorderdetails;
import org.ims.dao.entity.ImsManageorders;
import org.ims.dao.entity.ImsTransactiondetails;
import org.ims.dao.entitydao.ImsDealerDetailsDAO;
import org.ims.dao.entitydao.ImsInvoiceMasterDAO;
import org.ims.dao.entitydao.ImsManageorderdetailsDAO;
import org.ims.dao.entitydao.ImsManageordersDAO;
import org.ims.dao.entitydao.ImsProductdetailsDAO;
import org.ims.dao.entitydao.ImsSupplierDetailsDAO;
import org.ims.transactionEngine.model.InvoiceModel;
import org.ims.transactionEngine.model.OrderDetailsModel;
import org.ims.transactionEngine.model.OrderManagementModel;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Suresh Kumar V
 */
public class InvoiceService {
    @Autowired
    ImsManageordersDAO imsmanageorders ;
    @Autowired
    ImsProductdetailsDAO imsProductdetailsDAO ;
    @Autowired
    ImsDealerDetailsDAO imsDealerDetailsDAO ;
    @Autowired
    ImsSupplierDetailsDAO imsSupplierDetailsDAO ;
    @Autowired
    ImsManageorderdetailsDAO imsManageorderdetailsDAO ;
    @Autowired
    OrderManagementService ordmgmt;
    @Autowired
    ImsInvoiceMasterDAO imsInvoiceDAO;
    
    public String ProcessInvoice(OrderManagementModel Orders, InvoiceModel invoicedet, ImsLogindetails logininfo) {

        ImsManageorders order = new ImsManageorders();
        String generatedorderno = ordmgmt.imsGenerateOrderNumber();
        List<ImsManageorderdetails> orderdetails = new ArrayList<ImsManageorderdetails>();
        order.setGeneratedOrderNo(generatedorderno);
        order.setOrderFor(Orders.getOrderFor());
        order.setOrderRaisedBy(Orders.getDealerorsupplierno());
        order.setOrderRaisedDate(invoicedet.getInvoicedate());
        order.setOrderStatus(1);
        order.setOrderType(1);
        for (OrderDetailsModel orders : Orders.getproducts()) {
            ImsManageorderdetails orderdetail = new ImsManageorderdetails();
            orderdetail.setImsManageorders(order);
            orderdetail.setImsProductdetails(imsProductdetailsDAO.findOne(("productCode='" + orders.getProductcode()) + "'"));
            orderdetail.setOrderQuantity(orders.getOrderQuantity());
            orderdetail.setTotalPrice(orders.getAmount());
            orderdetail.setImsLogindetails(logininfo);
            orderdetail.setEnteredDate(Orders.getEnteredDate());
            orderdetail.setUnitPrice(orders.getUnitPrice());
            orderdetail.setDiscount(orders.getDiscount());
            orderdetail.setTotalPrice(orders.getTotalPrice());
            orderdetail.setMarginPrecnt(orders.getMarginPrecnt());
            orderdetail.setMarginAmt(orders.getMarginAmt());
            orderdetail.setDealerPrice(orders.getDealerPrice());
            orderdetails.add(orderdetail);
        }
        order.setImsManageorderdetailses(new HashSet<>(orderdetails));
        order.setEnteredDate(Orders.getEnteredDate());
        order.setImsLogindetails(logininfo);
        //All set for order
        List<ImsInvoiceMaster> InvoiceList = new ArrayList<ImsInvoiceMaster>();
        ImsInvoiceMaster invoice =new ImsInvoiceMaster();
        ImsTransactiondetails transaction =new ImsTransactiondetails();
        invoice.setInvoiceNo(invoicedet.getInvoiceNo());
        invoice.setInvoiceDate(invoicedet.getInvoicedate());
        invoice.setRepName(invoicedet.getRepName());
        invoice.setPaymentDueDate(invoicedet.getPaymentDueDt());
        invoice.setExpectedDelivery(invoicedet.getExpectedDeliveryDate());
        invoice.setPaymentTerms(invoicedet.getPaymentTerms());
        invoice.setFrieghtTerms(invoicedet.getFreightTerms());
        invoice.setDeliveryTerm(invoicedet.getDeliveryTerms());
        invoice.setTransporter(invoicedet.getTransporter());
        invoice.setTransportMode(invoicedet.getTransporterMode());
        invoice.setEsugmaNo(invoicedet.getESugamaNo());
        invoice.setDestination(invoicedet.getDestination());
        invoice.setNoOfPack(invoicedet.getNoOfPacks());
        invoice.setGrossWieght(invoicedet.getGrossweight());
        invoice.setFafcharges(invoicedet.getFAFcharges());
        invoice.setGrossAmount(invoicedet.getGrossAmount());
        invoice.setExcisePercentage(invoicedet.getExcessPercentage());
        invoice.setExciseRate(invoicedet.getExcessRate());
        invoice.setEducationCessPercentage(invoicedet.getEducationCessPercentage());
        invoice.setEducationCessRate(invoicedet.getEducationCessRate());
        invoice.setSecEducCessPercentage(invoicedet.getSecondaryEducationCessPercentage());
        invoice.setSecEducCessRate(invoicedet.getSecondaryEducationCessRate());
        invoice.setCstpercentage(invoicedet.getCSTPercentage());
        invoice.setCstrate(invoicedet.getCSTRate());
        invoice.setVattotal1(invoicedet.getVat1Rate());
        invoice.setVattotal2(invoicedet.getVat2Rate());
        invoice.setRoundOff(invoicedet.getRoundOff());
        invoice.setTotalAmount(invoicedet.getFinalAmount());
        invoice.setBalanceAmount(invoicedet.getBalanceAmount());
        invoice.setImsManageorders(order);
        InvoiceList.add(invoice);
        order.setImsInvoiceMasters(new HashSet<>(InvoiceList));        
        imsInvoiceDAO.saveInvoice(order, invoice, transaction);
        return generatedorderno;
    }
}
