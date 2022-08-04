/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.helper;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;

/**
 *
 * @author ducli
 */
public class Validator {

    public static boolean checkEmpty(JTextField field, StringBuilder sb, String msg) {
        boolean ok = true;
        if (field.getText().equals("")) {
            sb.append(msg).append("\n");
            field.setBackground(Color.red);
            ok = false;
        } else {
            field.setBackground(Color.white);
        }
        return ok;
    }

    public static boolean checkAge(JTextField field, StringBuilder sb) {
        boolean ok = true;

        if (!checkEmpty(field, sb, "Age is not define")) {
            return false;
        }
        try {
            int age = Integer.parseInt(field.getText());
            if (age < 18) {
                sb.append("Invalid age(18-55)\n");
                field.setBackground(Color.red);
                ok = false;
            }
        } catch (Exception e) {
            sb.append("Invalid age(default number)\n");
            field.setBackground(Color.red);
            ok = false;
        }
        if (ok) {
            field.setBackground(Color.white);
        }
        return ok;
    }

    public static boolean checkSalary(JTextField field, StringBuilder sb) {
        boolean ok = true;

        if (!checkEmpty(field, sb, "Salary is not define")) {
            return false;
        }
        try {
            double salary = Double.parseDouble(field.getText());
            if (salary < 1000) {
                sb.append("Invalid salary(smallest 1000)\n");
                field.setBackground(Color.red);
                ok = false;
            }
        } catch (Exception e) {
            sb.append("Invalid salary(default number)\n");
            field.setBackground(Color.red);
            ok = false;
        }
        if (ok) {
            field.setBackground(Color.white);
        }
        return ok;
    }

    public static boolean checkEmail(JTextField field, StringBuilder sb) {
        boolean ok = true;

        if (!checkEmpty(field, sb, "Email is not define")) {
            return false;
        }

        Pattern pattern = Pattern.compile("\\w+@\\w+\\.\\w+");
        Matcher matcher = pattern.matcher(field.getText());

        if (!matcher.find()) {
            sb.append("Invalid salary \n");
            field.setBackground(Color.red);
            ok = false;
        }

        if (ok) {
            field.setBackground(Color.white);
        }
        return ok;
    }
}
