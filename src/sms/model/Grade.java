package sms.model;

/**
 * @author Safnaj on 8/29/2018
 * @project School Management System
 **/
public class Grade {

    private int gradeID;
    private String grade;
    private int noOfStudents;

    public Grade(String grade) {
        this.grade = grade;
    }

    public Grade(int graddeID, String grade, int noOfStudents) {
        this.gradeID = graddeID;
        this.grade = grade;
        this.noOfStudents = noOfStudents;
    }

    public int getGraddeID() {

        return gradeID;
    }

    public void setGraddeID(int graddeID)
    {
        this.gradeID = graddeID;
    }

    public String getGrade() {

        return grade;
    }

    public void setGrade(String grade)
    {
        this.grade = grade;
    }

    public int getNoOfStudents() {

        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents)
    {
        this.noOfStudents = noOfStudents;
    }
}
