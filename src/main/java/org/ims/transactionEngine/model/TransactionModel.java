/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ims.transactionEngine.model;

import java.math.BigDecimal;
import java.util.Date;
import org.ims.dao.entity.ImsInvoiceMaster;
import org.ims.dao.entity.ImsLogindetails;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author skumar
 */
public class TransactionModel {
     
	 @JsonProperty
     private Integer transactionId;
	 @JsonProperty
     private String InvoiceNo;
	 @JsonProperty
     private Date TransactionDate;
	 @JsonProperty
     private String PaymentMethod;
	 @JsonProperty
     private Integer CrDrType;
	 @JsonProperty
     private String Description;
//     private Integer vocherNo;
	 @JsonProperty
     private BigDecimal TransactionAmount;
//     private String gl;
//     private String chequeNo;
//     private Date chequeDate;
//     private Integer chequeStatus;
	 @JsonProperty
     private Date EnteredDate;
	 
	 @JsonProperty
	 private boolean TranStatus;
    
	 
    public boolean isTranStatus() {
		return TranStatus;
	}

	public void setTranStatus(boolean tranStatus) {
		TranStatus = tranStatus;
	}

	public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public String getInvoiceNo() {
        return InvoiceNo;
    }

    public void setInvoiceNo(String InvoiceNo) {
        this.InvoiceNo = InvoiceNo;
    }

    public Date getTransactionDate() {
        return TransactionDate;
    }

    public void setTransactionDate(Date TransactionDate) {
        this.TransactionDate = TransactionDate;
    }

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(String PaymentMethod) {
        this.PaymentMethod = PaymentMethod;
    }

    public BigDecimal getTransactionAmount() {
        return TransactionAmount;
    }

    public void setTransactionAmount(BigDecimal TransactionAmount) {
        this.TransactionAmount = TransactionAmount;
    }

    public Integer getCrDrType() {
        return CrDrType;
    }

    public void setCrDrType(Integer CrDrType) {
        this.CrDrType = CrDrType;
    }

    public Date getEnteredDate() {
        return EnteredDate;
    }

    public void setEnteredDate(Date EnteredDate) {
        this.EnteredDate = EnteredDate;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }


    
}
