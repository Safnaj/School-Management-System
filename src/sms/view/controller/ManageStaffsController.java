package sms.view.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import sms.dbController.StaffController;
import sms.dbController.StudentController;
import sms.model.Staff;
import sms.model.Student;

import java.net.URL;
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
                emailField.setText(s.getGender());
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
                emailField.setText(s.getGender());
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
                emailField.setText(s.getGender());
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
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void deleteStaff(ActionEvent event) {

    }

    @FXML
    void printStaff(ActionEvent event) {

    }

    @FXML
    void update(ActionEvent event) {

    }
}
