package sms.view.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import sms.db.DBConnection;
import sms.dbController.StaffController;
import sms.dbController.StudentController;
import sms.model.Staff;
import sms.model.Student;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Safnaj on 11/1/2018
 * @project School Management System
 **/
public class ManageStaffsController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private AnchorPane root;

    @FXML
    private TextField empNoField;

    @FXML
    private TextField teacherNameField;

    @FXML
    private TextField nicField;

    @FXML
    private TextField dobField;

    @FXML
    private TextField doaField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField addressField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField asmOfDutyField;

    @FXML
    private TextField incDateField;

    @FXML
    private TextField prsntGradeField;

    @FXML
    private TextField empNoOld;

    @FXML
    private JFXButton deleteStaff;

    @FXML
    private JFXButton update;

    @FXML
    private TextField genderField;

    @FXML
    private TextField EmpNo;

    @FXML
    private JFXButton searchStaff;

    @FXML
    private TextField empName;

    @FXML
    private JFXButton searchByName;

    @FXML
    private JFXButton searchOldStaff;

    @FXML
    private JFXButton printStaff;

    @FXML
    private JFXButton Back;

    @FXML
    void Back(ActionEvent event) {
        try {
            AnchorPane studentMgmt = FXMLLoader.load(getClass().getResource(("/sms/view/fxml/StaffManagement.fxml")));
            root.getChildren().setAll(studentMgmt);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    @FXML
    void searchByName(ActionEvent event) {
        try {
            String teacherName = empName.getText();
            Staff s = StaffController.searchStaffByName(teacherName);
            if (s != null) {
                empNoField.setText(String.valueOf(s.getEmpNo()));
                teacherNameField.setText(s.getTeacherName());
                nicField.setText(s.getNic());
                dobField.setText(s.getDob());
                doaField.setText(s.getDoa());
                genderField.setText(s.getGender());
                emailField.setText(s.getEmail());
                asmOfDutyField.setText(s.getAssumpOfDuties());
                phoneField.setText(s.getPhone());
                addressField.setText(s.getAddress());
                incDateField.setText(s.getIncDate());
                prsntGradeField.setText(s.getPrsntGrade());


            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Staff Search");
                alert.setHeaderText(null);
                alert.setContentText("Staff Not Found");
                alert.showAndWait();

                empNoField.setText(null);
                teacherNameField.setText(null);
                nicField.setText(null);
                dobField.setText(null);
                doaField.setText(null);
                emailField.setText(null);
                asmOfDutyField.setText(null);
                nicField.setText(null);
                genderField.setText(null);
                phoneField.setText(null);
                addressField.setText(null);
                incDateField.setText(null);
                prsntGradeField.setText(null);
                empName.setText(null);
                empNoOld.setText(null);
                EmpNo.setText(null);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void searchOldStaff(ActionEvent event) {
        try {
            int EmpNo2 = Integer.parseInt(empNoOld.getText());
            Staff s = StaffController.searchOldStaff(EmpNo2);
            if (s != null) {
                empNoField.setText(String.valueOf(s.getEmpNo()));
                teacherNameField.setText(s.getTeacherName());
                nicField.setText(s.getNic());
                dobField.setText(s.getDob());
                doaField.setText(s.getDoa());
                genderField.setText(s.getGender());
                emailField.setText(s.getEmail());
                asmOfDutyField.setText(s.getAssumpOfDuties());
                phoneField.setText(s.getPhone());
                addressField.setText(s.getAddress());
                incDateField.setText(s.getIncDate());
                prsntGradeField.setText(s.getPrsntGrade());


            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Staff Search");
                alert.setHeaderText(null);
                alert.setContentText("Staff Not Found");
                alert.showAndWait();

                empNoField.setText(null);
                teacherNameField.setText(null);
                nicField.setText(null);
                dobField.setText(null);
                doaField.setText(null);
                emailField.setText(null);
                asmOfDutyField.setText(null);
                nicField.setText(null);
                genderField.setText(null);
                phoneField.setText(null);
                addressField.setText(null);
                incDateField.setText(null);
                prsntGradeField.setText(null);
                empName.setText(null);
                empNoOld.setText(null);
                EmpNo.setText(null);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void searchStaff(ActionEvent event) {
        try {
            int empNo = Integer.parseInt(EmpNo.getText());
            Staff s = StaffController.searchStaff(empNo);
            if (s != null) {
                empNoField.setText(String.valueOf(s.getEmpNo()));
                teacherNameField.setText(s.getTeacherName());
                nicField.setText(s.getNic());
                dobField.setText(s.getDob());
                doaField.setText(s.getDoa());
                genderField.setText(s.getGender());
                emailField.setText(s.getEmail());
                asmOfDutyField.setText(s.getAssumpOfDuties());
                phoneField.setText(s.getPhone());
                addressField.setText(s.getAddress());
                incDateField.setText(s.getIncDate());
                prsntGradeField.setText(s.getPrsntGrade());


            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Staff Search");
                alert.setHeaderText(null);
                alert.setContentText("Staff Not Found");
                alert.showAndWait();

                empNoField.setText(null);
                teacherNameField.setText(null);
                nicField.setText(null);
                dobField.setText(null);
                doaField.setText(null);
                emailField.setText(null);
                asmOfDutyField.setText(null);
                nicField.setText(null);
                genderField.setText(null);
                phoneField.setText(null);
                addressField.setText(null);
                incDateField.setText(null);
                prsntGradeField.setText(null);
                empName.setText(null);
                empNoOld.setText(null);
                EmpNo.setText(null);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void deleteStaff(ActionEvent event) {
        try {
            int empNo = Integer.parseInt(empNoField.getText());
            Staff s = new Staff(Integer.parseInt(empNoField.getText()), teacherNameField.getText(), nicField.getText(), dobField.getText(), doaField.getText(),
                    genderField.getText(), emailField.getText(), asmOfDutyField.getText(), phoneField.getText(), addressField.getText(), incDateField.getText(),prsntGradeField.getText());

            int moveStaff = StaffController.moveStaff(s);
            if (moveStaff > 0) {

                int deleteStaff = StaffController.deleteStaff(empNo);
                if (deleteStaff > 0) {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Staff Management");
                    alert.setHeaderText(null);
                    alert.setContentText("Staff " + empNo + " Has Been Deleted Sucessfully..!");
                    alert.showAndWait();

                    empNoField.setText(null);
                    teacherNameField.setText(null);
                    nicField.setText(null);
                    dobField.setText(null);
                    doaField.setText(null);
                    emailField.setText(null);
                    genderField.setText(null);
                    asmOfDutyField.setText(null);
                    nicField.setText(null);
                    phoneField.setText(null);
                    addressField.setText(null);
                    incDateField.setText(null);
                    prsntGradeField.setText(null);


                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Staff Management");
                    alert.setHeaderText(null);
                    alert.setContentText("There is an error deleting Staff..!");
                    alert.showAndWait();
                }
            }
        } catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void printStaff(ActionEvent event) {
        try {
            String empNo = empNoField.getText();

            InputStream report1 = getClass().getResourceAsStream("/sms/Reports/StaffInfo.jrxml");
            InputStream report2 = getClass().getResourceAsStream("/sms/Reports/StaffInfoPast.jrxml");

            JRDesignQuery query = new JRDesignQuery();

            if(empNoOld.getText().isEmpty()){

                JasperDesign jd = JRXmlLoader.load(report1);
                query.setText("select * from staffs where empNo = '" + empNo + "'");
                jd.setQuery(query);
                ReportViewController r = new ReportViewController();
                r.viewReport(jd);
            }
            else{

                JasperDesign jd2 = JRXmlLoader.load(report2);
                query.setText("select * from oldstaffs where empNo = '" + empNo + "'");
                jd2.setQuery(query);
                ReportViewController r = new ReportViewController();
                r.viewReport(jd2);
            }

        } catch (JRException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void update(ActionEvent event) {
        try {

            ValidationController v = new ValidationController();

            if(v.validateEmpty(empNoField)&& v.validateEmpty(teacherNameField)&& v.validateEmpty(nicField)&& v.validateEmpty(dobField)
                    && v.validateEmpty(doaField)&& v.validateEmpty(phoneField)&& v.validateDate(dobField)&& v.validateDate(doaField)&& v.validateDate(asmOfDutyField)
                    && v.validateDate(incDateField)&& v.validateNIC(nicField)&& v.validatePhone(phoneField)&& v.numbersOnly(empNoField)&& v.numbersOnly(phoneField)){


                int empNo = Integer.parseInt(empNoField.getText());
                String teacherName = teacherNameField.getText();
                String nic = nicField.getText();
                String dob = dobField.getText();
                String doa = doaField.getText();
                String gender = genderField.getText();
                String email = emailField.getText();
                String assumpOfDuties = asmOfDutyField.getText();
                String phone = phoneField.getText();
                String address = addressField.getText();
                String incDate = incDateField.getText();
                String prsntGrade = prsntGradeField.getText();

                Staff s = new Staff(empNo, teacherName, nic, dob, doa, gender, email, assumpOfDuties, phone, address, incDate, prsntGrade);
                int i = StaffController.updateStaff(s);
                int d = StaffController.updateOldStaff(s);

                if (i > 0){

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Staff Management");
                    alert.setHeaderText(null);
                    alert.setContentText("Staff Informations Updated Successfully..!");
                    alert.showAndWait();

                    empNoField.setText(null);
                    teacherNameField.setText(null);
                    nicField.setText(null);
                    dobField.setText(null);
                    doaField.setText(null);
                    emailField.setText(null);
                    genderField.setText(null);
                    asmOfDutyField.setText(null);
                    nicField.setText(null);
                    phoneField.setText(null);
                    addressField.setText(null);
                    incDateField.setText(null);
                    prsntGradeField.setText(null);

                }
                else if (d > 0) {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Staff Management");
                    alert.setHeaderText(null);
                    alert.setContentText("Staff Informations Updated Successfully..!");
                    alert.showAndWait();

                    empNoField.setText(null);
                    teacherNameField.setText(null);
                    nicField.setText(null);
                    dobField.setText(null);
                    doaField.setText(null);
                    emailField.setText(null);
                    genderField.setText(null);
                    asmOfDutyField.setText(null);
                    nicField.setText(null);
                    phoneField.setText(null);
                    addressField.setText(null);
                    incDateField.setText(null);
                    prsntGradeField.setText(null);

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Staff Management");
                    alert.setHeaderText(null);
                    alert.setContentText("OOPS there is an error updating Staff..!");
                    alert.showAndWait();
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

