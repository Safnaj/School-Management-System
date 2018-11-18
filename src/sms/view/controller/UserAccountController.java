package sms.view.controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Safnaj on 8/12/2018
 * @project School Management System
 **/

public class UserAccountController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private AnchorPane userAccount;

    @FXML
    private JFXButton btnLogout;

    @FXML
    private JFXButton ManageUsers;

    @FXML
    private JFXButton Back;

    @FXML
    private void Back() {
        try {
            AnchorPane studentMgmt = FXMLLoader.load(getClass().getResource(("/sms/view/fxml/MainDashboard.fxml")));
            userAccount.getChildren().setAll(studentMgmt);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    @FXML
    private void ManageUsers() {
        try {
            AnchorPane studentMgmt = FXMLLoader.load(getClass().getResource(("/sms/view/fxml/ManageUsers.fxml")));
            userAccount.getChildren().setAll(studentMgmt);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    @FXML
    private void btnLogout() {
        try {
            AnchorPane studentMgmt = FXMLLoader.load(getClass().getResource(("/sms/view/fxml/login.fxml")));
            userAccount.getChildren().setAll(studentMgmt);
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
