/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ims.transactionEngine.model;

import java.util.Date;

/**
 * 
 * @author Suresh Kumar V
 */
public class ProductModel {
     private String productcode;
     private String productcategorycode;
     private String enteredby;
     private String productname;
     private String specificationandthickness;
     private String size;
     private String units;
     private Long moq;
     private String color;
     private Date enteredDate;

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
     
}
