/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ims.transactionEngine.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Date;

/**
 * 
 * @author Suresh Kumar V
 */
public class OrderManagementModel {
    @JsonProperty 
     private Date orderdate;
    @JsonProperty 
     private String OrderFor;
    @JsonProperty 
     private String dealerorsupplierno;
    @JsonProperty 
     private List<OrderDetailsModel> products;
    @JsonProperty 
     private String EnteredBy;
    @JsonProperty 
     private Date EnteredDate;

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public String getOrderFor() {
        return OrderFor;
    }

    public void setOrderFor(String OrderFor) {
        this.OrderFor = OrderFor;
    }

    public String getDealerorsupplierno() {
        return dealerorsupplierno;
    }

    public void setDealerorsupplierno(String dealerorsupplierno) {
        this.dealerorsupplierno = dealerorsupplierno;
    }

    public List<OrderDetailsModel> getproducts() {
        return products;
    }

    public void setproducts(List<OrderDetailsModel> products) {
        this.products = products;
    }

    public String getEnteredBy() {
        return EnteredBy;
    }

    public void setEnteredBy(String EnteredBy) {
        this.EnteredBy = EnteredBy;
    }

    public Date getEnteredDate() {
        return EnteredDate;
    }

    public void setEnteredDate(Date EnteredDate) {
        this.EnteredDate = EnteredDate;
    }
     
     
}
