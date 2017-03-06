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
public class TaxModel {

    @JsonProperty
    private Integer serialNumber;
    @JsonProperty
    private Double vat1;
    @JsonProperty
    private Double vat2;
    @JsonProperty
    private Double excessPercentage;
    @JsonProperty
    private Double educationCessPercentage;
    @JsonProperty
    private Double secondaryEducationCessPercentage;
    @JsonProperty
    private Double cstpercentage;
    @JsonProperty
    private Integer status;
    @JsonProperty
    private Date vaildTillDate;
    @JsonProperty
    private Long enteredBy;
    @JsonProperty
    private Date enteredDate;

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Double getVat1() {
        return vat1;
    }

    public void setVat1(Double vat1) {
        this.vat1 = vat1;
    }

    public Double getVat2() {
        return vat2;
    }

    public void setVat2(Double vat2) {
        this.vat2 = vat2;
    }

    public Double getExcessPercentage() {
        return excessPercentage;
    }

    public void setExcessPercentage(Double excessPercentage) {
        this.excessPercentage = excessPercentage;
    }

    public Double getEducationCessPercentage() {
        return educationCessPercentage;
    }

    public void setEducationCessPercentage(Double educationCessPercentage) {
        this.educationCessPercentage = educationCessPercentage;
    }

    public Double getSecondaryEducationCessPercentage() {
        return secondaryEducationCessPercentage;
    }

    public void setSecondaryEducationCessPercentage(Double secondaryEducationCessPercentage) {
        this.secondaryEducationCessPercentage = secondaryEducationCessPercentage;
    }

    public Double getCstpercentage() {
        return cstpercentage;
    }

    public void setCstpercentage(Double cstpercentage) {
        this.cstpercentage = cstpercentage;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getVaildTillDate() {
        return vaildTillDate;
    }

    public void setVaildTillDate(Date vaildTillDate) {
        this.vaildTillDate = vaildTillDate;
    }

    public Long getEnteredBy() {
        return enteredBy;
    }

    public void setEnteredBy(Long enteredBy) {
        this.enteredBy = enteredBy;
    }

    public Date getEnteredDate() {
        return enteredDate;
    }

    public void setEnteredDate(Date enteredDate) {
        this.enteredDate = enteredDate;
    }
    

}
