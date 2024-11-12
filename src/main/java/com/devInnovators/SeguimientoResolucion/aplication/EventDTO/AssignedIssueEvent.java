package com.devInnovators.SeguimientoResolucion.aplication.EventDTO;

import com.devInnovators.SeguimientoResolucion.domain.model.CategoryIssue;
import com.devInnovators.SeguimientoResolucion.domain.model.Priority;
import com.devInnovators.SeguimientoResolucion.domain.model.ResolutionTeam;

import com.devInnovators.SeguimientoResolucion.domain.model.StatusIssue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignedIssueEvent implements Serializable {

    private String issueId;            // ID del problema
    private CategoryIssue category;    // Categoría del problema
    private StatusIssue status;        // Estado del problema
    private Priority priority;         // Prioridad del problema
    private ResolutionTeam resolutionTeam; // Equipo de resolución asignado
    private String idAdminc;
}