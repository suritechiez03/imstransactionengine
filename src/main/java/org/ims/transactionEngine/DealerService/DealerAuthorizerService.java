/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ims.transactionEngine.DealerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.ims.dao.entity.ImsDealersauthorizer;
import org.ims.dao.entity.ImsLogindetails;
import org.ims.dao.entitydao.ImsDealerDetailsDAO;
import org.ims.dao.entitydao.ImsDealersauthorizerDAO;
import org.ims.transactionEngine.model.AuthorizerModel;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Suresh Kumar V
 */
public class DealerAuthorizerService {
    @Autowired
    ImsDealersauthorizerDAO dealerauthorizer ;
    @Autowired
    ImsDealerDetailsDAO dealerdao ;

    public String imsGenerateDealerAuthorizerNumber() {
        String imsv_newdealerauthorizerno = "";
        int tmpdealerno;
        List<Map> data = dealerauthorizer.executeCustomSQL("SELECT COALESCE(Max(substr(AuthrizerID,5,9)),0)  as DAuthrizerID FROM IMS_DB.ims_dealersauthorizer");
        if (!data.isEmpty()) {
            Map imsdealerinfo = data.get(0);
            if (Integer.parseInt(imsdealerinfo.get("DAuthrizerID").toString()) == 0) {
                imsv_newdealerauthorizerno = paddzero("1");
            } else {
                tmpdealerno = Integer.parseInt(imsdealerinfo.get("DAuthrizerID").toString()) + 1;
                imsv_newdealerauthorizerno = paddzero(Integer.toString(tmpdealerno));
            }
        }

        return imsv_newdealerauthorizerno;
    }

    private String paddzero(String tmp) {

        int len = 0;
        String zero = "";
        len = tmp.length();

        for (int i = 1; i <= (8 - (len + 4)); i++) {
            zero = zero + "0";
        }
        return "AUTD" + zero + tmp;
    }

    public boolean saveDealerAuthorizerDetails(AuthorizerModel authorizerModel, ImsLogindetails logininfo) {
        ImsDealersauthorizer dealerauth = new ImsDealersauthorizer();
        dealerauth.setAuthrizerId(authorizerModel.getAuthorizerId());
        dealerauth.setAuthrizerName(authorizerModel.getAuthorizername());
        dealerauth.setEmailId(authorizerModel.getEmailid());
        dealerauth.setPhoneNo(authorizerModel.getPhoneno());
        dealerauth.setPannumber(authorizerModel.getPannumber());
        dealerauth.setOtherDetails(authorizerModel.getOtherDetails());
        dealerauth.setStatus(Boolean.TRUE);
        dealerauth.setEnteredDate(authorizerModel.getEnteredDate());
        dealerauth.setImsLogindetails(logininfo);
        dealerauth.setImsDealermaster(dealerdao.findOne(" DealerNumber='" + authorizerModel.getDealerorsupplierno() + "'"));
        dealerauthorizer.create(dealerauth);
        return true;
    }

    public boolean updateDealerAuthorizerDetails(AuthorizerModel authorizerModel, ImsLogindetails logininfo) {
        ImsDealersauthorizer dealerauth = new ImsDealersauthorizer();
        dealerauth.setAuthrizerId(authorizerModel.getAuthorizerId());
        dealerauth.setAuthrizerName(authorizerModel.getAuthorizername());
        dealerauth.setEmailId(authorizerModel.getEmailid());
        dealerauth.setPhoneNo(authorizerModel.getPhoneno());
        dealerauth.setPannumber(authorizerModel.getPannumber());
        dealerauth.setOtherDetails(authorizerModel.getOtherDetails());
        dealerauth.setStatus(authorizerModel.getStatus());
        dealerauth.setEnteredDate(authorizerModel.getEnteredDate());
        dealerauth.setImsLogindetails(logininfo);
        dealerauth.setImsDealermaster(dealerdao.findOne(" DealerNumber='" + authorizerModel.getDealerorsupplierno() + "'"));
        dealerauthorizer.update(dealerauth);
        return true;
    }
    
    public List<AuthorizerModel> Ims_getDealerAuhtorizerList(ImsLogindetails key) {
        List<AuthorizerModel> authorizermodel = new ArrayList<>();
        List<ImsDealersauthorizer> dealerauthorizerlist = dealerauthorizer.findAll();
        for (ImsDealersauthorizer authorizer : dealerauthorizerlist) {
            AuthorizerModel dealerauthobj = new AuthorizerModel();
            dealerauthobj.setAuthroizerId(authorizer.getAuthrizerId());
            dealerauthobj.setAuthorizername(authorizer.getAuthrizerName());
            dealerauthobj.setAuthorizerphoto(authorizer.getAuthorizerPhoto());
            dealerauthobj.setEmailid(authorizer.getEmailId());
            dealerauthobj.setPannumber(authorizer.getPannumber());
            dealerauthobj.setPhoneno(authorizer.getPhoneNo());
            dealerauthobj.setStatus(authorizer.getStatus());
            dealerauthobj.setEnteredDate(authorizer.getEnteredDate());
            dealerauthobj.setEnteredBy(authorizer.getImsLogindetails().getUserName());
            dealerauthobj.setDealerorsupplierno(authorizer.getImsDealermaster().getDealerNumber());   
            dealerauthobj.setOtherDetails(authorizer.getOtherDetails());
            dealerauthobj.setAuthorizerFor("Dealer");
            authorizermodel.add(dealerauthobj);
            }
        return authorizermodel;
    }
}
