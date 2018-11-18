package sms.view.controller;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.view.JasperViewer;
import sms.db.DBConnection;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;


/**
 * @author Safnaj on 9/24/2018
 * @project School Management System
 **/
public class ReportViewController {

    public void viewReport(JasperDesign report){

        try {
            HashMap<String,Object> Logo = new HashMap<String, Object>();

            URL url = this.getClass().getClassLoader().getResource("sms/other/img/HikmaLogo.jpg");
            Logo.put("Logo", url);

            //Above Code for Getting Logo in Report

            Connection conn = DBConnection.getDBConnection().getConnection();
            JasperReport jr = JasperCompileManager.compileReport(report);
            //JasperPrint jp = JasperFillManager.fillReport(jr,null,conn);
            JasperPrint jp = JasperFillManager.fillReport(jr,Logo,conn);
            JasperViewer.viewReport(jp,false);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JRException e) {
            e.printStackTrace();
        }

    }
   }
