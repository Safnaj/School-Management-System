package sms.view.controller;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import sms.db.DBConnection;
import sms.dbController.GradeController;
import sms.dbController.StudentController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import sms.model.Grade;
import sms.model.Student;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author chamodshehanka on 7/16/2018
 * @project School-Management-System
 **/

public class RegisterStudentController implements Initializable {
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
    private JFXRadioButton genderField;

    @FXML
    private ToggleGroup g;

    @FXML
    private ComboBox<String> loadCombo;

    @FXML
    private TextField parentNameField;

    @FXML
    private TextField nicField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField addressField;

    @FXML
    private JFXButton Back;

    @FXML
    private AnchorPane root;



    @Override
    public void initialize(URL location, ResourceBundle resources){

        loadComboBox();
    }

    @FXML
    void Back() {
        try {
            AnchorPane studentMgmt = FXMLLoader.load(getClass().getResource(("/sms/view/fxml/StudentManagement.fxml")));
            root.getChildren().setAll(studentMgmt);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    @FXML
    private void AddStudent(ActionEvent event) {
        try {

            ValidationController v = new ValidationController();

           // if(ValidationController.validateEmpty(adNoField)) //This can be used for Static Methods

            if (v.validateEmpty(adNoField) && v.validateEmpty(nameField) && v.validateEmpty(dobField) && v.validateEmpty(doaField) &&
                    v.validateEmpty(parentNameField) && v.validateEmpty(phoneField) && v.validateNIC(nicField) && v.numbersOnly(adNoField)
                    && v.validatePhone(phoneField) && v.validateDate(doaField) && v.validateDate(dobField)) {


                int adNo = Integer.parseInt(adNoField.getText());
                String fullName = fullNameField.getText();
                String name = nameField.getText();
                String dob = dobField.getText();
                String doa = doaField.getText();
                RadioButton selectedRadioButton = (RadioButton) g.getSelectedToggle(); //Getting Selected Radio Button
                String gender = selectedRadioButton.getText();
                String grade = loadCombo.getValue();
                String parentName = parentNameField.getText();
                String nic = nicField.getText();
                String phone = phoneField.getText();
                String address = addressField.getText();

                Student s = new Student(adNo, fullName, name, dob, doa, gender, grade, parentName, nic, phone, address);
                int i = StudentController.AddStudent(s);

                if (i > 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Student Registration");
                    alert.setHeaderText(null);
                    alert.setContentText("Student ID " + adNo + " Registered Successfully..!");
                    alert.showAndWait();

                    adNoField.setText(null);
                    fullNameField.setText(null);
                    nameField.setText(null);
                    dobField.setText(null);
                    doaField.setText(null);
                    loadCombo.setValue(null);
                    adNoField.setText(null);
                    parentNameField.setText(null);
                    nicField.setText(null);
                    phoneField.setText(null);
                    fullNameField.setText(null);
                    addressField.setText(null);

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Student Registration");
                    alert.setHeaderText(null);
                    alert.setContentText("OOPs there is an error adding Student");
                    alert.showAndWait();
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void reset() {

        adNoField.setText(null);
        fullNameField.setText(null);
        nameField.setText(null);
        dobField.setText(null);
        doaField.setText(null);
        loadCombo.setValue(null);
        adNoField.setText(null);
        parentNameField.setText(null);
        nicField.setText(null);
        phoneField.setText(null);
        fullNameField.setText(null);
        addressField.setText(null);
    }

    @FXML
    private void loadComboBox(){
        ArrayList arrayList = null;
        try {
            arrayList = GradeController.getGrades();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        ObservableList observableArray = FXCollections.observableArrayList();
        observableArray.addAll(arrayList);

        if (observableArray != null){
            loadCombo.setItems(observableArray);
        }

    }

}



