package com.devInnovators.SeguimientoResolucion.aplication.DTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import com.devInnovators.SeguimientoResolucion.domain.model.AdminUser;
import com.devInnovators.SeguimientoResolucion.domain.model.CategoryIssue;
import com.devInnovators.SeguimientoResolucion.domain.model.Priority;
import com.devInnovators.SeguimientoResolucion.domain.model.ResolutionTeam;
import com.devInnovators.SeguimientoResolucion.domain.model.StatusIssue;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueDTO {
    private String id;
    private StatusIssue statusIssue;
    private CategoryIssue category;
    private Priority priority;
    private List<String> reports; 
    private AdminUser idAdminUser;
    private ResolutionTeam resolutionTeam;
}