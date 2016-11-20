/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ims.transactionEngine.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
     private Long orderQuantity;
    @JsonProperty 
     private Long dispatchedQuantity;
    @JsonProperty 
     private Double basicRate;
    @JsonProperty 
     private Double discount;
    @JsonProperty 
     private String particulars;
    @JsonProperty 
     private Double vat;

    public String getProductcode() {
        return productcode;
    }

    public void setProductcode(String productcode) {
        this.productcode = productcode;
    }
    @JsonProperty 
     private Double amount;
    @JsonProperty 
     private Date enteredDate;
    @JsonProperty 
     private Date lasModifiedDate;
    @JsonProperty 
     private Long modifedBy;

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

    public Double getBasicRate() {
        return basicRate;
    }

    public void setBasicRate(Double basicRate) {
        this.basicRate = basicRate;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getParticulars() {
        return particulars;
    }

    public void setParticulars(String particulars) {
        this.particulars = particulars;
    }

    public Double getVat() {
        return vat;
    }

    public void setVat(Double vat) {
        this.vat = vat;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
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
     
}
