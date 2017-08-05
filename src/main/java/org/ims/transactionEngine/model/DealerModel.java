/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ims.transactionEngine.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import org.ims.dao.entity.ImsLogindetails;

/**
 *
 * @author Suresh Kumar V
 */
public class DealerModel {

    public String getDealerNumber() {
        return dealerNumber;
    }

    public void setDealerNumber(String dealerNumber) {
        this.dealerNumber = dealerNumber;
    }

    public String getEnteredBy() {
        return enteredBy;
    }

    public void setEnteredBy(String enteredBy) {
        this.enteredBy = enteredBy;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyWebsite() {
        return companyWebsite;
    }

    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getComapanyAddress() {
        return comapanyAddress;
    }

    public void setComapanyAddress(String comapanyAddress) {
        this.comapanyAddress = comapanyAddress;
    }

    public String getTinNumber() {
        return tinNumber;
    }

    public void setTinNumber(String tinNumber) {
        this.tinNumber = tinNumber;
    }

    public String getCstNumber() {
        return cstNumber;
    }

    public void setCstNumber(String cstNumber) {
        this.cstNumber = cstNumber;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public byte[] getVccertificate() {
        return vccertificate;
    }

    public void setVccertificate(byte[] vccertificate) {
        this.vccertificate = vccertificate;
    }

    public String getOfflicePhNumber() {
        return offlicePhNumber;
    }

    public void setOfflicePhNumber(String offlicePhNumber) {
        this.offlicePhNumber = offlicePhNumber;
    }

    public Date getEnteredDate() {
        return enteredDate;
    }

    public void setEnteredDate(Date enteredDate) {
        this.enteredDate = enteredDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getGstNumber() {
        return gstNumber;
    }

    public void setGstNumber(String gstNumber) {
        this.gstNumber = gstNumber;
    }
    @JsonProperty
    private String dealerNumber;
    @JsonProperty
    private String enteredBy;
    @JsonProperty
    private String companyName;
    @JsonProperty
    private String companyWebsite;
    @JsonProperty
    private String companyEmail;
    @JsonProperty
    private String comapanyAddress;
    @JsonProperty
    private String tinNumber;
    @JsonProperty
    private String cstNumber;
    @JsonProperty
    private String panNumber;
    @JsonProperty
    private byte[] vccertificate;
    @JsonProperty
    private String offlicePhNumber;
    @JsonProperty
    private Date enteredDate;

    @JsonProperty
    private Boolean status;
     @JsonProperty
    private String gstNumber;

}
