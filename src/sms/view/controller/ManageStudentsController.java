package sms.view.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import sms.dbController.StudentController;
import sms.model.Student;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Safnaj on 8/12/2018
 * @project School Management System
 **/

public class ManageStudentsController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private AnchorPane manageStudents;


    @FXML
    private TextField AdNo;

    @FXML
    private TextField adNoField;

    @FXML
    private TextField fullNameField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField dobField;

    @FXML
    private TextField doaField;

    @FXML
    private TextField genderField;

    @FXML
    private TextField gradeField;

    @FXML
    private TextField parentNameField;

    @FXML
    private TextField nicField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField addressField;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton searchStudent;

    @FXML
    private JFXButton btnPrint;

    //Delete Method
    @FXML
    void btnDelete(ActionEvent event) {
        try {
            String adNo = adNoField.getText();
            int deleteStudent2 = StudentController.deleteStudent(adNo);
            if (deleteStudent2 > 0) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Student Delete");
                alert.setHeaderText(null);
                alert.setContentText("Student "+adNo+" has been deleted sucessfully..!");
                alert.showAndWait();

                AdNo.setText(null);
                adNoField.setText(null);
                fullNameField.setText(null);
                nameField.setText(null);
                dobField.setText(null);
                doaField.setText(null);
                gradeField.setText(null);
                genderField.setText(null);
                adNoField.setText(null);
                parentNameField.setText(null);
                nicField.setText(null);
                phoneField.setText(null);
                fullNameField.setText(null);
                addressField.setText(null);


            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Student Delete");
                alert.setHeaderText(null);
                alert.setContentText("There is an error deleting Student");
                alert.showAndWait();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    void btnPrint(ActionEvent event) {

    }

    //Update Method
    @FXML
    void btnUpdate(ActionEvent event)throws SQLException {
        try {

            ValidationController v = new ValidationController();

            if(v.validateNIC(nicField) && v.numbersOnly(adNoField) && v.validatePhone(phoneField)) {

                int adNo = Integer.parseInt(adNoField.getText());
                String fullName = fullNameField.getText();
                String name = nameField.getText();
                String dob = dobField.getText();
                String doa = doaField.getText();
                String gender = genderField.getText();
                String grade = gradeField.getText();
                String parentName = parentNameField.getText();
                String nic = nicField.getText();
                String phone = phoneField.getText();
                String address = addressField.getText();

                Student s = new Student(adNo, fullName, name, dob, doa, gender, grade, parentName, nic, phone, address);
                int i = StudentController.updateStudent(s);

                if (i > 0) {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Student Management");
                    alert.setHeaderText(null);
                    alert.setContentText("Student " + adNo + " Updated Successfully..!");
                    alert.showAndWait();

                    AdNo.setText(null);
                    adNoField.setText(null);
                    fullNameField.setText(null);
                    nameField.setText(null);
                    dobField.setText(null);
                    doaField.setText(null);
                    gradeField.setText(null);
                    genderField.setText(null);
                    adNoField.setText(null);
                    parentNameField.setText(null);
                    nicField.setText(null);
                    phoneField.setText(null);
                    fullNameField.setText(null);
                    addressField.setText(null);

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Student Management");
                    alert.setHeaderText(null);
                    alert.setContentText("OOPs there is an error updating Student..!");
                    alert.showAndWait();
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    //Search Method
    @FXML
    void searchStudent(ActionEvent event) {
        try {
            int adNo = Integer.parseInt(AdNo.getText());
            Student s = StudentController.searchStudent(adNo);
            if (s != null) {
                adNoField.setText(String.valueOf(s.getAdNo()));
                fullNameField.setText(s.getFullName());
                nameField.setText(s.getName());
                dobField.setText(s.getDob());
                doaField.setText(s.getDoa());
                genderField.setText(s.getGender());
                gradeField.setText(s.getGrade());
                parentNameField.setText(s.getParentName());
                nicField.setText(s.getNic());
                phoneField.setText(s.getPhone());
                addressField.setText(s.getAddress());


            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Student Search");
                alert.setHeaderText(null);
                alert.setContentText("Student Not Found");
                alert.showAndWait();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}



