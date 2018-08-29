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

   /* public ArrayList<String> getGrades(String className)throws SQLException, ClassNotFoundException{

        ArrayList<String> grades = new ArrayList<>();
        String SQL="Select grade From grades";
        java.sql.Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = (PreparedStatement) conn.prepareStatement(SQL);
        stm.setObject(1, className);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){

            grades.add(rst.getString(1));
        }
        return grades;
    }*/

    public static ArrayList<Grade> getGrades() throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery("Select grade From grades");
        ArrayList<Grade>gradeList=new ArrayList<>();
        while(rst.next()){
            Grade grade;
            grade = new Grade(rst.getString(2));
            gradeList.add(grade);
        }
        return gradeList;
    }

}
