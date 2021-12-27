package com.knoldus.learning.controller;

import com.knoldus.learning.entity.Employee;
import com.knoldus.learning.service.SaveEmployeeService;
import com.knoldus.learning.service.SaveEnployeeServiceImpl;
import com.knoldus.learning.service.ValidateEmployeeService;
import com.knoldus.learning.service.ValidateEmployeeServiceImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeController {

    public static void main(String[] a) {
        ValidateEmployeeService validateEmployeeService = new ValidateEmployeeServiceImpl();
        SaveEmployeeService saveEmployeeService = new SaveEnployeeServiceImpl();
        List<Employee> emplList = new ArrayList<>();

        //remove below for loop and
        // read data from employee.csv, csv have id, and name in each row.
        // focus on Functional Interface and mark them Functional if it is.

        // focus on Single responsibility principle.
        // -1,Jiten
        // 2,Ram
        File file = new File("employee.csv");

        String line;
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {

                String[] attributes = line.split(",");

                Employee employee = new Employee( Integer.parseInt(attributes[0]), attributes[1]);
                emplList.add(employee);
            }
            System.out.println("Total employee size  :  " + emplList.size() +"\n"+ emplList);
            //emplList iterate and call validate service, then save.
            for (Employee e : emplList) {
                if (validateEmployeeService.validateEmployee(e))
                    saveEmployeeService.saveEmployee(e);
            }
            //Remove this error.
            System.out.println("Saved employee  : " + saveEmployeeService.getEmployeeCount());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}