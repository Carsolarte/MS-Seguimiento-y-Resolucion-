package com.devInnovators.SeguimientoResolucion.aplication.DTO;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {

    private String id;
    private String description;
    private String citizenId;
    private LocalDateTime createDate;
    private String reportId;

}
