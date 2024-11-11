package com.devInnovators.SeguimientoResolucion.aplication.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminCDTO {
    private String id;
    private String name;
    private List<ReportDTO> reports;
}