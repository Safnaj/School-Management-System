package sms.view.controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author Safnaj on 8/12/2018
 * @project School Management System
 **/

public class StudentManagementController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private ImageView StaffMgmt;

    @FXML
    private ImageView StudentMgmt;

    @FXML
    private JFXButton btnStudentReg;

    @FXML
    private JFXButton btnStudentMnge;

    @FXML
    private JFXButton btnPrintStudents;

    @FXML
    private AnchorPane manageStudents;

    @FXML
    private JFXButton Back;

    @FXML
    void Back() {
        try {
            AnchorPane studentMgmt = FXMLLoader.load(getClass().getResource(("/sms/view/fxml/MainDashboard.fxml")));
            manageStudents.getChildren().setAll(studentMgmt);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    @FXML
    void SetBtnStudentReg(ActionEvent event) {
        try {
            AnchorPane studentMgmt = FXMLLoader.load(getClass().getResource(("/sms/view/fxml/RegisterStudent.fxml")));
            manageStudents.getChildren().setAll(studentMgmt);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    @FXML
    void setBtnStudentMnge(ActionEvent event) {
        try {
            AnchorPane studentMgmt = FXMLLoader.load(getClass().getResource(("/sms/view/fxml/ManageStudents.fxml")));
            manageStudents.getChildren().setAll(studentMgmt);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    @FXML
    void btnPrintStudents(ActionEvent event) {
        try {
            AnchorPane studentMgmt = FXMLLoader.load(getClass().getResource(("/sms/view/fxml/PrintStudents.fxml")));
            manageStudents.getChildren().setAll(studentMgmt);
        }catch(IOException e){
            System.out.println(e);
        }
    }
    @FXML
    void transfer(ActionEvent event) {
        try {
            AnchorPane studentMgmt = FXMLLoader.load(getClass().getResource(("/sms/view/fxml/TransferStudents.fxml")));
            manageStudents.getChildren().setAll(studentMgmt);
        }catch(IOException e){
            System.out.println(e);
        }
    }

}
