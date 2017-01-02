/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ims.transactionEngine.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Suresh Kumar V
 */
public class OrderDetailsModel {

    @JsonProperty
    private Integer id;
    @JsonProperty
    private String productcode;
    @JsonProperty
    private String productname;
    @JsonProperty
    private Long orderQuantity;
    @JsonProperty
    private String units;
    @JsonProperty
    private Long dispatchedQuantity;
    @JsonProperty
    private BigDecimal basicRate;
    @JsonProperty
    private Double Discount;
    @JsonProperty
    private String particulars;
    @JsonProperty
    private Double VAT;
    @JsonProperty
    private BigDecimal amount;
    @JsonProperty
    private Date enteredDate;
    @JsonProperty
    private Date lasModifiedDate;
    @JsonProperty
    private Long modifedBy;
    @JsonProperty
    private BigDecimal UnitPrice;
    @JsonProperty
    private BigDecimal TotalPrice;
    @JsonProperty
    private Double MarginPrecnt;
    @JsonProperty
    private BigDecimal MarginAmt;
    @JsonProperty
    private BigDecimal DealerPrice;
    

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }
    public Long getOrderNumber() {
        return OrderNumber;
    }

    public void setOrderNumber(Long OrderNumber) {
        this.OrderNumber = OrderNumber;
    }
    @JsonProperty
    private Long OrderNumber;
    
    public String getProductcode() {
        return productcode;
    }

    public void setProductcode(String productcode) {
        this.productcode = productcode;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(Long orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public Long getDispatchedQuantity() {
        return dispatchedQuantity;
    }

    public void setDispatchedQuantity(Long dispatchedQuantity) {
        this.dispatchedQuantity = dispatchedQuantity;
    }

    public BigDecimal getBasicRate() {
        return basicRate;
    }

    public void setBasicRate(BigDecimal basicRate) {
        this.basicRate = basicRate;
    }

    public Double getDiscount() {
        return Discount;
    }

    public void setDiscount(Double Discount) {
        this.Discount = Discount;
    }

    public String getParticulars() {
        return particulars;
    }

    public void setParticulars(String particulars) {
        this.particulars = particulars;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getEnteredDate() {
        return enteredDate;
    }

    public void setEnteredDate(Date enteredDate) {
        this.enteredDate = enteredDate;
    }

    public Date getLasModifiedDate() {
        return lasModifiedDate;
    }

    public void setLasModifiedDate(Date lasModifiedDate) {
        this.lasModifiedDate = lasModifiedDate;
    }

    public Long getModifedBy() {
        return modifedBy;
    }

    public void setModifedBy(Long modifedBy) {
        this.modifedBy = modifedBy;
    }

    public Double getVAT() {
        return VAT;
    }

    public void setVAT(Double VAT) {
        this.VAT = VAT;
    }

    public BigDecimal getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(BigDecimal UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public BigDecimal getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(BigDecimal TotalPrice) {
        this.TotalPrice = TotalPrice;
    }

    public Double getMarginPrecnt() {
        return MarginPrecnt;
    }

    public void setMarginPrecnt(Double MarginPrecnt) {
        this.MarginPrecnt = MarginPrecnt;
    }

    public BigDecimal getMarginAmt() {
        return MarginAmt;
    }

    public void setMarginAmt(BigDecimal MarginAmt) {
        this.MarginAmt = MarginAmt;
    }

    public BigDecimal getDealerPrice() {
        return DealerPrice;
    }

    public void setDealerPrice(BigDecimal DealerPrice) {
        this.DealerPrice = DealerPrice;
    }
    

}
