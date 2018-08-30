package sms.view.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ResourceBundle;

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
    private TextField AdNo;

    @FXML
    private JFXButton searchStudent;

    @FXML
    private JFXButton btnPrint;

    @FXML
    private ComboBox<?> loadCombo;

    @FXML
    void btnDelete(ActionEvent event) {

    }

    @FXML
    void btnPrint(ActionEvent event) {

    }

    @FXML
    void btnUpdate(ActionEvent event) {

    }

    @FXML
    void searchStudent(ActionEvent event) {

    }

}

