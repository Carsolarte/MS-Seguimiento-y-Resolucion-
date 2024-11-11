package com.devInnovators.SeguimientoResolucion.aplication.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.devInnovators.SeguimientoResolucion.domain.model.CategoryIssue;
import com.devInnovators.SeguimientoResolucion.domain.model.Coordinates;
import com.devInnovators.SeguimientoResolucion.domain.model.Status;




@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportDTO {

    private String idReport;
    private String description;
    private String idCitizen;                // ID de Citizen
    private String idissue;                  // ID de Issue
    private String idAdminC;  
    private List<CommentDTO> comment = new ArrayList<>();           // Lista de IDs de los comentarios
    private Status status;
    private CategoryIssue categoryIssue;
    private Coordinates coordinates;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private String fotoUrl;
    private Long numLikes;
    private Long numDislikes;
}
