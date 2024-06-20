package com.sb.sb_project.response;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeResponse {

    private Integer count;
    private Object payload;
}
