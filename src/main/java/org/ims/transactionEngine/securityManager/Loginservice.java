/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ims.transactionEngine.securityManager;

import org.ims.dao.entity.ImsLogindetails;
import org.ims.dao.entitydao.ImsLogindetailsDAO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author suri
 */
public class Loginservice {
    @Autowired    
    ImsLogindetailsDAO imslogindao ;
    public boolean isUserExisits(String username,String password){
        
        if (imslogindao.findOne(username).getUserPassword().endsWith(password)){
            return true;
        }
            return false;
    }
   
   public ImsLogindetails getLoggedinUserinfo(String username){
       return imslogindao.findOne(username);
   }
}
