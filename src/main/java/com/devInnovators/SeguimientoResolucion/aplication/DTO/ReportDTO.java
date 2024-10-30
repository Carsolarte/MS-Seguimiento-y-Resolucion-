package com.devInnovators.SeguimientoResolucion.aplication.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportDTO {

    private String id;
    private String description;
    private IssueDTO idIssue;
    private AdminUserDTO idAdminUser;
   

}
