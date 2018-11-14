package sms.view.controller;

import com.jfoenix.controls.JFXButton;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Safnaj.MMA
 */
public class MainDashboardController implements Initializable{

        @Override
        public void initialize(URL location, ResourceBundle resources) {

        }
        @FXML
        private ImageView StudentMgmt;

        @FXML
        private JFXButton btnSchoolInfo;

        @FXML
        private JFXButton btnStudentMgmt;

        @FXML
        private JFXButton btnStaffMgmt;

        @FXML
        private JFXButton btnExamMgmt;

        @FXML
        private JFXButton btnLibraryMgmt;

        @FXML
        private JFXButton btnEventMgmt;

        @FXML
        private JFXButton btnInventory;

        @FXML
        private JFXButton btnNoticeMgmt;

        @FXML
        private JFXButton btnUserSettings;

//        @FXML
//        private TextField username;


        @FXML
        private AnchorPane root;

        @FXML
        void setBtnUserSettings(ActionEvent event) {

                try {
                        AnchorPane user = FXMLLoader.load(getClass().getResource(("/sms/view/fxml/UserAccount.fxml")));
                        root.getChildren().setAll(user);
                }catch(IOException e){
                        System.out.println(e);
                }

        }

        @FXML
        void setBtnSchoolInfo(ActionEvent event) {
                try {
                        AnchorPane user = FXMLLoader.load(getClass().getResource(("/sms/view/fxml/SchoolInfo.fxml")));
                        root.getChildren().setAll(user);
                }catch(IOException e){
                        System.out.println(e);
                }
        }

        @FXML
        void setBtnStudentMgmt(ActionEvent event) {

                try {
                        AnchorPane user = FXMLLoader.load(getClass().getResource(("/sms/view/fxml/StudentManagement.fxml")));
                        root.getChildren().setAll(user);
                }catch(IOException e){
                        System.out.println(e);
                }

                /*try {
                        Parent root = FXMLLoader.load(getClass().getResource("/sms/view/fxml/StudentManagement.fxml"));
                        Stage stage = new Stage();
                        stage.setTitle("Student Management");
                        stage.setScene(new Scene(root));
                        stage.getIcons().add(new Image(getClass().getResourceAsStream("/sms/other/img/HikmaLogo.jpg")));
                        stage.show();

                }catch(IOException e){
                        System.out.println(e);
                }*/
        }
        @FXML
        void btnStaffMgmt(ActionEvent event){

                try {
                        AnchorPane user = FXMLLoader.load(getClass().getResource(("/sms/view/fxml/StaffManagement.fxml")));
                        root.getChildren().setAll(user);
                }catch(IOException e){
                        System.out.println(e);
                }

                /*Parent root = null;
                try {
                        root = FXMLLoader.load(getClass().getResource("/sms/view/fxml/StaffManagement.fxml"));
                        Stage stage = new Stage();
                        stage.setTitle("School Information");
                        stage.setScene(new Scene(root));
                        stage.getIcons().add(new Image(getClass().getResourceAsStream("/sms/other/img/HikmaLogo.jpg")));
                        stage.show();

                } catch (IOException e) {
                        e.printStackTrace();
                }*/
        }

        @FXML
        void btnEventMgmt(ActionEvent event) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("School Management System");
                alert.setHeaderText(null);
                alert.setContentText("Sorry..! This feature currently Unavailable for this Version.");
                alert.showAndWait();
        }

        @FXML
        void btnExamMgmt(ActionEvent event) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("School Management System");
                alert.setHeaderText(null);
                alert.setContentText("Sorry..! This feature currently Unavailable for this Version.");
                alert.showAndWait();
        }

        @FXML
        void btnInventory(ActionEvent event) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("School Management System");
                alert.setHeaderText(null);
                alert.setContentText("Sorry..! This feature currently Unavailable for this Version.");
                alert.showAndWait();
        }

        @FXML
        void btnLibraryMgmt(ActionEvent event) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("School Management System");
                alert.setHeaderText(null);
                alert.setContentText("Sorry..! This feature currently Unavailable for this Version.");
                alert.showAndWait();
        }

        @FXML
        void btnNoticeMgmt(ActionEvent event) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("School Management System");
                alert.setHeaderText(null);
                alert.setContentText("Sorry..! This feature currently Unavailable for this Version.");
                alert.showAndWait();
        }

}

