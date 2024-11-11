package com.devInnovators.SeguimientoResolucion.domain.model;

import jakarta.persistence.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import jakarta.persistence.Table;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "issue")
public class Issue {
    @Id
    String id;

    @Enumerated(EnumType.STRING)
    private CategoryIssue categoryIssue;
    @Enumerated(EnumType.STRING)
    private StatusIssue statusIssue;
   
    @Enumerated(EnumType.STRING)
    private Priority priority;
    
    @OneToMany(mappedBy = "issue", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Report> reportList;

    @ManyToOne(fetch = FetchType.LAZY)  // Asociación con adminc 
    @JoinColumn(name = "adminc_id")
    private AdminC adminc;
    @Enumerated(EnumType.STRING) 
    private ResolutionTeam resolutionTeam;

    // Método para actualizar el estado del Issue
    public void updateStatus(StatusIssue newStatus) {
        this.statusIssue = newStatus;
    }
}
