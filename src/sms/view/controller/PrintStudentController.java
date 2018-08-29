package sms.view.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Safnaj on 8/29/2018
 * @project School Management System
 **/
public class PrintStudentController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private TextField adNo;

    @FXML
    private JFXButton printStudents;

    @FXML
    private JFXButton generate;

    @FXML
    private ComboBox<?> loadGrades;

    @FXML
    void generate(ActionEvent event) {

    }

    @FXML
    void loadGrades(ActionEvent event) {

    }

    @FXML
    void printStudents(ActionEvent event) {

    }
}
