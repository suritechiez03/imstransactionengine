/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ims.transactionEngine.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import org.ims.dao.entity.ImsStockdetails;

/**
 * 
 * @author Suresh Kumar V
 */
public class ProductModel {
    @JsonProperty
     private String productcode;
    @JsonProperty
     private String productcategorycode;
    @JsonProperty
     private String enteredby;
    @JsonProperty
     private String productname;
    @JsonProperty
     private String specificationandthickness;
    @JsonProperty
     private String size;
    @JsonProperty
     private String units;
    @JsonProperty
     private Long moq;
    @JsonProperty
     private String color;
    @JsonProperty
     private Date enteredDate;
    @JsonProperty
     private StockModel stockdetails;

    public String getProductcode() {
        return productcode;
    }

    public void setProductcode(String productcode) {
        this.productcode = productcode;
    }

    public String getProductcategorycode() {
        return productcategorycode;
    }

    public void setProductcategorycode(String productcategorycode) {
        this.productcategorycode = productcategorycode;
    }

    public String getEnteredby() {
        return enteredby;
    }

    public void setEnteredby(String enteredby) {
        this.enteredby = enteredby;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getSpecificationandthickness() {
        return specificationandthickness;
    }

    public void setSpecificationandthickness(String specificationandthickness) {
        this.specificationandthickness = specificationandthickness;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public Long getMoq() {
        return moq;
    }

    public void setMoq(Long moq) {
        this.moq = moq;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getEnteredDate() {
        return enteredDate;
    }

    public void setEnteredDate(Date enteredDate) {
        this.enteredDate = enteredDate;
    }

    public StockModel getStockdetails() {
        return stockdetails;
    }

    public void setStockdetails(StockModel stockdetails) {
        this.stockdetails = stockdetails;
    }
    
     
}
