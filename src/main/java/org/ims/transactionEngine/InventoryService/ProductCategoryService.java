/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ims.transactionEngine.InventoryService;

import java.util.ArrayList;
import java.util.List;
import org.ims.dao.entity.ImsLogindetails;
import org.ims.dao.entity.ImsProductcategory;
import org.ims.dao.entitydao.ImsProductcategoryDAO;
import org.ims.transactionEngine.model.ProductCategoryModel;

/**
 *
 * @author Suresh Kumar V
 */
public class ProductCategoryService {

    ImsProductcategoryDAO imsproductcategorydao = new ImsProductcategoryDAO();

    public boolean addProductCategory(ProductCategoryModel productcategory, ImsLogindetails logininfo) throws Exception {
        ImsProductcategory prdcategoryobj = new ImsProductcategory();
        prdcategoryobj.setCategoryCode(productcategory.getProductcategorycode());
        prdcategoryobj.setCategoryName(productcategory.getProductcategoryname());
        prdcategoryobj.setAdditionalInfo(productcategory.getProductcategoryaddinfo());
        prdcategoryobj.setEnteredDate(productcategory.getEnteredDate());
        prdcategoryobj.setImsLogindetails(logininfo);
        imsproductcategorydao.create(prdcategoryobj);
        return true;
    }

    public boolean updateProductCategory(ProductCategoryModel productcategory, ImsLogindetails logininfo) throws Exception {
        ImsProductcategory prdcategoryobj = new ImsProductcategory();
        prdcategoryobj.setCategoryCode(productcategory.getProductcategorycode());
        prdcategoryobj.setCategoryName(productcategory.getProductcategoryname());
        prdcategoryobj.setAdditionalInfo(productcategory.getProductcategoryaddinfo());
        prdcategoryobj.setEnteredDate(productcategory.getEnteredDate());
        prdcategoryobj.setImsLogindetails(logininfo);
        imsproductcategorydao.update(prdcategoryobj);
        return true;
    }

    public List<ProductCategoryModel> Ims_getProductCategoryList() throws Exception {
        List<ProductCategoryModel> productCategoryModellist = new ArrayList<>();
        List<ImsProductcategory> productcategorylist = imsproductcategorydao.findAll();
        for (ImsProductcategory productcategorylist1 : productcategorylist) {
            ProductCategoryModel productCategoryModel = new ProductCategoryModel();
            productCategoryModel.setProductcategorycode(productcategorylist1.getCategoryCode());
            productCategoryModel.setProductcategoryname(productcategorylist1.getCategoryName());
            productCategoryModel.setProductcategoryaddinfo(productcategorylist1.getAdditionalInfo());
            productCategoryModel.setEnteredBy(productcategorylist1.getImsLogindetails().getUserName());
            productCategoryModel.setEnteredDate(productcategorylist1.getEnteredDate());
            productCategoryModellist.add(productCategoryModel);

        }
        return productCategoryModellist;
    }

    public ProductCategoryModel Ims_getProductCategoryByID(String Key) {

        ImsProductcategory productCategory = imsproductcategorydao.findOne(" CategoryCode ='" + Key + "'");
        ProductCategoryModel productCategoryModel = new ProductCategoryModel();
        productCategoryModel.setProductcategorycode(productCategory.getCategoryCode() != null ? productCategory.getCategoryCode() : "");
        productCategoryModel.setProductcategoryname(productCategory.getCategoryName() != null ? productCategory.getCategoryName() : "");
        productCategoryModel.setProductcategoryaddinfo(productCategory.getAdditionalInfo() != null ? productCategory.getAdditionalInfo() : "");
        productCategoryModel.setEnteredBy(productCategory.getImsLogindetails().getUserName());
        productCategoryModel.setEnteredDate(productCategory.getEnteredDate());
        return productCategoryModel;
    }
}
