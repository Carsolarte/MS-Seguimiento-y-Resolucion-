package com.devInnovators.SeguimientoResolucion.aplication.DTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;


import com.devInnovators.SeguimientoResolucion.domain.model.Priority;
import com.devInnovators.SeguimientoResolucion.domain.model.ResolutionTeam;
import com.devInnovators.SeguimientoResolucion.domain.model.StatusIssue;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueDTO {
    
    private String id;
    private String categoryIssue;
    private StatusIssue statusIssue;
    private Priority priority;
    private List<ReportDTO> reportList;  // Lista de IDs de los reportes asociados
    private String adminc;
    private ResolutionTeam resolutionTeam;
}
