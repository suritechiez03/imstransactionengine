/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ims.transactionEngine.securityManager;

import java.util.List;
import org.ims.dao.entity.ImsAppsettings;
import org.ims.dao.entitydao.ImsAppSettingDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author suri
 */
public class Appsettings {
    ApplicationContext context = new ClassPathXmlApplicationContext("transactionbeans.xml");
    
    public List<ImsAppsettings> getAllAppSettings(){
        ImsAppSettingDAO imsappsettings = (ImsAppSettingDAO) context.getBean("ImsAppSettingsDAO");
        return imsappsettings.findAll();
    }
    
   
    
}
