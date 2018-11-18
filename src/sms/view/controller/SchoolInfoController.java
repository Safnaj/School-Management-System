package sms.view.controller;
import javafx.fxml.FXMLLoader;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import sms.db.DBConnection;
import sms.dbController.SchoolController;
import sms.model.School;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import sms.dbController.StudentController;



/**
 * @author Safnaj on 8/26/2018
 * @project School Management System
 **/
public class SchoolInfoController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            School s = SchoolController.schoolInfo();
            if (s != null) {
                SchoolNameField.setText(s.getSchoolName());
                SchoolAddressField.setText(s.getSchoolAddress());
                classAvailableField.setText(s.getClassAvailable());
                schoolTypeField.setText(s.getSchoolType());
                deoDivisionField.setText(s.getDeoDivision());
                municpalCouncilField.setText(s.getMunicpalCouncil());
                policeAreaField.setText(s.getPoliceArea());
                postalCodeField.setText(s.getPostalCode());
                gsDivisionField.setText(s.getDeoDivision());
                eduZoneField.setText(s.getEduZone());
                eduDistrictField.setText(s.getEduDistrict());
                adminDistrictField.setText(s.getAdminDistrict());
                electorateField.setText(s.getElectorate());
                dateOfEstdField.setText(s.getDateOfEstd());
                schoolIDField.setText(s.getSchoolID());
                schoolCensusField.setText(s.getSchoolCensus());
                schoolExamIdField.setText(s.getSchoolExamId());
                totalLandAreaField.setText(s.getTotalLandArea());
                provinceField.setText(s.getProvince());
                nameOfPrincipalField.setText(s.getNameOfPrincipal());
                pricipalNoField.setText(s.getPricipalNo());


            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("School Information");
                alert.setHeaderText(null);
                alert.setContentText("No Information Found..!");
                alert.showAndWait();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SchoolController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    private AnchorPane root;

    @FXML
    private TextField SchoolNameField;

    @FXML
    private TextField SchoolAddressField;

    @FXML
    private TextField classAvailableField;

    @FXML
    private TextField schoolTypeField;

    @FXML
    private TextField deoDivisionField;

    @FXML
    private TextField municpalCouncilField;

    @FXML
    private TextField policeAreaField;

    @FXML
    private TextField postalCodeField;

    @FXML
    private TextField gsDivisionField;

    @FXML
    private JFXButton updateDetails;

    @FXML
    private JFXButton addDetails;

    @FXML
    private TextField eduZoneField;

    @FXML
    private TextField eduDistrictField;

    @FXML
    private TextField adminDistrictField;

    @FXML
    private TextField electorateField;

    @FXML
    private TextField dateOfEstdField;

    @FXML
    private TextField schoolIDField;

    @FXML
    private TextField schoolCensusField;

    @FXML
    private TextField schoolExamIdField;

    @FXML
    private TextField totalLandAreaField;

    @FXML
    private TextField provinceField;

    @FXML
    private TextField nameOfPrincipalField;

    @FXML
    private TextField pricipalNoField;

    @FXML
    private JFXButton printDetails;

    @FXML
    private JFXButton Back;

    @FXML
    void Back(ActionEvent event) {

        try {
            AnchorPane user = FXMLLoader.load(getClass().getResource(("/sms/view/fxml/MainDashboard.fxml")));
            root.getChildren().setAll(user);
        }catch(IOException e){
            System.out.println(e);
        }

    }

    @FXML
    void addDetails(ActionEvent event) {            //This Method Button Removed Due to Unwanted
        try {

            ValidationController v = new ValidationController();

            if (v.numbersOnly(classAvailableField)&&(v.numbersOnly(postalCodeField))&&(v.validatePhone(pricipalNoField))) {

                String SchoolName = SchoolNameField.getText();
                String SchoolAddress = SchoolNameField.getText();
                String classAvailable = classAvailableField.getText();
                String schoolType = schoolTypeField.getText();
                String deoDivision = deoDivisionField.getText();
                String municpalCouncil = municpalCouncilField.getText();
                String policeArea = policeAreaField.getText();
                String postalCode = postalCodeField.getText();
                String gsDivision = gsDivisionField.getText();
                String eduZone = eduZoneField.getText();
                String eduDistrict = eduDistrictField.getText();
                String adminDistrict = adminDistrictField.getText();
                String electorate = electorateField.getText();
                String dateOfEstd = dateOfEstdField.getText();
                String schoolID = schoolIDField.getText();
                String schoolCensus = schoolCensusField.getText();
                String schoolExamId = schoolExamIdField.getText();
                String totalLandArea = totalLandAreaField.getText();
                String province = provinceField.getText();
                String nameOfPrincipal = nameOfPrincipalField.getText();
                String pricipalNo = pricipalNoField.getText();


                School sch = new School(SchoolName, SchoolAddress, classAvailable, schoolType, deoDivision, municpalCouncil, policeArea, postalCode, gsDivision, eduZone, eduDistrict, adminDistrict, electorate, dateOfEstd, schoolID, schoolCensus, schoolExamId, totalLandArea, province, nameOfPrincipal, pricipalNo);
                int i = SchoolController.AddDetails(sch);

                if (i > 0) {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("School Information");
                    alert.setHeaderText(null);
                    alert.setContentText("Updated Successfully");
                    alert.showAndWait();

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("School Information");
                    alert.setHeaderText(null);
                    alert.setContentText("OOPs there is an error in Updating Details..!");
                    alert.showAndWait();
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void printDetails(ActionEvent event) {

        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            InputStream report = getClass().getResourceAsStream("/sms/Reports/SchoolInfo.jrxml");
            JasperDesign jd = JRXmlLoader.load(report);
            JRDesignQuery query = new JRDesignQuery();
            query.setText("select * from schoolinfo");
            jd.setQuery(query);
            ReportViewController r = new ReportViewController();
            r.viewReport(jd);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JRException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void updateDetails(ActionEvent event) {
        try {
            String SchoolName = SchoolNameField.getText();
            String SchoolAddress = SchoolAddressField.getText();
            String classAvailable = classAvailableField.getText();
            String schoolType = schoolTypeField.getText();
            String deoDivision = deoDivisionField.getText();
            String municpalCouncil = municpalCouncilField.getText();
            String policeArea = policeAreaField.getText();
            String postalCode = postalCodeField.getText();
            String gsDivision = gsDivisionField.getText();
            String eduZone = eduZoneField.getText();
            String eduDistrict = eduDistrictField.getText();
            String adminDistrict = adminDistrictField.getText();
            String electorate = electorateField.getText();
            String dateOfEstd = dateOfEstdField.getText();
            String schoolID = schoolIDField.getText();
            String schoolCensus = schoolCensusField.getText();
            String schoolExamId = schoolExamIdField.getText();
            String totalLandArea = totalLandAreaField.getText();
            String province = provinceField.getText();
            String nameOfPrincipal = nameOfPrincipalField.getText();
            String pricipalNo = pricipalNoField.getText();

            School sch = new School(SchoolName,SchoolAddress,classAvailable,schoolType,deoDivision,municpalCouncil,policeArea,postalCode,gsDivision,eduZone,eduDistrict,adminDistrict,electorate,dateOfEstd,schoolID,schoolCensus,schoolExamId,totalLandArea,province,nameOfPrincipal,pricipalNo);
            int i = SchoolController.updateInfo(sch);

            if (i > 0) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("School Information");
                alert.setHeaderText(null);
                alert.setContentText("Information Updated Successfully...!");
                alert.showAndWait();

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("School Information");
                alert.setHeaderText(null);
                alert.setContentText("OOPs there is an error Updating Details");
                alert.showAndWait();
            }

        }catch (ClassNotFoundException | SQLException ex) {
           Logger.getLogger(SchoolController.class.getName()).log(Level.SEVERE, null, ex);
    }

    }
}
