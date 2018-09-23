package sms.view.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sms.tableModel.StudentTableModel;
import sms.db.DBConnection;
import sms.dbController.GradeController;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * @author Safnaj on 8/29/2018
 * @project School Management System
 **/
public class PrintStudentController implements Initializable {


    @FXML
    private TableView<StudentTableModel> studentTable;

    @FXML
    private TableColumn<StudentTableModel, String> adNoColumn;

    @FXML
    private TableColumn<StudentTableModel, String> fullNameColumn;

    @FXML
    private TableColumn<StudentTableModel, String> nameColumn;

    @FXML
    private TableColumn<StudentTableModel, String> dobColumn;

    @FXML
    private TableColumn<StudentTableModel, String> doaColumn;

    @FXML
    private TableColumn<StudentTableModel, String> genderColumn;

    @FXML
    private TableColumn<StudentTableModel, String> gradeColumn;

    @FXML
    private TableColumn<StudentTableModel, String> parentNameColumn;

    @FXML
    private TableColumn<StudentTableModel, String> nicColumn;

    @FXML
    private TableColumn<StudentTableModel, String> contactNoColumn;

    @FXML
    private TableColumn<StudentTableModel, String> addressColumn;

    @FXML
    private ComboBox<String> loadGrades;

    @FXML
    private ComboBox<String> loadYears;

    @FXML
    private ComboBox<String> loadGender;

    @FXML
    private JFXButton generate;

    @FXML
    private JFXButton printStudents;

    @FXML
    private JFXCheckBox adNoCheckBox;

    @FXML
    private JFXCheckBox fullNameCheckBox;

    @FXML
    private JFXCheckBox nameCheckBox;

    @FXML
    private JFXCheckBox dobCheckBox;

    @FXML
    private JFXCheckBox doaCheckBox;

    @FXML
    private JFXCheckBox genderCheckBox;

    @FXML
    private JFXCheckBox parentCheckBox;

    @FXML
    private JFXCheckBox nicCheckBox;

    @FXML
    private JFXCheckBox contactCheckBox;

    @FXML
    private JFXCheckBox addressCheckBox;



    ObservableList<StudentTableModel> studentList = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadGrades();
        loadYears();
        loadGender.getItems().addAll("All", "Male", "Female");

    }

    @FXML
    void loadGender(ActionEvent event) {

    }

    @FXML
    void loadGrades() {
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


    @FXML
    void loadYears() {
        ArrayList arrayList = null;
        try {
            arrayList = GradeController.getYears();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        ObservableList observableArray = FXCollections.observableArrayList();
        observableArray.addAll(arrayList);

        if (observableArray != null) {
            loadYears.setItems(observableArray);
        }
    }

    @FXML
    void generate(ActionEvent event) {

        try {
            studentTable.getItems().clear();
            String grade = loadGrades.getValue();
            String gender = loadGender.getValue();
            String year = loadYears.getValue();
            //Below Code for Assigning Values from CheckBox values
            String adNo = adNoCheckBox.getText();
            String fullName = fullNameCheckBox.getText();
            String name = nameCheckBox.getText();
            String dob = dobCheckBox.getText();
            String doa = doaCheckBox.getText();
            String gen = genderCheckBox.getText();
            String parent = parentCheckBox.getText();
            String nic = nicCheckBox.getText();
            String contact = contactCheckBox.getText();
            String address = addressCheckBox.getText();



            Connection conn = DBConnection.getDBConnection().getConnection();

            if(adNoCheckBox.isSelected() || fullNameCheckBox.isSelected() || nameCheckBox.isSelected() || dobCheckBox.isSelected() || doaCheckBox.isSelected() ||
               genderCheckBox.isSelected() || parentCheckBox.isSelected() || nicCheckBox.isSelected() || contactCheckBox.isSelected() || addressCheckBox.isSelected()) {

                if (loadYears == null) {

                    if (gender == "All") {

                        //String sql = "select * from students where grade = '" + grade + "'";
                        String sql = "select '"+adNo+"','"+fullName+"','"+name+"','"+dob+"','"+doa+"','"+gen+"','"+parent+"',grade , '"+nic+"','"+contact+"','"+address+"' from students where grade = '" + grade + "'";
                        ResultSet rs = conn.createStatement().executeQuery(sql);

                        while (rs.next()) {
                            StudentTableModel s = new StudentTableModel(rs.getInt("adNo"), rs.getString("fullName"), rs.getString("name"),
                                    rs.getString("dob"), rs.getString("doa"), rs.getString("gender"), rs.getString("grade"), rs.getString("parentName"),
                                    rs.getString("nic"), rs.getString("phone"), rs.getString("address"));
                            studentList.add(s);
                        }
                    } else {
                        String sql2 = "select * from students where grade = '" + grade + "' AND gender = '" + gender + "'";
                        ResultSet rs = conn.createStatement().executeQuery(sql2);

                        while (rs.next()) {
                            StudentTableModel s = new StudentTableModel(rs.getInt("adNo"), rs.getString("fullName"), rs.getString("name"),
                                    rs.getString("dob"), rs.getString("doa"), rs.getString("gender"), rs.getString("grade"), rs.getString("parentName"),
                                    rs.getString("nic"), rs.getString("phone"), rs.getString("address"));
                            studentList.add(s);
                        }
                    }
                } else {

                    if (gender == "All") {
                        String sql = "select * from paststudents where year = '" + year + "'";
                        ResultSet rs = conn.createStatement().executeQuery(sql);

                        while (rs.next()) {
                            StudentTableModel s = new StudentTableModel(rs.getInt("adNo"), rs.getString("fullName"), rs.getString("name"),
                                    rs.getString("dob"), rs.getString("doa"), rs.getString("gender"), rs.getString("year"), rs.getString("parentName"),
                                    rs.getString("nic"), rs.getString("phone"), rs.getString("address"));
                            studentList.add(s);
                        }
                    } else {
                        String sql2 = "select * from paststudents where year = '" + year + "' AND gender = '" + gender + "'";
                        ResultSet rs = conn.createStatement().executeQuery(sql2);

                        while (rs.next()) {
                            StudentTableModel s = new StudentTableModel(rs.getInt("adNo"), rs.getString("fullName"), rs.getString("name"),
                                    rs.getString("dob"), rs.getString("doa"), rs.getString("gender"), rs.getString("year"), rs.getString("parentName"),
                                    rs.getString("nic"), rs.getString("phone"), rs.getString("address"));
                            studentList.add(s);
                        }
                    }
                }
            }
            adNoColumn.setCellValueFactory(new PropertyValueFactory<>("adNo"));
            fullNameColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            dobColumn.setCellValueFactory(new PropertyValueFactory<>("dob"));
            doaColumn.setCellValueFactory(new PropertyValueFactory<>("doa"));
            genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
            gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));
            parentNameColumn.setCellValueFactory(new PropertyValueFactory<>("parentName"));
            nicColumn.setCellValueFactory(new PropertyValueFactory<>("nic"));
            contactNoColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
            addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));

            studentTable.setItems(studentList);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    @FXML
    void printStudents(ActionEvent event) {

    }

}
