/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

import com.mycompany.helper.XFile;
import java.io.File;
import java.util.ArrayList;
import javax.naming.Context;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ducli
 */
public class EmployeeList {
    public ArrayList<Employee> list = new ArrayList<>();
    private String path = "C:\\Users\\ducli\\Documents\\NetBeansProjects\\employeeManager\\Employee.dat";
    public void saveToFile() throws Exception{
        XFile.writeObject(path, list);  
        
    }
    
    
    public void loadFromFile() throws Exception{
        File file = new File(path);
        
        if(file.exists()){
            list = (ArrayList<Employee>) XFile.readObject(path);
        }else{
            initEmployeeData();
        }
        
    }
    
     private void initEmployeeData(){
        list.add(new Employee("1","Linh","linh@gmail.com",5000, 20));
        list.add(new Employee("2","Nguyen","nguyen@gmail.com",6000, 19));
        list.add(new Employee("3","Lam","lam@gmail.com",7000, 22));
        

    }
    
    private int currentIndex = 0;
    
    public String getCurrentEmployeeInfo(){
        return "Record" +" "+ (currentIndex +1) +" "+ "of" +" "+ list.size();
    }
    
    public void setCurrentEmployee(Employee emp){
        currentIndex = list.indexOf(emp);
    }
    
    public void first(){
        if(currentIndex >0){
            currentIndex = 0;
        }
    }
    public void previous(){
       if(currentIndex >0){
            currentIndex--;
        } 
    }
    public void next(){
        if(currentIndex < list.size() -1){
            currentIndex++;
        }
    }
    public void last(){
        if(currentIndex < list.size() -1){
            currentIndex = list.size() -1;
        }
    }
    public int getCurrentEmployeeIndex(){
        return currentIndex;
    }
    public Employee getCurrentEmployee(){
        if(list.size()==0)
            return null;
        return list.get(currentIndex);
    }
    
    public void add(Employee emp){
        list.add(emp);
    }
    
    public boolean update(Employee emp){
        Employee existedEmp = findByID(emp.getEmployeeID());
        boolean flag = false;
        if(existedEmp != null){
            existedEmp.setName(emp.getName());
            existedEmp.setAge(emp.getAge());
            existedEmp.setEmail(emp.getEmail());
            existedEmp.setSalary(emp.getSalary());
            
            return true;
        }
        return flag;
    }
    
    public void renderToTable(DefaultTableModel tblModel){
        tblModel.setRowCount(0);
        
        for(Employee employee : list){
            Object[] row = new Object[]{
                employee.getEmployeeID(), employee.getName(),
                employee.getAge(), employee.getEmail(), employee.getSalary()
            };
            tblModel.addRow(row);
        }
        tblModel.fireTableDataChanged();
    }
    
    public Employee findByID(String employeeId){
        for(Employee employee : list){
            if(employee.getEmployeeID().equals(employeeId)){
                return employee;
            }  
        }
        return null;
    }
    public Employee findByName(String employeeName){
        for(Employee employee : list){
            if(employee.getName().equals(employeeName)){
                return employee;
            }  
        }
        return null;
    }
    
    public boolean deleteById(String employeeId){
        for(Employee employee : list){
            if(employee.getEmployeeID().equals(employeeId)){
                list.remove(employee);
                return true;
            } 
        }
        return false;
    }
    
}
