/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ims.transactionEngine.securityManager;

import java.util.List;
import org.ims.dao.entity.ImsAppsettings;
import org.ims.dao.entitydao.ImsAppSettingDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author suri
 */
public class Appsettings  {

    @Autowired
    private ImsAppSettingDAO imsappsettings ;
    public List<ImsAppsettings> getAllAppSettings(){
        
        return imsappsettings.findAll();
    }
    
   
    
}
