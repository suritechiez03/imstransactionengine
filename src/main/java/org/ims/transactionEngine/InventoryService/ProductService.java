/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ims.transactionEngine.InventoryService;

import java.util.ArrayList;
import java.util.List;
import org.ims.dao.entity.ImsLogindetails;
import org.ims.dao.entity.ImsProductdetails;
import org.ims.dao.entitydao.ImsProductcategoryDAO;
import org.ims.dao.entitydao.ImsProductdetailsDAO;
import org.ims.transactionEngine.model.ProductModel;

/**
 *
 * @author Suresh Kumar V
 */
public class ProductService {

    ImsProductdetailsDAO imsproductsdao = new ImsProductdetailsDAO();
    ImsProductcategoryDAO imsproductcategorydao = new ImsProductcategoryDAO();

    public boolean addProduct(ProductModel productdetails, ImsLogindetails logininfo) throws Exception {
        ImsProductdetails product = new ImsProductdetails();
        product.setProductCode(productdetails.getProductcode());
        product.setProductName(productdetails.getProductname());
        product.setImsProductcategory(imsproductcategorydao.findOne(" CategoryCode='"+productdetails.getProductcategorycode() + "'"));
        product.setSpecificationAndThickNess(productdetails.getSpecificationandthickness());
        product.setUnits(productdetails.getUnits());
        product.setSize(productdetails.getSize());
        product.setMoq(productdetails.getMoq());
        product.setColor(productdetails.getColor());
        product.setImsLogindetails(logininfo);
        product.setEnteredDate(productdetails.getEnteredDate());
        imsproductsdao.create(product);

        return true;
    }

    public List<ProductModel> Ims_getProductList() {
        List<ProductModel> productlist = new ArrayList<>();
        List<ImsProductdetails> products = imsproductsdao.findAll();
        for (ImsProductdetails product : products) {
            ProductModel objPrd = new ProductModel();
            objPrd.setProductcode(product.getProductCode());
            objPrd.setProductname(product.getProductName());
            objPrd.setSpecificationandthickness(product.getSpecificationAndThickNess());
            objPrd.setUnits(product.getUnits());
            objPrd.setSize(product.getSize());
            objPrd.setMoq(product.getMoq());
            objPrd.setColor(product.getColor());
            objPrd.setProductcategorycode(product.getImsProductcategory().getCategoryCode());
            objPrd.setEnteredby(product.getImsLogindetails().getUserName());
            objPrd.setEnteredDate(product.getEnteredDate());
            productlist.add(objPrd);
        }
        return productlist;
    }

    public ProductModel Ims_getProductList(String Key) {
        ProductModel objPrd = new ProductModel();
        ImsProductdetails product = imsproductsdao.findOne(Key);
        objPrd.setProductcode(product.getProductCode());
        objPrd.setProductname(product.getProductName());
        objPrd.setSpecificationandthickness(product.getSpecificationAndThickNess());
        objPrd.setUnits(product.getUnits());
        objPrd.setSize(product.getSize());
        objPrd.setMoq(product.getMoq());
        objPrd.setColor(product.getColor());
        objPrd.setProductcategorycode(product.getImsProductcategory().getCategoryCode());
        objPrd.setEnteredby(product.getImsLogindetails().getUserName());
        objPrd.setEnteredDate(product.getEnteredDate());

        return objPrd;
    }
}
