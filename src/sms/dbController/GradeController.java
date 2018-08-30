package sms.dbController;

import com.mysql.jdbc.PreparedStatement;
import sms.db.DBConnection;
import sms.model.Grade;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 * @author Safnaj on 8/29/2018
 * @project School Management System
 **/
public class GradeController {

    public static ArrayList<Grade> getGrades() throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery("Select grade From grades");

        ArrayList<Grade>gradeList=new ArrayList<>();
        while(rst.next()){
            Grade grade;
            grade = new Grade(rst.getString("grade"));
            gradeList.add(grade);
        }
        return gradeList;
    }

}
