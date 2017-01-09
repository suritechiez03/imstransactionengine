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
import org.ims.dao.entity.ImsStockdetails;
import org.ims.dao.entitydao.ImsProductcategoryDAO;
import org.ims.dao.entitydao.ImsProductdetailsDAO;
import org.ims.dao.entitydao.ImsStockdetailsDAO;
import org.ims.transactionEngine.model.ProductModel;
import org.ims.transactionEngine.model.StockModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Suresh Kumar V
 */
public class ProductService {
    @Autowired
    ImsProductdetailsDAO imsproductsdao ;
    @Autowired
    ImsProductcategoryDAO imsproductcategorydao ;
    @Autowired
    ImsStockdetailsDAO imsStockdetailsDAO;
    
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
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
            objPrd.setStockdetails(getStockDetails(product.getProductCode()));
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
        objPrd.setStockdetails(getStockDetails(product.getProductCode()));
        objPrd.setEnteredby(product.getImsLogindetails().getUserName());
        objPrd.setEnteredDate(product.getEnteredDate());

        return objPrd;
    }
    
    public StockModel getStockDetails(String PrdCode){
        StockModel stock=new StockModel();
        stock.setProductCode(PrdCode);
        ImsStockdetails stockdet=imsStockdetailsDAO.findOne(" ProductCode='" +PrdCode+"'");
        stock.setAvailableQty(stockdet.getAvailableQty());
        stock.setDispatchedQty(stockdet.getDispatchedQty());
        stock.setMarginPercentage(stockdet.getOurMarginPercentage());
        stock.setMerginAmount(stockdet.getOurMerginAmount());
        stock.setPurchasedQty(stockdet.getPurchasedQty());
        stock.setDealerPrice(stockdet.getDealerPrice());
        
        return stock;
    }
}
