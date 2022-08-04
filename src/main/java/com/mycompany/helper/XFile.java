/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.helper;

import com.mycompany.model.Employee;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ducli
 */
public class XFile {

    public static Object readObject(String path) throws Exception {
        try (
                 FileInputStream fin = new FileInputStream(path);  ObjectInputStream ois = new ObjectInputStream(fin);) {
            Object obj = ois.readObject();

            return obj;
        }
    }

    public static void writeObject(String path, Object obj) throws Exception {
        try (
                FileOutputStream fos = new FileOutputStream(path);  
                ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(obj);

        }
    }
    
//    public void saveEmployee(ArrayList<Employee> list){
//        try(PrintWriter pw = new PrintWriter(new File("Employee.dat")) ) {
//            for(Employee emp : list){
//                pw.println(emp.getName());
//                pw.println(emp.getAge());
//                pw.println(emp.getEmail());
//                pw.println(emp.getSalary());
//            }
//        } catch (Exception e) {
//            System.out.println("Got an exception!");
//        }
//    }
//    public ArrayList readEmployee() throws FileNotFoundException{
//        ArrayList<Employee> list = new ArrayList<>();
//        try(Scanner sc = new Scanner(new File("Employee.dat"))) {
//            while(sc.hasNext()){
//                Employee emp = new Employee();
//                emp.setEmployeeID(sc.nextLine());
//                emp.setName(sc.nextLine());
//                emp.setAge(Integer.parseInt(sc.nextLine()));
//                emp.setEmail(sc.nextLine());
//                emp.setSalary(Integer.parseInt(sc.nextLine()));
//            }
//        } catch (Exception e) {
//        }
//    }
}
