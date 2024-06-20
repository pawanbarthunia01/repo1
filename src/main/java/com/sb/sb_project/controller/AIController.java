package com.sb.sb_project.controller;

import com.sb.sb_project.request.EmployeeRequest;
import com.sb.sb_project.service.AIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/v1")
public class AIController {
    @Autowired
    private AIService aiService;

    @PostMapping("/")
    public ResponseEntity<HashMap<String,Object>> addEmployee(@RequestBody EmployeeRequest employeeRequest){
        return new ResponseEntity<>(aiService.addEmployee(employeeRequest), HttpStatus.OK);
    }
}
