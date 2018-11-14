package sms.view.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Track;
import sms.db.DBConnection;
import sms.dbController.GradeController;
import sms.dbController.TransferController;
import sms.dbController.UserController;
import sms.model.Student;
import sms.model.User;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * @author Safnaj on 11/5/2018
 * @project School Management System
 **/
public class TransferStudentsController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadCombo1();
        loadCombo2();
        loadComboBox();
    }

    @FXML
    private AnchorPane root;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton move1;

    @FXML
    private ComboBox<String> loadCombo;

    @FXML
    private TextField yearField;

    @FXML
    private ComboBox<String> loadCombo1;

    @FXML
    private ComboBox<String> loadCombo2;

    @FXML
    private JFXButton searchStudent1;

    @FXML
    private JFXButton Back;

    @FXML
    void Back(ActionEvent event) {

        try {
            AnchorPane studentMgmt = FXMLLoader.load(getClass().getResource(("/sms/view/fxml/StudentManagement.fxml")));
            root.getChildren().setAll(studentMgmt);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    @FXML
    void btnUpdate(ActionEvent event) {

    }

    @FXML
    void loadCombo1() {
        ArrayList arrayList = null;
        try {
            arrayList = GradeController.getGrades();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        ObservableList observableArray = FXCollections.observableArrayList();
        observableArray.addAll(arrayList);

        if (observableArray != null) {
            loadCombo1.setItems(observableArray);
        }
    }

    @FXML
    void loadCombo2() {
        ArrayList arrayList = null;
        try {
            arrayList = GradeController.getGrades();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        ObservableList observableArray = FXCollections.observableArrayList();
        observableArray.addAll(arrayList);

        if (observableArray != null) {
            loadCombo2.setItems(observableArray);
        }
    }

    @FXML
    void loadComboBox() {
        ArrayList arrayList = null;
        try {
            arrayList = GradeController.getGrades();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        ObservableList observableArray = FXCollections.observableArrayList();
        observableArray.addAll(arrayList);

        if (observableArray != null) {
            loadCombo.setItems(observableArray);
        }
    }

    @FXML
    void move1(ActionEvent event) {
        try {

        String grade5 = loadCombo.getValue();
        String year = yearField.getText();

            Connection conn = DBConnection.getDBConnection().getConnection();

            String sql ="INSERT INTO paststudents (adNo,fullName,name,dob,doa,gender,year,parentName,nic,phone,address) " +
                        "SELECT * FROM students where grade = 'Grade 5'";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.executeUpdate();

            int a = TransferController.deleteStudent(grade5);
            int b = TransferController.updateGrade(year);

            if (a > 0) {

                if(b > 0) {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Transfer Students");
                    alert.setHeaderText(null);
                    alert.setContentText("Updated..!");
                    alert.showAndWait();
                }

            }else {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Transfer Students");
                alert.setHeaderText(null);
                alert.setContentText("Oops..! There is an Error in Transfering Students..!");
                alert.showAndWait();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @FXML
    void move2(ActionEvent event) {
        try {

            String gradeA = loadCombo1.getValue();
            String gradeB = loadCombo2.getValue();

            Connection conn = DBConnection.getDBConnection().getConnection();

            String sql = "UPDATE students SET grade= '" + gradeB + "' WHERE grade= '" + gradeA + "'";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Transfer Students");
            alert.setHeaderText(null);
            alert.setContentText("Grade Updated Successfully..!");
            alert.showAndWait();

            loadCombo1.setValue(null);
            loadCombo2.setValue(null);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
