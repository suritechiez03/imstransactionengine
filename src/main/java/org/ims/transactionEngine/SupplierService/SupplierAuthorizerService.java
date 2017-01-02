/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ims.transactionEngine.SupplierService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.ims.dao.entity.ImsSuppliersauthorizer;
import org.ims.dao.entity.ImsLogindetails;
import org.ims.dao.entitydao.ImsSupplierDetailsDAO;
import org.ims.dao.entitydao.ImsSuppliersauthorizerDAO;
import org.ims.transactionEngine.model.AuthorizerModel;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Suresh Kumar V
 */
public class SupplierAuthorizerService {

    @Autowired
    ImsSupplierDetailsDAO supplierauthorizer;
    @Autowired
    ImsSuppliersauthorizerDAO supplierauthorizerdao;

    public String imsGenerateSupplierAuthorizerNumber() {
        String imsv_newsupplierauthorizerno = "";
        int tmpsupplierno;
        List<Map> data = supplierauthorizer.executeCustomSQL("SELECT COALESCE(Max(substr(AuthrizerID,5,9)),0)  as SAuthrizerID FROM IMS_DB.ims_suppliersauthorizer");
        if (!data.isEmpty()) {
            Map imssupplierinfo = data.get(0);
            if (Integer.parseInt(imssupplierinfo.get("SAuthrizerID").toString()) == 0) {
                imsv_newsupplierauthorizerno = paddzero("1");
            } else {
                tmpsupplierno = Integer.parseInt(imssupplierinfo.get("SAuthrizerID").toString()) + 1;
                imsv_newsupplierauthorizerno = paddzero(Integer.toString(tmpsupplierno));
            }
        }

        return imsv_newsupplierauthorizerno;
    }

    private String paddzero(String tmp) {

        int len = 0;
        String zero = "";
        len = tmp.length();

        for (int i = 1; i <= (8 - (len + 4)); i++) {
            zero = zero + "0";
        }
        return "AUTS" + zero + tmp;
    }

    public boolean saveSupplierAuthorizerDetails(AuthorizerModel authorizerModel, ImsLogindetails logininfo) {
        ImsSuppliersauthorizer supplierauth = new ImsSuppliersauthorizer();
        supplierauth.setAuthrizerId(authorizerModel.getAuthorizerId());
        supplierauth.setAuthrizerName(authorizerModel.getAuthorizername());
        supplierauth.setEmailId(authorizerModel.getEmailid());
        supplierauth.setPhoneNo(authorizerModel.getPhoneno());
        supplierauth.setPannumber(authorizerModel.getPannumber());
        supplierauth.setOtherDetails(authorizerModel.getOtherDetails());
        supplierauth.setStatus(Boolean.TRUE);
        supplierauth.setEnteredDate(authorizerModel.getEnteredDate());
        supplierauth.setImsLogindetails(logininfo);
        supplierauth.setImsSuppliermaster(supplierauthorizer.findOne(" SupplierNumber='" + authorizerModel.getDealerorsupplierno() + "'"));
        supplierauthorizerdao.create(supplierauth);
        return true;
    }

    public boolean updateSupplierAuthorizerDetails(AuthorizerModel authorizerModel, ImsLogindetails logininfo) {
        ImsSuppliersauthorizer supplierauth = new ImsSuppliersauthorizer();
        supplierauth.setAuthrizerId(authorizerModel.getAuthorizerId());
        supplierauth.setAuthrizerName(authorizerModel.getAuthorizername());
        supplierauth.setEmailId(authorizerModel.getEmailid());
        supplierauth.setPhoneNo(authorizerModel.getPhoneno());
        supplierauth.setPannumber(authorizerModel.getPannumber());
        supplierauth.setOtherDetails(authorizerModel.getOtherDetails());
        supplierauth.setStatus(authorizerModel.getStatus());
        supplierauth.setEnteredDate(authorizerModel.getEnteredDate());
        supplierauth.setImsLogindetails(logininfo);
        supplierauth.setImsSuppliermaster(supplierauthorizer.findOne(" SupplierNumber='" + authorizerModel.getDealerorsupplierno() + "'"));
        supplierauthorizerdao.update(supplierauth);
        return true;
    }

    public List<AuthorizerModel> Ims_getSupplierAuhtorizerList(ImsLogindetails key) {
        List<AuthorizerModel> authorizermodel = new ArrayList<>();
        List<ImsSuppliersauthorizer> supplierauthorizerlist = supplierauthorizerdao.findAll();
        for (ImsSuppliersauthorizer authorizer : supplierauthorizerlist) {
            AuthorizerModel supplierauthobj = new AuthorizerModel();
            supplierauthobj.setAuthroizerId(authorizer.getAuthrizerId());
            supplierauthobj.setAuthorizername(authorizer.getAuthrizerName());
            supplierauthobj.setAuthorizerphoto(authorizer.getAuthorizerPhoto());
            supplierauthobj.setEmailid(authorizer.getEmailId());
            supplierauthobj.setPannumber(authorizer.getPannumber());
            supplierauthobj.setPhoneno(authorizer.getPhoneNo());
            supplierauthobj.setStatus(authorizer.getStatus());
            supplierauthobj.setEnteredDate(authorizer.getEnteredDate());
            supplierauthobj.setEnteredBy(authorizer.getImsLogindetails().getUserName());
            supplierauthobj.setDealerorsupplierno(authorizer.getImsSuppliermaster().getSupplierNumber());
            supplierauthobj.setOtherDetails(authorizer.getOtherDetails());
            supplierauthobj.setAuthorizerFor("Supplier");
            authorizermodel.add(supplierauthobj);
        }
        return authorizermodel;
    }
}
