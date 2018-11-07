package sms.tableModel;

/**
 * @author Safnaj on 11/3/2018
 * @project School Management System
 **/
public class StaffTableModel {

    int empNo;
    String teacherName;
    String nic;
    String dob;
    String doa;
    String gender;
    String email;
    String assumpOfDuties;
    String phone;
    String address;
    String incDate;
    String prsntGrade;

    public StaffTableModel(int empNo, String teacherName, String nic, String dob, String doa, String gender, String email, String assumpOfDuties, String phone, String address, String incDate, String prsntGrade) {
        this.empNo = empNo;
        this.teacherName = teacherName;
        this.nic = nic;
        this.dob = dob;
        this.doa = doa;
        this.gender = gender;
        this.email = email;
        this.assumpOfDuties = assumpOfDuties;
        this.phone = phone;
        this.address = address;
        this.incDate = incDate;
        this.prsntGrade = prsntGrade;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDoa() {
        return doa;
    }

    public void setDoa(String doa) {
        this.doa = doa;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAssumpOfDuties() {
        return assumpOfDuties;
    }

    public void setAssumpOfDuties(String assumpOfDuties) {
        this.assumpOfDuties = assumpOfDuties;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIncDate() {
        return incDate;
    }

    public void setIncDate(String incDate) {
        this.incDate = incDate;
    }

    public String getPrsntGrade() {
        return prsntGrade;
    }

    public void setPrsntGrade(String prsntGrade) {
        this.prsntGrade = prsntGrade;
    }
}
