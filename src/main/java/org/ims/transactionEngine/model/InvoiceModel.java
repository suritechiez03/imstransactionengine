/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ims.transactionEngine.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.Date;

import org.ims.dao.entity.ImsManageorders;

/**
 *
 * @author Suresh Kumar V
 */
public class InvoiceModel {

    @JsonProperty
    private String InvoiceNo;
//     private ImsLogindetails imsLogindetails;
    @JsonProperty
    private String OrderNo;
    
    @JsonProperty
    private String InvoiceFor;
    
	@JsonProperty
    private String InvoiceType;
    @JsonProperty
    private Date Invoicedate;
    @JsonProperty
    private Date PaymentDueDt;
    @JsonProperty
    private String RepName;
    @JsonProperty
    private String PaymentTerms;
    @JsonProperty
    private String FreightTerms;
    @JsonProperty
    private String DeliveryTerms;
    @JsonProperty
    private String Transporter;
    @JsonProperty
    private String TransporterMode;
    @JsonProperty
    private String ESugamaNo;
    @JsonProperty
    private String Destination;
    @JsonProperty
    private String lrnoAndDate;
    @JsonProperty
    private Date ExpectedDeliveryDate;
    @JsonProperty
    private String NoOfPacks;
    @JsonProperty
    private String Grossweight;
    @JsonProperty
    private BigDecimal FAFcharges;
    @JsonProperty
    private BigDecimal GrossAmount;
    @JsonProperty
    private BigDecimal excessPercentage;
    @JsonProperty
    private BigDecimal excessRate;
    @JsonProperty
    private BigDecimal educationCessPercentage;
    @JsonProperty
    private BigDecimal educationCessRate;
    @JsonProperty
    private BigDecimal secondaryEducationCessPercentage;
    @JsonProperty
    private BigDecimal secondaryEducationCessRate;
    @JsonProperty
    private BigDecimal CSTPercentage;
    @JsonProperty
    private BigDecimal CSTRate;
    @JsonProperty
    private BigDecimal VAT1;
    @JsonProperty
    private BigDecimal VAT2;
    @JsonProperty
    private BigDecimal Vat1Rate;
    @JsonProperty
    private BigDecimal Vat2Rate;
    @JsonProperty
    private BigDecimal RoundOff;
    @JsonProperty
    private BigDecimal FinalAmount;
    @JsonProperty
    private BigDecimal balanceAmount;
    @JsonProperty
    private Integer invoiceStatus;
    @JsonProperty
    private Date enteredDate;
   
    @JsonProperty
    private String GeneratedOrderNo;
      
    public String getGeneratedOrderNo() {
        return GeneratedOrderNo;
    }

    public void setGeneratedOrderNo(String GeneratedOrderNo) {
        this.GeneratedOrderNo = GeneratedOrderNo;
    }
    public String getInvoiceNo() {
        return InvoiceNo;
    }

    public void setInvoiceNo(String InvoiceNo) {
        this.InvoiceNo = InvoiceNo;
    }

    public String getInvoiceFor() {
        return InvoiceFor;
    }

    public void setInvoiceFor(String InvoiceFor) {
        this.InvoiceFor = InvoiceFor;
    }

    public String getInvoiceType() {
        return InvoiceType;
    }

    public void setInvoiceType(String InvoiceType) {
        this.InvoiceType = InvoiceType;
    }

    public Date getInvoicedate() {
        return Invoicedate;
    }

    public void setInvoicedate(Date Invoicedate) {
        this.Invoicedate = Invoicedate;
    }

    public Date getPaymentDueDt() {
        return PaymentDueDt;
    }

    public void setPaymentDueDt(Date PaymentDueDt) {
        this.PaymentDueDt = PaymentDueDt;
    }

    public String getRepName() {
        return RepName;
    }

    public void setRepName(String RepName) {
        this.RepName = RepName;
    }

    public String getPaymentTerms() {
        return PaymentTerms;
    }

    public void setPaymentTerms(String PaymentTerms) {
        this.PaymentTerms = PaymentTerms;
    }

    public String getFreightTerms() {
        return FreightTerms;
    }

    public void setFreightTerms(String FreightTerms) {
        this.FreightTerms = FreightTerms;
    }

    public String getDeliveryTerms() {
        return DeliveryTerms;
    }

    public void setDeliveryTerms(String DeliveryTerms) {
        this.DeliveryTerms = DeliveryTerms;
    }

    public String getTransporter() {
        return Transporter;
    }

    public void setTransporter(String Transporter) {
        this.Transporter = Transporter;
    }

    public String getTransporterMode() {
        return TransporterMode;
    }

    public void setTransporterMode(String TransporterMode) {
        this.TransporterMode = TransporterMode;
    }

    public String getESugamaNo() {
        return ESugamaNo;
    }

    public void setESugamaNo(String ESugamaNo) {
        this.ESugamaNo = ESugamaNo;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String Destination) {
        this.Destination = Destination;
    }

    public String getLrnoAndDate() {
        return lrnoAndDate;
    }

    public void setLrnoAndDate(String lrnoAndDate) {
        this.lrnoAndDate = lrnoAndDate;
    }

    public Date getExpectedDeliveryDate() {
        return ExpectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(Date ExpectedDeliveryDate) {
        this.ExpectedDeliveryDate = ExpectedDeliveryDate;
    }

    public String getNoOfPacks() {
        return NoOfPacks;
    }

    public void setNoOfPacks(String NoOfPacks) {
        this.NoOfPacks = NoOfPacks;
    }

    public String getGrossweight() {
        return Grossweight;
    }

    public void setGrossweight(String Grossweight) {
        this.Grossweight = Grossweight;
    }

    public BigDecimal getFAFcharges() {
        return FAFcharges;
    }

    public void setFAFcharges(BigDecimal FAFcharges) {
        this.FAFcharges = FAFcharges;
    }

    public BigDecimal getGrossAmount() {
        return GrossAmount;
    }

    public void setGrossAmount(BigDecimal GrossAmount) {
        this.GrossAmount = GrossAmount;
    }

    public BigDecimal getExcessPercentage() {
        return excessPercentage;
    }

    public void setExcessPercentage(BigDecimal excessPercentage) {
        this.excessPercentage = excessPercentage;
    }

    public BigDecimal getExcessRate() {
        return excessRate;
    }

    public void setExcessRate(BigDecimal excessRate) {
        this.excessRate = excessRate;
    }

    public BigDecimal getEducationCessPercentage() {
        return educationCessPercentage;
    }

    public void setEducationCessPercentage(BigDecimal educationCessPercentage) {
        this.educationCessPercentage = educationCessPercentage;
    }

    public BigDecimal getEducationCessRate() {
        return educationCessRate;
    }

    public void setEducationCessRate(BigDecimal educationCessRate) {
        this.educationCessRate = educationCessRate;
    }

    public BigDecimal getSecondaryEducationCessPercentage() {
        return secondaryEducationCessPercentage;
    }

    public void setSecondaryEducationCessPercentage(BigDecimal secondaryEducationCessPercentage) {
        this.secondaryEducationCessPercentage = secondaryEducationCessPercentage;
    }

    public BigDecimal getSecondaryEducationCessRate() {
        return secondaryEducationCessRate;
    }

    public void setSecondaryEducationCessRate(BigDecimal secondaryEducationCessRate) {
        this.secondaryEducationCessRate = secondaryEducationCessRate;
    }

    public BigDecimal getCSTPercentage() {
        return CSTPercentage;
    }

    public void setCSTPercentage(BigDecimal CSTPercentage) {
        this.CSTPercentage = CSTPercentage;
    }

    public BigDecimal getCSTRate() {
        return CSTRate;
    }

    public void setCSTRate(BigDecimal CSTRate) {
        this.CSTRate = CSTRate;
    }

    public BigDecimal getVAT1() {
        return VAT1;
    }

    public void setVAT1(BigDecimal VAT1) {
        this.VAT1 = VAT1;
    }

    public BigDecimal getVAT2() {
        return VAT2;
    }

    public void setVAT2(BigDecimal VAT2) {
        this.VAT2 = VAT2;
    }

    public BigDecimal getVat1Rate() {
        return Vat1Rate;
    }

    public void setVat1Rate(BigDecimal Vat1Rate) {
        this.Vat1Rate = Vat1Rate;
    }

    public BigDecimal getVat2Rate() {
        return Vat2Rate;
    }

    public void setVat2Rate(BigDecimal Vat2Rate) {
        this.Vat2Rate = Vat2Rate;
    }

    public BigDecimal getRoundOff() {
        return RoundOff;
    }

    public void setRoundOff(BigDecimal RoundOff) {
        this.RoundOff = RoundOff;
    }

    public BigDecimal getFinalAmount() {
        return FinalAmount;
    }

    public void setFinalAmount(BigDecimal FinalAmount) {
        this.FinalAmount = FinalAmount;
    }

    public BigDecimal getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(BigDecimal balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public Integer getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(Integer invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public Date getEnteredDate() {
        return enteredDate;
    }

    public void setEnteredDate(Date enteredDate) {
        this.enteredDate = enteredDate;
    }
    public String getOrderNo() {
		return OrderNo;
	}

	public void setOrderNo(String OrderNo) {
		this.OrderNo = OrderNo;
	}


}
