/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ims.transactionEngine.DealerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.ims.dao.entity.ImsDealermaster;
import org.ims.dao.entity.ImsLogindetails;
import org.ims.dao.entitydao.ImsDealerDetailsDAO;
import org.ims.transactionEngine.model.DealerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author suri
 */
public class DealerService {

//    ApplicationContext context = new ClassPathXmlApplicationContext("transactionbeans.xml");
//    ImsDealerDetailsDAO imsdealerdao = (ImsDealerDetailsDAO) context.getBean("ImsDealerMasterDAO");
    @Autowired
    ImsDealerDetailsDAO imsdealerdao ;

    public String imsGenerateDealerNumber() {
        String imsv_newdealerno = "";
        int tmpdealerno;
        List<Map> data = imsdealerdao.imsGetMaxDealerNumber();
        if (!data.isEmpty()) {
            Map imsdealerinfo = data.get(0);
            if (Integer.parseInt(imsdealerinfo.get("DealerNo").toString()) == 0) {
                imsv_newdealerno = paddzero("1");
            } else {
                tmpdealerno = Integer.parseInt(imsdealerinfo.get("DealerNo").toString()) + 1;
                imsv_newdealerno = paddzero(Integer.toString(tmpdealerno));
            }
        }

        return imsv_newdealerno;
    }

    private String paddzero(String tmp) {

        int len = 0;
        String zero = "";
        len = tmp.length();

        for (int i = 1; i <= (5 - (len + 2)); i++) {
            zero = zero + "0";
        }
        return "DE" + zero + tmp;
    }
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public boolean saveDealerDetails(DealerModel dealer, ImsLogindetails Logininfo) {

        ImsDealermaster dealerobj = new ImsDealermaster();
        dealerobj.setDealerNumber(dealer.getDealerNumber());
        dealerobj.setCompanyName(dealer.getCompanyName());
        dealerobj.setCompanyEmail(dealer.getCompanyEmail());
        dealerobj.setCompanywebsite(dealer.getCompanyWebsite());
        dealerobj.setCstnumber(dealer.getCstNumber());
        dealerobj.setComapanyAddress(dealer.getComapanyAddress());
        dealerobj.setPannumber(dealer.getPanNumber());
        dealerobj.setTinNumber(dealer.getTinNumber());
        dealerobj.setVccertificate(dealer.getVccertificate());
        dealerobj.setEnteredDate(dealer.getEnteredDate());
        dealerobj.setImsLogindetails(Logininfo);
        dealerobj.setStatus(dealer.getStatus());
        dealerobj.setGstnumber(dealer.getGstNumber());
        dealerobj.setOfflicePhNumber(dealer.getOfflicePhNumber());
        imsdealerdao.create(dealerobj);

        return true;
    }
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public boolean updateDealerDetails(DealerModel dealer, ImsLogindetails Logininfo) {

        ImsDealermaster dealerobj = new ImsDealermaster();
        dealerobj.setDealerNumber(dealer.getDealerNumber());
        dealerobj.setCompanyName(dealer.getCompanyName());
        dealerobj.setCompanyEmail(dealer.getCompanyEmail());
        dealerobj.setCompanywebsite(dealer.getCompanyWebsite());
        dealerobj.setCstnumber(dealer.getCstNumber());
        dealerobj.setComapanyAddress(dealer.getComapanyAddress());
        dealerobj.setPannumber(dealer.getPanNumber());
        dealerobj.setTinNumber(dealer.getTinNumber());
        dealerobj.setVccertificate(dealer.getVccertificate());
        dealerobj.setEnteredDate(dealer.getEnteredDate());
        dealerobj.setImsLogindetails(Logininfo);
        dealerobj.setStatus(dealer.getStatus());
        dealerobj.setGstnumber(dealer.getGstNumber());
        dealerobj.setOfflicePhNumber(dealer.getOfflicePhNumber());
        imsdealerdao.update(dealerobj);

        return true;
    }

    public List<DealerModel> Ims_getDealerList(ImsLogindetails key) {
        List<DealerModel> dealermodel = new ArrayList<>();
        List<ImsDealermaster> dealerlist = imsdealerdao.findAll();
        for (ImsDealermaster dealer : dealerlist) {
            DealerModel dealerobj = new DealerModel();
            dealerobj.setDealerNumber(dealer.getDealerNumber());
            dealerobj.setCompanyName(dealer.getCompanyName() != null ? dealer.getCompanyName() : "");
            dealerobj.setCompanyEmail(dealer.getCompanyEmail() != null ? dealer.getCompanyEmail() : "");
            dealerobj.setCompanyWebsite(dealer.getCompanywebsite() != null ? dealer.getCompanywebsite() : "");
            dealerobj.setCstNumber(dealer.getCstnumber() != null ? dealer.getCstnumber() : "");
            dealerobj.setComapanyAddress(dealer.getComapanyAddress() != null ? dealer.getComapanyAddress() : "");
            dealerobj.setPanNumber(dealer.getPannumber() != null ? dealer.getPannumber() : "");
            dealerobj.setTinNumber(dealer.getTinNumber() != null ? dealer.getTinNumber() : "");
            dealerobj.setVccertificate(dealer.getVccertificate());
            dealerobj.setEnteredDate(dealer.getEnteredDate());
            dealerobj.setEnteredBy(dealer.getImsLogindetails().getUserName());
            dealerobj.setStatus(dealer.getStatus());
            dealerobj.setGstNumber(dealer.getGstnumber());
            dealerobj.setOfflicePhNumber(dealer.getOfflicePhNumber() != null ? dealer.getOfflicePhNumber() : "");
            dealermodel.add(dealerobj);
        }
        return dealermodel;
    }

    public DealerModel Ims_getDealerByID(String key) {

        ImsDealermaster dealer = imsdealerdao.findOne(" DealerNumber ='" + key + "'");

        DealerModel dealerobj = new DealerModel();
        dealerobj.setDealerNumber(dealer.getDealerNumber());
        dealerobj.setCompanyName(dealer.getCompanyName() != null ? dealer.getCompanyName() : "");
        dealerobj.setCompanyEmail(dealer.getCompanyEmail() != null ? dealer.getCompanyEmail() : "");
        dealerobj.setCompanyWebsite(dealer.getCompanywebsite() != null ? dealer.getCompanywebsite() : "");
        dealerobj.setCstNumber(dealer.getCstnumber() != null ? dealer.getCstnumber() : "");
        dealerobj.setComapanyAddress(dealer.getComapanyAddress() != null ? dealer.getComapanyAddress() : "");
        dealerobj.setPanNumber(dealer.getPannumber() != null ? dealer.getPannumber() : "");
        dealerobj.setTinNumber(dealer.getTinNumber() != null ? dealer.getTinNumber() : "");
        dealerobj.setVccertificate(dealer.getVccertificate());
        dealerobj.setEnteredDate(dealer.getEnteredDate());
        dealerobj.setEnteredBy(dealer.getImsLogindetails().getUserName());
        dealerobj.setStatus(dealer.getStatus());
        dealerobj.setGstNumber(dealer.getGstnumber());
        dealerobj.setOfflicePhNumber(dealer.getOfflicePhNumber() != null ? dealer.getOfflicePhNumber() : "");

        return dealerobj;
    }
}
