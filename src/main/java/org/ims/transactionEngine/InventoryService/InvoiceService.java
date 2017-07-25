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
import org.ims.dao.entity.ImsInvoiceMaster;
import org.ims.dao.entity.ImsLogindetails;
import org.ims.dao.entity.ImsManageorderdetails;
import org.ims.dao.entity.ImsManageorders;
import org.ims.dao.entity.ImsStockdetails;
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
import org.ims.transactionEngine.securityManager.ApplicationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Suresh Kumar V
 */
public class InvoiceService {
	@Autowired
	ImsManageordersDAO imsmanageorders;
	@Autowired
	ImsProductdetailsDAO imsProductdetailsDAO;
	@Autowired
	ImsDealerDetailsDAO imsDealerDetailsDAO;
	@Autowired
	ImsSupplierDetailsDAO imsSupplierDetailsDAO;
	@Autowired
	ImsManageorderdetailsDAO imsManageorderdetailsDAO;
	@Autowired
	OrderManagementService ordmgmt;
	@Autowired
	ImsInvoiceMasterDAO imsInvoiceDAO;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public String ProcessInvoice(OrderManagementModel Orders, InvoiceModel invoicedet, ImsLogindetails logininfo)
			throws ParseException, Exception {

		ImsManageorders order = new ImsManageorders();
		String generatedorderno;
		// Boolean NEW_ORDER_FLAG;
		// if (Orders.getGeneratedOrderNo() == null) {
		// generatedorderno = ordmgmt.imsGenerateOrderNumber();
		// NEW_ORDER_FLAG = true;
		// } else {
		// generatedorderno = Orders.getGeneratedOrderNo();
		// order.setOderNumber(Orders.getOrderNumber());
		// NEW_ORDER_FLAG = false;
		// }
		// List<ImsManageorderdetails> orderdetails = new
		// ArrayList<ImsManageorderdetails>();
		// order.setGeneratedOrderNo(generatedorderno);
		// order.setOrderFor(Orders.getOrderFor());
		// order.setOrderRaisedBy(Orders.getDealerorsupplierno());
		// order.setOrderRaisedDate(invoicedet.getInvoicedate());
		// order.setOrderStatus(2); // 1 =Order Raised 2=OrderRaised and
		// Invoice// 3=Cleared 4=Cancelled
		// order.setOrderType(2); // If through invoice 2 ;From Order 1
		//
		// for (OrderDetailsModel orders : Orders.getproducts()) {
		// ImsManageorderdetails orderdetail = new ImsManageorderdetails();
		// orderdetail.setImsManageorders(order);
		//// if (!NEW_ORDER_FLAG) {
		//// orderdetail.setId(imsManageorderdetailsDAO.findOne(
		//// "ProductCode='" + orders.getProductcode() + "' and OrderNumber='" +
		// order.getOderNumber() + "'")
		//// .getId());
		//// }
		// orderdetail.setImsProductdetails(
		// imsProductdetailsDAO.findOne(("productCode='" +
		// orders.getProductcode()) + "'"));
		// orderdetail.setOrderQuantity(orders.getOrderQuantity());
		// orderdetail.setTotalPrice(orders.getAmount());
		// orderdetail.setImsLogindetails(logininfo);
		// orderdetail.setEnteredDate(Orders.getEnteredDate());
		// orderdetail.setUnitPrice(orders.getUnitPrice());
		// orderdetail.setDiscount(orders.getDiscount());
		// orderdetail.setVat(orders.getVAT());
		// orderdetail.setTotalPrice(orders.getTotalPrice());
		// orderdetail.setMarginPrecnt(orders.getMarginPrecnt());
		// orderdetail.setMarginAmt(orders.getMarginAmt());
		// orderdetail.setDealerPrice(orders.getDealerPrice());
		// orderdetails.add(orderdetail);
		//
		// }
		//
		// order.setImsManageorderdetailses(new HashSet<>(orderdetails));
		// order.setEnteredDate(Orders.getEnteredDate());
		// order.setImsLogindetails(logininfo);

		order = ordmgmt.saveOrder(Orders, logininfo, 2); // save the order
		// All set for order
		List<ImsInvoiceMaster> InvoiceList = new ArrayList<ImsInvoiceMaster>();
		ImsInvoiceMaster invoice = new ImsInvoiceMaster();
		ImsTransactiondetails transaction = new ImsTransactiondetails();
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
		invoice.setBalanceAmount(invoicedet.getFinalAmount());
		invoice.setImsManageorders(order);
		invoice.setInvoiceStatus(1); // 1=Invoice Raised ; 2=Partial
										// Payment;3=Cleared;
		invoice.setEnteredDate(invoicedet.getEnteredDate());
		invoice.setImsLogindetails(logininfo);
		InvoiceList.add(invoice);
		// order.setImsInvoiceMasters(new HashSet<>(InvoiceList));

		imsInvoiceDAO.saveInvoice(invoice, transaction);
		return order.getGeneratedOrderNo();
	}

	public String getSalesInvoiceNo() {
		long invoiceno = 0;

		String sql = "SELECT (CASE WHEN COALESCE(Max(substr(InvoiceNo,8,19)),0)='' THEN 0 ELSE COALESCE(Max(substr(InvoiceNo,8,19)),0) END)  as InvoiceNo FROM Ims_InvoiceMaster M JOIN ims_manageorders ON M.OrderNo=ims_manageorders.OderNumber where ims_manageorders.OrderFor='Dealer'";
		List<Map> data = imsInvoiceDAO.executeCustomSQL(sql);
		if (!data.isEmpty()) {
			Map datamap = data.get(0);
			if (Integer.parseInt(datamap.get("InvoiceNo").toString()) == 0) {
				invoiceno = 0;
			} else {
				invoiceno = Integer.parseInt(datamap.get("InvoiceNo").toString());

			}
		}

		return ApplicationUtil.GenerateInvoiceNumber(invoiceno);
	}

	public InvoiceModel getInvoiceDetailsByNo(String InvoiceNo) {
		InvoiceModel inv = new InvoiceModel();
		ImsInvoiceMaster invoice = imsInvoiceDAO.findOne(" InvoiceNo='" + InvoiceNo + "'");
		inv.setInvoiceNo(invoice.getInvoiceNo());
		inv.setInvoicedate(invoice.getInvoiceDate());
		inv.setRepName(invoice.getRepName());
		inv.setPaymentDueDt(invoice.getPaymentDueDate());
		inv.setExpectedDeliveryDate(invoice.getExpectedDelivery());
		inv.setPaymentTerms(invoice.getPaymentTerms());
		inv.setFreightTerms(invoice.getFrieghtTerms());
		inv.setDeliveryTerms(invoice.getDeliveryTerm());
		inv.setDestination(invoice.getDestination());
		inv.setTransporter(invoice.getTransporter());
		inv.setTransporterMode(invoice.getTransportMode());
		inv.setESugamaNo(invoice.getEsugmaNo());
		inv.setNoOfPacks(invoice.getNoOfPack());
		inv.setGrossweight(invoice.getGrossWieght());
		inv.setLrnoAndDate(invoice.getLrnoAndDate());
		inv.setFAFcharges(invoice.getFafcharges());
		inv.setGrossAmount(invoice.getGrossAmount());
		inv.setExcessPercentage(invoice.getExcisePercentage());
		inv.setExcessRate(invoice.getExciseRate());
		inv.setEducationCessPercentage(invoice.getEducationCessPercentage());
		inv.setEducationCessRate(invoice.getEducationCessRate());
		inv.setSecondaryEducationCessPercentage(invoice.getSecEducCessPercentage());
		inv.setSecondaryEducationCessRate(invoice.getSecEducCessRate());
		inv.setCSTPercentage(invoice.getCstpercentage());
		inv.setCSTRate(invoice.getCstrate());
		inv.setVat1Rate(invoice.getVattotal1());
		inv.setVat2Rate(invoice.getVattotal2());
		inv.setRoundOff(invoice.getRoundOff());
		inv.setFinalAmount(invoice.getTotalAmount());
		inv.setBalanceAmount(invoice.getBalanceAmount());
		inv.setInvoiceStatus(invoice.getInvoiceStatus()); // 1=Invoice Raised ;
															// 2=Partial
															// Payment;3=Cleared;
		inv.setEnteredDate(invoice.getEnteredDate());

		return inv;
	}

	public List<InvoiceModel> getInvoiceDetailsList(String searchkey) {
		List<InvoiceModel> invList = new ArrayList<>();
		// ImsInvoiceMaster invoice=imsInvoiceDAO.findOne("
		// InvoiceNo='"+InvoiceNo+"'");
		for (ImsInvoiceMaster invoice : imsInvoiceDAO.findAll()) {
			InvoiceModel inv = new InvoiceModel();
			inv.setInvoiceNo(invoice.getInvoiceNo());
			inv.setInvoicedate(invoice.getInvoiceDate());
			inv.setRepName(invoice.getRepName());
			inv.setPaymentDueDt(invoice.getPaymentDueDate());
			inv.setExpectedDeliveryDate(invoice.getExpectedDelivery());
			inv.setPaymentTerms(invoice.getPaymentTerms());
			inv.setFreightTerms(invoice.getFrieghtTerms());
			inv.setDeliveryTerms(invoice.getDeliveryTerm());
			inv.setDestination(invoice.getDestination());
			inv.setTransporter(invoice.getTransporter());
			inv.setTransporterMode(invoice.getTransportMode());
			inv.setESugamaNo(invoice.getEsugmaNo());
			inv.setNoOfPacks(invoice.getNoOfPack());
			inv.setGrossweight(invoice.getGrossWieght());
			inv.setLrnoAndDate(invoice.getLrnoAndDate());
			inv.setFAFcharges(invoice.getFafcharges());
			inv.setGrossAmount(invoice.getGrossAmount());
			inv.setExcessPercentage(invoice.getExcisePercentage());
			inv.setExcessRate(invoice.getExciseRate());
			inv.setEducationCessPercentage(invoice.getEducationCessPercentage());
			inv.setEducationCessRate(invoice.getEducationCessRate());
			inv.setSecondaryEducationCessPercentage(invoice.getSecEducCessPercentage());
			inv.setSecondaryEducationCessRate(invoice.getSecEducCessRate());
			inv.setCSTPercentage(invoice.getCstpercentage());
			inv.setCSTRate(invoice.getCstrate());
			inv.setVat1Rate(invoice.getVattotal1());
			inv.setVat2Rate(invoice.getVattotal2());
			inv.setRoundOff(invoice.getRoundOff());
			inv.setFinalAmount(invoice.getTotalAmount());
			inv.setBalanceAmount(invoice.getBalanceAmount());
			inv.setInvoiceStatus(invoice.getInvoiceStatus()); // 1=Invoice Raised ; 2=Partial; Payment;3=Cleared;
			inv.setEnteredDate(invoice.getEnteredDate());
			inv.setOrderNo(invoice.getImsManageorders().getGeneratedOrderNo());
			inv.setInvoiceFor(invoice.getImsManageorders().getOrderFor());
			invList.add(inv);
		}

		return invList;
	}

}
