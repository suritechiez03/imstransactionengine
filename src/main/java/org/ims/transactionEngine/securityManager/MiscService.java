/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ims.transactionEngine.securityManager;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.ims.dao.entity.ImsGenraldefinition;
import org.ims.dao.entity.ImsTaxslab;
import org.ims.dao.entitydao.ImsGenraldefinitionDAO;
import org.ims.dao.entitydao.ImsTaxslabDAO;
import org.ims.transactionEngine.model.GeneralDefinitionModel;
import org.ims.transactionEngine.model.TaxModel;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Suresh Kumar V
 */
public class MiscService {

    @Autowired
    ImsGenraldefinitionDAO imsGenraldefinitionDAO;
    @Autowired
    ImsTaxslabDAO imsTaxslabDAO;
    @Autowired
    DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<GeneralDefinitionModel> getGeneralDefByValue(String Value) {
        List<GeneralDefinitionModel> listGD = new ArrayList<>();
        List<ImsGenraldefinition> listimsGD = imsGenraldefinitionDAO.findAllByValue(" GdAbb='" + Value + "' and GdCode Not Like '_____0'");
        for (ImsGenraldefinition listimsGD1 : listimsGD) {
            GeneralDefinitionModel objGD = new GeneralDefinitionModel();
            objGD.setGdCode(listimsGD1.getGdCode());
            objGD.setGdAbb(listimsGD1.getGdAbb());
            objGD.setGdName(listimsGD1.getGdName());
            listGD.add(objGD);
        }
        return listGD;

    }

    public List<TaxModel> getActiveTaxSlab() {
        List<TaxModel> taxList = new ArrayList<>();
        List<ImsTaxslab> objTaxslab = imsTaxslabDAO.findAllByValue(" status='" + 1 + "'");
        for (ImsTaxslab objTaxslab1 : objTaxslab) {
            TaxModel objmodel = new TaxModel();
            objmodel.setVat1(objTaxslab1.getVat1());
            objmodel.setVat2(objTaxslab1.getVat2());
            objmodel.setCstpercentage(objTaxslab1.getCstpercentage());
            objmodel.setEducationCessPercentage(objTaxslab1.getEducationCessPercentage());
            objmodel.setExcessPercentage(objTaxslab1.getExcessPercentage());
            objmodel.setSecondaryEducationCessPercentage(objTaxslab1.getSecondaryEducationCessPercentage());
            objmodel.setStatus(objTaxslab1.getStatus());
            taxList.add(objmodel);

        }
        return taxList;

    }
}
