package sms.tableModel;

/**
 * @author Safnaj on 11/10/2018
 * @project School Management System
 **/
public class UserTableModel {

    String username;
    String password;

    public UserTableModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserTableModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
