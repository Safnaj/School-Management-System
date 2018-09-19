package sms.view.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import sms.dbController.GradeController;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * @author Safnaj on 8/29/2018
 * @project School Management System
 **/
public class PrintStudentController implements Initializable {


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadGrades();
        loadGender.getItems().addAll("All", "Male", "Female");
    }


    @FXML
    private ComboBox<String> loadGrades;

    @FXML
    private ComboBox<?> loadYears;

    @FXML
    private ComboBox<String> loadGender;

    @FXML
    private JFXButton generate;

    @FXML
    private JFXButton printStudents;


    @FXML
    void loadGender(ActionEvent event) {

    }

    @FXML
    void loadGrades(ActionEvent event) {

    }

    @FXML
    void loadYears(ActionEvent event) {

    }

    @FXML
    void generate(ActionEvent event) {

    }

    @FXML
    void printStudents(ActionEvent event) {

    }

    @FXML
    private void loadGrades() {
        ArrayList arrayList = null;
        try {
            arrayList = GradeController.getGrades();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        ObservableList observableArray = FXCollections.observableArrayList();
        observableArray.addAll(arrayList);

        if (observableArray != null) {
            loadGrades.setItems(observableArray);
        }


    }
}

