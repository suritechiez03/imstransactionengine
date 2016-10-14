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
public class AuthorizerModel {

    public String getAuthorizerId() {
        return authorizerId;
    }

    public void setAuthroizerId(String authrizerId) {
        this.authorizerId = authrizerId;
    }

    public String getDealerorsupplierno() {
        return dealerorsupplierno;
    }

    public void setDealerorsupplierno(String dealerorsupplierno) {
        this.dealerorsupplierno = dealerorsupplierno;
    }

    public String getAuthorizername() {
        return authorizername;
    }

    public void setAuthorizername(String authrizername) {
        this.authorizername = authrizername;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public byte[] getAuthorizerphoto() {
        return authorizerphoto;
    }

    public void setAuthorizerphoto(byte[] authorizerphoto) {
        this.authorizerphoto = authorizerphoto;
    }

    public String getPannumber() {
        return pannumber;
    }

    public void setPannumber(String pannumber) {
        this.pannumber = pannumber;
    }

    public Date getEnteredDate() {
        return enteredDate;
    }

    public void setEnteredDate(Date enteredDate) {
        this.enteredDate = enteredDate;
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    
    public String getAuthorizerFor() {
        return authorizerFor;
    }

    public void setAuthorizerFor(String authorizerFor) {
        this.authorizerFor = authorizerFor;
    }    
    public String getEnteredBy() {
        return enteredBy;
    }

    public void setEnteredBy(String enteredBy) {
        this.enteredBy = enteredBy;
    }
    @JsonProperty
    private String authorizerId;
    @JsonProperty
    private String dealerorsupplierno;
    @JsonProperty
    private String authorizername;
    @JsonProperty
    private String phoneno;
    @JsonProperty
    private String emailid;
    @JsonProperty
    private byte[] authorizerphoto;

    @JsonProperty
    private String pannumber;
    @JsonProperty
    private Date enteredDate;
    @JsonProperty
    private String otherDetails;
    @JsonProperty
    private Boolean status;
    @JsonProperty
    private String authorizerFor;
    @JsonProperty
    private String enteredBy;
    

}
