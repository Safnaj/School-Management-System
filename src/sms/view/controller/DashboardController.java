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


public class DashboardController implements Initializable{

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
        private JFXButton btnUserMgmt;

        @FXML
        private AnchorPane root;

        @FXML
        void setBtnSchoolInfo(ActionEvent event) {
//                try {
//                        AnchorPane dashboard = FXMLLoader.load(getClass().getResource(("")));
//                        root.getChildren().setAll(dashboard);
//                }catch(IOException e){
//                        System.out.println(e);
//                }
        }

        @FXML
        void setBtnStudentMgmt(ActionEvent event) {
                try {
                        AnchorPane dashboard = FXMLLoader.load(getClass().getResource(("/sms/view/fxml/StudentManagement.fxml")));
                        root.getChildren().setAll(dashboard);
                }catch(IOException e){
                        System.out.println(e);
                }
        }

}

