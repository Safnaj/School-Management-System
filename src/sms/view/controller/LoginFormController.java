package sms.view.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import sms.dbController.LoginController;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @author Safnaj on 8/12/2018
 * @project School Management System
 **/

public class LoginFormController implements Initializable {


    @FXML
    private AnchorPane login;

    @FXML
    private JFXTextField usernameField;

    @FXML
    private JFXPasswordField pwdField;

    @FXML
    private JFXButton Login;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    LoginController log = new LoginController();

    @FXML
    public void Login() {

        String username = usernameField.getText();
        String password = pwdField.getText();

        if(username.isEmpty() || password.isEmpty()){

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Login");
            alert.setHeaderText(null);
            alert.setContentText("Username & Password Required..!");
            alert.showAndWait();
        }
        else {

            if(username.startsWith("admin")){

                try {
                    if (log.Login(username, password)){

                        AnchorPane user = FXMLLoader.load(getClass().getResource(("/sms/view/fxml/MainDashboard.fxml")));
                        login.getChildren().setAll(user);

                    } else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Login");
                        alert.setHeaderText(null);
                        alert.setContentText("Invalid Username or Password..!");
                        alert.showAndWait();
                    }

                    } catch(SQLException e){
                        e.printStackTrace();
                    } catch(ClassNotFoundException e){
                        e.printStackTrace();
                    } catch(IOException e){
                        e.printStackTrace();
                    }

                }else if((username.startsWith("teacher"))) {

                try {
                    if (log.Login(username, password)){

                        AnchorPane user = FXMLLoader.load(getClass().getResource(("/sms/view/fxml/PrintStudents2.fxml")));
                        login.getChildren().setAll(user);

                    } else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Login");
                        alert.setHeaderText(null);
                        alert.setContentText("Invalid Username or Password..!");
                        alert.showAndWait();
                    }

                } catch(SQLException e){
                    e.printStackTrace();
                } catch(ClassNotFoundException e){
                    e.printStackTrace();
                } catch(IOException e){
                    e.printStackTrace();
                }
            }else {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Login");
                alert.setHeaderText(null);
                alert.setContentText("Invalid Username or Password..!");
                alert.showAndWait();

            }

            }

    }

}

