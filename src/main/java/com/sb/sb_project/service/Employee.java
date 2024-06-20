package com.sb.sb_project.service;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {

    private Integer id;
    private String name;
    private Double salary;
    private String gender;
    private String clientName;
    private String doj;
    private String postion;


}
