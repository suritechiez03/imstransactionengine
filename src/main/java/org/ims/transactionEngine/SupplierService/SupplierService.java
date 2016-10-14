/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ims.transactionEngine.SupplierService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.ims.dao.entity.ImsLogindetails;
import org.ims.dao.entity.ImsSuppliermaster;
import org.ims.dao.entitydao.ImsSupplierDetailsDAO;
import org.ims.transactionEngine.model.SupplierModel;

/**
 *
 * @author Suresh Kumar V
 */
public class SupplierService {

    ImsSupplierDetailsDAO imssupplierdao = new ImsSupplierDetailsDAO();

    public String imsGenerateSupplierNumber() {
        String imsv_newsupplierno = "";
        int tmpsupplierno;
        List<Map> data = imssupplierdao.imsGetMaxSupplierNumber();
        if (!data.isEmpty()) {
            Map imssupplierinfo = data.get(0);
            if (Integer.parseInt(imssupplierinfo.get("SupplierNo").toString()) == 0) {
                imsv_newsupplierno = paddzero("1");
            } else {
                tmpsupplierno = Integer.parseInt(imssupplierinfo.get("SupplierNo").toString()) + 1;
                imsv_newsupplierno = paddzero(Integer.toString(tmpsupplierno));
            }
        }

        return imsv_newsupplierno;
    }

    private String paddzero(String tmp) {

        int len = 0;
        String zero = "";
        len = tmp.length();

        for (int i = 1; i <= (5 - (len + 2)); i++) {
            zero = zero + "0";
        }
        return "SE" + zero + tmp;
    }

    public boolean saveSupplierDetails(SupplierModel supplier, ImsLogindetails Logininfo) {

        ImsSuppliermaster supplierobj = new ImsSuppliermaster();
        supplierobj.setSupplierNumber(supplier.getSupplierNumber());
        supplierobj.setCompanyName(supplier.getCompanyName());
        supplierobj.setCompanyEmail(supplier.getCompanyEmail());
        supplierobj.setCompanywebsite(supplier.getCompanyWebsite());
        supplierobj.setCstnumber(supplier.getCstNumber());
        supplierobj.setComapanyAddress(supplier.getComapanyAddress());
        supplierobj.setPannumber(supplier.getPanNumber());
        supplierobj.setTinNumber(supplier.getTinNumber());
        supplierobj.setVccertificate(supplier.getVccertificate());
        supplierobj.setEnteredDate(supplier.getEnteredDate());
        supplierobj.setImsLogindetails(Logininfo);
        supplierobj.setStatus(supplier.getStatus());
        supplierobj.setOfflicePhNumber(supplier.getOfflicePhNumber());
        imssupplierdao.create(supplierobj);

        return true;
    }

    public boolean updateSupplierDetails(SupplierModel supplier, ImsLogindetails Logininfo) {

        ImsSuppliermaster supplierobj = new ImsSuppliermaster();
        supplierobj.setSupplierNumber(supplier.getSupplierNumber());
        supplierobj.setCompanyName(supplier.getCompanyName());
        supplierobj.setCompanyEmail(supplier.getCompanyEmail());
        supplierobj.setCompanywebsite(supplier.getCompanyWebsite());
        supplierobj.setCstnumber(supplier.getCstNumber());
        supplierobj.setComapanyAddress(supplier.getComapanyAddress());
        supplierobj.setPannumber(supplier.getPanNumber());
        supplierobj.setTinNumber(supplier.getTinNumber());
        supplierobj.setVccertificate(supplier.getVccertificate());
        supplierobj.setEnteredDate(supplier.getEnteredDate());
        supplierobj.setImsLogindetails(Logininfo);
        supplierobj.setStatus(supplier.getStatus());
        supplierobj.setOfflicePhNumber(supplier.getOfflicePhNumber());
        imssupplierdao.update(supplierobj);

        return true;
    }

    public List<SupplierModel> Ims_getSupplierList(ImsLogindetails key) {
        List<SupplierModel> suppliermodel = new ArrayList<>();
        List<ImsSuppliermaster> supplierlist = imssupplierdao.findAll();
        for (ImsSuppliermaster supplier : supplierlist) {
            SupplierModel supplierobj = new SupplierModel();
            supplierobj.setSupplierNumber(supplier.getSupplierNumber());
            supplierobj.setCompanyName(supplier.getCompanyName() != null ? supplier.getCompanyName() : "");
            supplierobj.setCompanyEmail(supplier.getCompanyEmail() != null ? supplier.getCompanyEmail() : "");
            supplierobj.setCompanyWebsite(supplier.getCompanywebsite() != null ? supplier.getCompanywebsite() : "");
            supplierobj.setCstNumber(supplier.getCstnumber() != null ? supplier.getCstnumber() : "");
            supplierobj.setComapanyAddress(supplier.getComapanyAddress() != null ? supplier.getComapanyAddress() : "");
            supplierobj.setPanNumber(supplier.getPannumber() != null ? supplier.getPannumber() : "");
            supplierobj.setTinNumber(supplier.getTinNumber() != null ? supplier.getTinNumber() : "");
            supplierobj.setVccertificate(supplier.getVccertificate());
            supplierobj.setEnteredDate(supplier.getEnteredDate());
            supplierobj.setEnteredBy(supplier.getImsLogindetails().getUserName());
            supplierobj.setStatus(supplier.getStatus());
            supplierobj.setOfflicePhNumber(supplier.getOfflicePhNumber() != null ? supplier.getOfflicePhNumber() : "");
            suppliermodel.add(supplierobj);
        }
        return suppliermodel;
    }

    public SupplierModel Ims_getSupplierByID(String key) {

        ImsSuppliermaster supplier = imssupplierdao.findOne(" SupplierNumber ='" + key + "'");

        SupplierModel supplierobj = new SupplierModel();
        supplierobj.setSupplierNumber(supplier.getSupplierNumber());
        supplierobj.setCompanyName(supplier.getCompanyName() != null ? supplier.getCompanyName() : "");
        supplierobj.setCompanyEmail(supplier.getCompanyEmail() != null ? supplier.getCompanyEmail() : "");
        supplierobj.setCompanyWebsite(supplier.getCompanywebsite() != null ? supplier.getCompanywebsite() : "");
        supplierobj.setCstNumber(supplier.getCstnumber() != null ? supplier.getCstnumber() : "");
        supplierobj.setComapanyAddress(supplier.getComapanyAddress() != null ? supplier.getComapanyAddress() : "");
        supplierobj.setPanNumber(supplier.getPannumber() != null ? supplier.getPannumber() : "");
        supplierobj.setTinNumber(supplier.getTinNumber() != null ? supplier.getTinNumber() : "");
        supplierobj.setVccertificate(supplier.getVccertificate());
        supplierobj.setEnteredDate(supplier.getEnteredDate());
        supplierobj.setEnteredBy(supplier.getImsLogindetails().getUserName());
        supplierobj.setStatus(supplier.getStatus());
        supplierobj.setOfflicePhNumber(supplier.getOfflicePhNumber() != null ? supplier.getOfflicePhNumber() : "");

        return supplierobj;
    }
}
