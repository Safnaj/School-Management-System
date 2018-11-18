package sms.view.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import sms.db.DBConnection;
import sms.tableModel.StaffTableModel;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * @author Safnaj on 11/6/2018
 * @project School Management System
 **/
public class PrintStaffsController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Type.getItems().addAll("Current Staffs", "Old Staffs");
    }
    @FXML
    private AnchorPane root;

    @FXML
    private ComboBox<String> Type;

    @FXML
    private JFXButton print;

    @FXML
    private JFXButton generate;

    @FXML
    private JFXButton Back;

    @FXML
    private TableView<StaffTableModel> staffTable;

    @FXML
    private TableColumn<StaffTableModel, String> EmpNoColumn;

    @FXML
    private TableColumn<StaffTableModel, String> NameColumn;

    @FXML
    private TableColumn<StaffTableModel, String> nicColumn;

    @FXML
    private TableColumn<StaffTableModel, String> dobColumn;

    @FXML
    private TableColumn<StaffTableModel, String> doaColumn;

    @FXML
    private TableColumn<StaffTableModel, String> genderColumn;

    @FXML
    private TableColumn<StaffTableModel, String> emailColumn;

    @FXML
    private TableColumn<StaffTableModel, String> assmpDutyColumn;

    @FXML
    private TableColumn<StaffTableModel, String> phoneColumn;

    @FXML
    private TableColumn<StaffTableModel, String> addressColumn;

    @FXML
    private TableColumn<StaffTableModel, String> incDateColumn;

    @FXML
    private TableColumn<StaffTableModel, String> gradeColumn;

    ObservableList<StaffTableModel> staffList = FXCollections.observableArrayList();

    @FXML
    void Back() {
        try {
            AnchorPane studentMgmt = FXMLLoader.load(getClass().getResource(("/sms/view/fxml/StaffManagement.fxml")));
            root.getChildren().setAll(studentMgmt);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    @FXML
    void Type(ActionEvent event) {

    }
    //Below code for On key press methods..

    /*@FXML
    void gen(KeyEvent event){
        generate.setOnKeyTyped((e)->{
            if (e.getCode() == KeyCode.G){
                generate();
            }
        });
    }*/

    @FXML
    void generate() {

        try{
            staffTable.getItems().clear();
            String type = Type.getValue();

            Connection conn = DBConnection.getDBConnection().getConnection();

            if (type == "Current Staffs") {

                String sql = "select * from staffs";
                ResultSet rs = conn.createStatement().executeQuery(sql);

                while (rs.next()) {

                    StaffTableModel staff = new StaffTableModel(rs.getInt("empNo"),rs.getString("teacherName"),rs.getString("nic"),
                            rs.getString("dob"),rs.getString("doa"),rs.getString("gender"),rs.getString("email"),rs.getString("assumpOfDuties"),
                            rs.getString("phone"),rs.getString("address"),rs.getString("incDate"),rs.getString("prsntGrade"));
                    staffList.add(staff);
                }
            }
            else {

                String sql2 = "select * from oldstaffs";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {

                    StaffTableModel staff = new StaffTableModel(rs.getInt("empNo"),rs.getString("teacherName"),rs.getString("nic"),
                            rs.getString("dob"),rs.getString("doa"),rs.getString("gender"),rs.getString("email"),rs.getString("assumpOfDuties"),
                            rs.getString("phone"),rs.getString("address"),rs.getString("incDate"),rs.getString("prsntGrade"));
                    staffList.add(staff);
                }
            }
            //Ctrl+D for copy above line
            EmpNoColumn.setCellValueFactory(new PropertyValueFactory<>("empNo"));
            NameColumn.setCellValueFactory(new PropertyValueFactory<>("teacherName"));
            nicColumn.setCellValueFactory(new PropertyValueFactory<>("nic"));
            dobColumn.setCellValueFactory(new PropertyValueFactory<>("dob"));
            doaColumn.setCellValueFactory(new PropertyValueFactory<>("doa"));
            emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
            genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
            assmpDutyColumn.setCellValueFactory(new PropertyValueFactory<>("assumpOfDuties"));
            phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
            addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
            incDateColumn.setCellValueFactory(new PropertyValueFactory<>("incDate"));
            gradeColumn.setCellValueFactory(new PropertyValueFactory<>("prsntGrade"));

            staffTable.setItems(staffList);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    @FXML
    void print(ActionEvent event) {

        staffTable.getItems().clear();
        String type = Type.getValue();

        try {
            Connection conn = DBConnection.getDBConnection().getConnection();

            InputStream report1 = getClass().getResourceAsStream("/sms/Reports/StaffList.jrxml");
            InputStream report2 = getClass().getResourceAsStream("/sms/Reports/StaffListPast.jrxml");

            JRDesignQuery query = new JRDesignQuery();

          /*  HashMap<String,Object> Logo = new HashMap<String, Object>();

            URL url = this.getClass().getClassLoader().getResource("sms/other/img/HikmaLogo.jpg");
            Logo.put("logo", url);*/

            if (type == "Current Staffs"){

                JasperDesign jd = JRXmlLoader.load(report1);
                query.setText("select * from staffs");
                jd.setQuery(query);
                ReportViewController r = new ReportViewController();
                r.viewReport(jd);
            }
            else {

                JasperDesign jd2 = JRXmlLoader.load(report2);
                query.setText("select * from oldstaffs");
                jd2.setQuery(query);
                ReportViewController r = new ReportViewController();
                r.viewReport(jd2);
            }
        } catch (JRException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
