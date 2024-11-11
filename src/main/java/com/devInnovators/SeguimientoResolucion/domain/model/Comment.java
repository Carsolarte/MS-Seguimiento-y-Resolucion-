package com.devInnovators.SeguimientoResolucion.domain.model;

import jakarta.persistence.FetchType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    private String id;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)  // Asociación con Citizen
    @JoinColumn(name = "citizen_id")
    private Citizen citizenId;

    
    @ManyToOne  
    @JoinColumn(name = "report_id")
    private Report report;

    private LocalDateTime createDate;
}
