package com.sb.sb_project.service;

import com.sb.sb_project.request.EmployeeRequest;
import com.sb.sb_project.response.EmployeResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AIService {

    private List<Employee> fetchEmployeeList(){
        return Stream.of(
                new Employee(1,"Pawan Barthunia",234567.90,"Male","Synechrone Banch","02-03-2023 12:00:00))","IC"),
                new Employee(2,"Varma",534567.90,"Male","TIAA","12-03-2010 12:00:00","Tech Lead"),
                new Employee(3,"Anish",1234567.90,"Male","TIAA","02-03-2023 12:00:00","Director"),
                new Employee(4,"Naga Raju ",137567.90,"Male","Synechrone Bench","02-03-2023 12:00:00","IC"),
                new Employee(5,"Narendera Bhosle",357264.89,"Male","TIAA PMO","10-03-2023 12:00:00","PM"),
                new Employee(6,"Vibha Rathode",42345.90,"Female","Synechrone HR","10-05-2018 12:00:00","HR"),
                new Employee(7,"Snehal Sharma",23567.90,"Female","CT Bank","01-06-2024 12:00:00","Trainee"),
                new Employee(8,"Vishal Bhosle",1234567.90,"Male","TIAA","10-03-2002 12:00:00","PM"),
                new Employee(9,"Neha Sharma",12234567.90,"Female","Amex Bank","03-10-2016 12:00:00","Tech Director"),
                new Employee(10,"Swati singh",23234567.90,"Female","TIAA","02-03-2000 12:00:00","VP"),
                new Employee(11,"Sneha Varma",34567.90,"Female","CT Bank","03-10-2019 12:00:00","IC")

        ).collect(Collectors.toUnmodifiableList());
    }
    public HashMap<String, Object> addEmployee(EmployeeRequest employeeRequest) {
        HashMap<String,Object> response=new HashMap<String,Object>();
        response.put("code",209);
        response.put("employeeList",fetchEmployeeList());
        response.put("status","success");
        return response;
    }

    public HashMap<String, Object> fetchEmployeeDetail() {
        HashMap<String,Object> response=new HashMap<>();
        List<String> numberOfDepartment=new ArrayList<>();
        List<Employee> employees=fetchEmployeeList();

        employees.stream().map(Employee::getClientName).distinct().forEach(emp->{
            numberOfDepartment.add(emp);
        });
        EmployeResponse responseOfEmployee=new EmployeResponse();
        responseOfEmployee.setCount(numberOfDepartment.size());
        responseOfEmployee.setPayload(numberOfDepartment);
        response.put("code",209);
        response.put("response",responseOfEmployee);
        response.put("status","success");
        Map<String,Long> numberOfSyneMaleFemale=employees.stream().filter(emp->emp.getClientName().equalsIgnoreCase("Synechrone"))
                .collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));

        response.put("code",209);
        response.put("response",numberOfSyneMaleFemale);
        response.put("status","success");
        return response;

    }
}
