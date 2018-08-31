package sms.view.controller;

import javafx.scene.control.TextField;

/**
 * @author Safnaj on 9/1/2018
 * @project School Management System
 **/
public class ValidationController {

    public static void validateNIC(TextField txt) {
        if (txt.getText().matches("^(\\d{9}|\\d{12})[VvXx]$")) {
            //txt.setId(null);
        } else {
            //txt.setId("txtRed");
        }
    }
}
