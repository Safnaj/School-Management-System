package sms.view.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Safnaj on 11/11/2018
 * @project School Management System
 **/
public class UserAccount2Controller implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    private AnchorPane userAccount;

    @FXML
    private JFXButton btnLogout1;

    @FXML
    private JFXButton Back;

    @FXML
    void Back(ActionEvent event) {
        try {
            AnchorPane studentMgmt = FXMLLoader.load(getClass().getResource(("/sms/view/fxml/PrintStudents2.fxml")));
            userAccount.getChildren().setAll(studentMgmt);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    @FXML
    void btnLogout(ActionEvent event) {
        try {
            AnchorPane studentMgmt = FXMLLoader.load(getClass().getResource(("/sms/view/fxml/login.fxml")));
            userAccount.getChildren().setAll(studentMgmt);
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
