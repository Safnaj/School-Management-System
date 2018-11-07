package sms.view.controller;



import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.view.JasperViewer;
import sms.db.DBConnection;
import java.sql.Connection;
import java.sql.SQLException;



/**
 * @author Safnaj on 9/24/2018
 * @project School Management System
 **/
public class ReportViewController {

    public void viewReport(JasperDesign report){

        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            JasperReport jr = JasperCompileManager.compileReport(report);
            JasperPrint jp = JasperFillManager.fillReport(jr,null,conn);
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
