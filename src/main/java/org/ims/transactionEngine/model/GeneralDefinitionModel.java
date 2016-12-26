/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ims.transactionEngine.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Suresh Kumar V
 */
public class GeneralDefinitionModel {

    @JsonProperty
    private String gdCode;
    @JsonProperty
    private String gdAbb;
    @JsonProperty
    private String gdName;

    public String getGdCode() {
        return gdCode;
    }

    public void setGdCode(String gdCode) {
        this.gdCode = gdCode;
    }

    public String getGdAbb() {
        return gdAbb;
    }

    public void setGdAbb(String gdAbb) {
        this.gdAbb = gdAbb;
    }

    public String getGdName() {
        return gdName;
    }

    public void setGdName(String gdName) {
        this.gdName = gdName;
    }

}
