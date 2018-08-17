package sms.view.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Safnaj on 8/12/2018
 * @project School Management System
 **/

public class loginController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    private AnchorPane login;

    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXButton btnLogin;

    @FXML
    private void btnLogin() {

    }
}
