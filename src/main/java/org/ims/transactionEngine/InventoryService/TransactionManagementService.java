/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ims.transactionEngine.InventoryService;

import java.util.List;
import java.util.Map;

import org.ims.dao.entity.ImsLogindetails;
import org.ims.dao.entity.ImsTransactiondetails;
import org.ims.dao.entitydao.ImsAppSettingDAO;
import org.ims.dao.entitydao.ImsInvoiceMasterDAO;
import org.ims.dao.entitydao.ImsManageordersDAO;
import org.ims.dao.entitydao.ImsTransactionDetailsDAO;
import org.ims.transactionEngine.model.TransactionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author skumar
 */
public class TransactionManagementService {
    @Autowired
    ImsTransactionDetailsDAO imstransaction;
    @Autowired
    ImsInvoiceMasterDAO imsinvoice;
    
    @Autowired
    ImsManageordersDAO imsmanageorders;
    
    @Autowired
    ImsAppSettingDAO appsettings;
    
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int processPayment(TransactionModel tran,ImsLogindetails logininfo){
    	
    	ImsTransactiondetails trandet=new ImsTransactiondetails();
    	
    	switch(tran.getPaymentMethod())
    	{
    	case "Cash"  :
    				 trandet.setTransactionType(1);
    		         break;
    	case "Card"  :
    				 trandet.setTransactionType(2);
    		         break;
    	case "Cheque":
    				 trandet.setTransactionType(3);
    		         break;
    		         
    	}
        
        
        trandet.setImsInvoiceMaster(imsinvoice.findOne(" InvoiceNo='"+tran.getInvoiceNo()+"'"));
        trandet.setTransactionDate(tran.getTransactionDate());
        
        trandet.setTransactionCrdrtype(tran.getCrDrType());
        trandet.setTransactionAmount(tran.getTransactionAmount());
        trandet.setImsLogindetails(logininfo);
        trandet.setEnteredDate(tran.getEnteredDate());
        trandet.setGl(this.getGLCode(tran.getInvoiceNo()));
        trandet.setVocherNo(null);
        trandet.setDescription(tran.getDescription());
        imstransaction.create(trandet);
        return this.getMaxTranId();
    }
    
    public int getMaxTranId(){
    	Map data =imstransaction.executeCustomSQL("select coalesce(MAX(TransactionId),0) as TranID from ims_transactiondetails;").get(0);
    	return  Integer.parseInt(data.get("TranID").toString());
    }
    
    public String getGLCode(String invoiceno){
    	String sql="Select (CASE WHEN MO.OrderFor='Dealer' THEN (Select app_value From ims_appsettings where app_key='SalesGL')"+ 
                                 " WHEN MO.OrderFor='Supplier' THEN (Select app_value From ims_appsettings where app_key='PurchaseGL')"+
                                 " END) as GLCODE from Ims_InvoiceMaster I JOIN ims_manageorders MO On I.OrderNo=MO.OderNumber "+
                                 " Where I.InvoiceNo='"+ invoiceno +"';";								
    	return imstransaction.executeCustomSQL(sql).get(0).get("GLCODE").toString();
    }
    
    
}
