/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ims.transactionEngine.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Suri
 */
public class LoginModel implements java.io.Serializable {

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    public String getLoginparam() {
        return loginparam;
    }
    public void setLoginparam(String loginparam) {
        this.loginparam = loginparam;
    }
    public String getUserRole() {
        return UserRole;
    }

    public void setUserRole(String UserRole) {
        this.UserRole = UserRole;
    }
@JsonProperty    
private String UserName;
@JsonProperty    
private String Password;
@JsonProperty
@JsonIgnore
private String token;
@JsonProperty
@JsonIgnore
private String loginparam;
@JsonIgnore
private String UserRole;
}
