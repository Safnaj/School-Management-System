package sms.view.controller;
import sms.dbController.SchoolController;
import sms.model.School;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
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
    void addDetails(ActionEvent event) {
        try {
            String SchoolName = SchoolNameField.getText();
            String SchoolAddress = SchoolAddressField.getText();
            Integer classAvailable = Integer.valueOf(classAvailableField.getText());
            String schoolType = schoolTypeField.getText();
            String deoDivision = deoDivisionField.getText();
            String municpalCouncil = municpalCouncilField.getText();
            String policeArea = policeAreaField.getText();
            Integer postalCode = Integer.valueOf(postalCodeField.getText());
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
            Integer pricipalNo = Integer.valueOf(pricipalNoField.getText());


            School sch = new School(SchoolName,SchoolAddress,classAvailable,schoolType,deoDivision,municpalCouncil,policeArea,postalCode,gsDivision,eduZone,eduDistrict,adminDistrict,electorate,dateOfEstd,schoolID,schoolCensus,schoolExamId,totalLandArea,province,nameOfPrincipal,pricipalNo);
            int i = SchoolController.AddDetails(sch);

            if (i > 0) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("School Information");
                alert.setHeaderText(null);
                alert.setContentText("Registered Successfully");
                alert.showAndWait();

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("School Information");
                alert.setHeaderText(null);
                alert.setContentText("OOPs there is an error adding Details");
                alert.showAndWait();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void printDetails(ActionEvent event) {

    }

    @FXML
    void updateDetails(ActionEvent event) {

    }


}
