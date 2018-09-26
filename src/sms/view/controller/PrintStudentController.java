package sms.view.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import sms.main.StartProject;
import sms.tableModel.StudentTableModel;
import sms.db.DBConnection;
import sms.dbController.GradeController;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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

            Connection conn = DBConnection.getDBConnection().getConnection();

            // if((loadGrades != null)&&(loadGender != null)){

            if (gender == "All") {

                String sql = "select * from students where grade = '" + grade + "'";
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
                //    }
            }
            if (loadGrades != null) {

                // studentTable.getItems().clear();

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
           /* if(adNoCheckBox.isSelected()){
                adNoColumn.setCellValueFactory(new PropertyValueFactory<>("adNo"));
                gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));
                studentTable.setItems(studentList);

            }
            if(fullNameCheckBox.isSelected()){
                fullNameColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
                gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));
                studentTable.setItems(studentList);

            }if( nameCheckBox.isSelected()){
                nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
                gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));
                studentTable.setItems(studentList);

            }if(dobCheckBox.isSelected()){
                dobColumn.setCellValueFactory(new PropertyValueFactory<>("dob"));
                gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));
                studentTable.setItems(studentList);

            }if(doaCheckBox.isSelected()){
                doaColumn.setCellValueFactory(new PropertyValueFactory<>("doa"));
                gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));
                studentTable.setItems(studentList);

            }if(genderCheckBox.isSelected()){
                genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
                gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));
                studentTable.setItems(studentList);

            }if(parentCheckBox.isSelected()){
                parentNameColumn.setCellValueFactory(new PropertyValueFactory<>("parentName"));
                gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));
                studentTable.setItems(studentList);

            }if(nicCheckBox.isSelected()){
                nicColumn.setCellValueFactory(new PropertyValueFactory<>("nic"));
                gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));
                studentTable.setItems(studentList);

            }if(contactCheckBox.isSelected()){
                contactNoColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
                gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));
                studentTable.setItems(studentList);

            }if(addressCheckBox.isSelected()) {
                addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
                gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));
                studentTable.setItems(studentList);
            }*/

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

        try {
            studentTable.getItems().clear();
            String grade = loadGrades.getValue();
            String gender = loadGender.getValue();
            String year = loadYears.getValue();

//            Connection conn = DBConnection.getDBConnection().getConnection();
//            JasperDesign jd = JRXmlLoader.load("src\\sms\\Reports\\StudentList.jrxml");
//            JRDesignQuery query = new JRDesignQuery();


            if (gender == "All") {

                Connection conn = DBConnection.getDBConnection().getConnection();
                JasperDesign jd = JRXmlLoader.load("src\\sms\\Reports\\StudentList.jrxml");
                JRDesignQuery query = new JRDesignQuery();
                query.setText("select * from students where grade = '"+grade+"'");
                jd.setQuery(query);
                ReportViewController r = new ReportViewController();
                r.viewReport(jd);

              /*  //query.setText("select * from students");
                query.setText("select * from students where grade = '"+grade+"'");
                jd.setQuery(query);
                ReportViewController r = new ReportViewController();
                r.viewReport(jd);*/


            } else {
               /* query.setText("select * from students where grade = '" + grade + "' AND gender = '" + gender + "'");
                jd.setQuery(query);
                ReportViewController r = new ReportViewController();
                r.viewReport(jd);*/

            }
            if (loadGrades != null) {


                if (gender == "All") {
                    /*query.setText("select * from paststudents where year = '" + year + "'");
                    jd.setQuery(query);
                    ReportViewController r = new ReportViewController();
                    r.viewReport(jd);*/


                } else {
                    /*query.setText("select * from paststudents where year = '" + year + "' AND gender = '" + gender + "'");
                    jd.setQuery(query);
                    ReportViewController r = new ReportViewController();
                    r.viewReport(jd);*/

                }
            }
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JRException e) {
            e.printStackTrace();
        }

    }
}

