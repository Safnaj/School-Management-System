package sms.view.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Safnaj on 8/28/2018
 * @project School Management System
 **/
public class DashboardController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    private AnchorPane root;

    @FXML
    private ImageView ExamMgmt;

    @FXML
    private ImageView LibraryMgmt;

    @FXML
    private ImageView EventMgmt;

    @FXML
    private ImageView StudentMgmt;

    @FXML
    private JFXButton btnStudentMgmt;

    @FXML
    private JFXButton btnExamMgmt;

    @FXML
    private JFXButton btnLibraryMgmt;

    @FXML
    private JFXButton btnEventMgmt;

    @FXML
    private JFXButton btnUserSettings;

    @FXML
    private TextField username;

    @FXML
    void btnEventMgmt(ActionEvent event) {

    }

    @FXML
    void btnExamMgmt(ActionEvent event) {

    }

    @FXML
    void btnLibraryMgmt(ActionEvent event) {

    }

    @FXML
    void btnStudentMgmt(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/sms/view/fxml/StudentManagement.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Student Management");
        stage.setScene(new Scene(root));
        stage.show();

    }

    @FXML
    void setBtnUserSettings(ActionEvent event) {

    }

}
