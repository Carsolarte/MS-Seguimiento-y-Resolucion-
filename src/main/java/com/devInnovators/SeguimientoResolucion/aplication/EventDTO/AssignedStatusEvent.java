package com.devInnovators.SeguimientoResolucion.aplication.EventDTO;

import java.io.Serializable;

import com.devInnovators.SeguimientoResolucion.domain.model.StatusIssue;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class AssignedStatusEvent implements Serializable {

    private String id;            
    private StatusIssue statusIssue;       // Nueva prioridad asignada
    private String adminc;         
}
