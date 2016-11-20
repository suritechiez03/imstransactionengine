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
public class ProductCategoryModel {

    public String getProductcategorycode() {
        return productcategorycode;
    }

    public void setProductcategorycode(String productcategorycode) {
        this.productcategorycode = productcategorycode;
    }

    public String getEnteredBy() {
        return enteredBy;
    }

    public void setEnteredBy(String enteredBy) {
        this.enteredBy = enteredBy;
    }

    public String getProductcategoryname() {
        return productcategoryname;
    }

    public void setProductcategoryname(String productcategoryname) {
        this.productcategoryname = productcategoryname;
    }

    public String getProductcategoryaddinfo() {
        return productcategoryaddinfo;
    }

    public void setProductcategoryaddinfo(String productcategoryaddinfo) {
        this.productcategoryaddinfo = productcategoryaddinfo;
    }

    public Date getEnteredDate() {
        return enteredDate;
    }

    public void setEnteredDate(Date enteredDate) {
        this.enteredDate = enteredDate;
    }

    private String productcategorycode;
    private String enteredBy;
    private String productcategoryname;
    private String productcategoryaddinfo;
    private Date enteredDate;
}
