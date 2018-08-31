package sms.view.controller;


import com.jfoenix.controls.JFXRadioButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

    @Override
    public void initialize(URL location, ResourceBundle resources){
        loadComboBox();
    }
    @FXML
    private void AddStudent(ActionEvent event) {
        try {
            if (validateFields() == true ) {

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
                    alert.setContentText("Student Registered Successfully");
                    alert.showAndWait();
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
    private void cancel() {

    }

    @FXML
    private void loadComboBox(){
        ArrayList arrayList = null;
        try {
            arrayList = GradeController.getGrades();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        for (Object s: arrayList
             ) {

        }

        ObservableList observableArray = FXCollections.observableArrayList();
        observableArray.addAll(arrayList);

        if (observableArray != null){
            loadCombo.setItems(observableArray);
        }

    }

    private boolean validateFields(){
        if(adNoField.getText().isEmpty() || nameField.getText().isEmpty() || dobField.getText().isEmpty() ||
                doaField.getText().isEmpty() || parentNameField.getText().isEmpty() || phoneField.getText().isEmpty())

        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Student Registration");
            alert.setHeaderText(null);
            alert.setContentText("Please Fill Required Fields");
            alert.showAndWait();

            return false;

        }
        return true;
    }

}



