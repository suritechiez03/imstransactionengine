/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ims.transactionEngine.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/**
 * 
 * @author Suresh Kumar V
 */
public class StockModel {
     @JsonProperty   
     private Long purchasedQty;
     @JsonProperty
     private Long dispatchedQty;
     @JsonProperty
     private Long availableQty;
     @JsonProperty
     private BigDecimal unitPrice;
     @JsonProperty
     private BigDecimal totalPrice;
     @JsonProperty
     private BigDecimal marginPercentage;
     @JsonProperty
     private BigDecimal merginAmount;
     @JsonProperty
     private BigDecimal dealerPrice;
     @JsonProperty
     private String productCode;

    public Long getPurchasedQty() {
        return purchasedQty;
    }

    public void setPurchasedQty(Long purchasedQty) {
        this.purchasedQty = purchasedQty;
    }

    public Long getDispatchedQty() {
        return dispatchedQty;
    }

    public void setDispatchedQty(Long dispatchedQty) {
        this.dispatchedQty = dispatchedQty;
    }

    public Long getAvailableQty() {
        return availableQty;
    }

    public void setAvailableQty(Long availableQty) {
        this.availableQty = availableQty;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getMarginPercentage() {
        return marginPercentage;
    }

    public void setMarginPercentage(BigDecimal marginPercentage) {
        this.marginPercentage = marginPercentage;
    }

    public BigDecimal getMerginAmount() {
        return merginAmount;
    }

    public void setMerginAmount(BigDecimal merginAmount) {
        this.merginAmount = merginAmount;
    }

    public BigDecimal getDealerPrice() {
        return dealerPrice;
    }

    public void setDealerPrice(BigDecimal dealerPrice) {
        this.dealerPrice = dealerPrice;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
     
     

}
