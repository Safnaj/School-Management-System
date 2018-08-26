package sms.view.controller;

import com.jfoenix.controls.JFXRadioButton;
import sms.dbController.StudentController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import sms.model.Student;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import java.sql.SQLException;
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
    private ComboBox<String> gradeField;

    @FXML
    private TextField parentNameField;

    @FXML
    private TextField nicField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField addressField;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void AddStudent(ActionEvent event){
        try {
            int adNo = Integer.parseInt(adNoField.getText());
            String fullName = fullNameField.getText();
            String name = nameField.getText();
            String dob = dobField.getText();
            String doa = doaField.getText();
            RadioButton selectedRadioButton = (RadioButton) g.getSelectedToggle(); //Getting Selected Radio Button
            String gender = selectedRadioButton.getText();
            String grade = gradeField.getValue();
            String parentName = parentNameField.getText();
            String nic = nicField.getText();
            Integer phone = Integer.parseInt(phoneField.getText());
            String address = addressField.getText();


            Student s =  new Student(adNo, fullName, name, dob, doa, gender, grade, parentName, nic, phone, address);
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
                alert.setHeaderText("This is an error dialog");
                alert.setContentText("OOPs there is an error adding Student");
                alert.showAndWait();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    @FXML
    private void cancel(){

    }
}
