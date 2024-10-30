package com.devInnovators.SeguimientoResolucion.domain.model;


import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Issue {
    @Id
    String id;
    @Enumerated(EnumType.STRING)
    private StatusIssue statusIssue;
    @Enumerated(EnumType.STRING)
    private CategoryIssue category;
    @Enumerated(EnumType.STRING)
    private Priority priority;
    @ElementCollection
    private List<String> reports;

    @ManyToOne
    @JoinColumn(name = "admin_user_id")
    private AdminUser idAdminUser;
    @Enumerated(EnumType.STRING) 
    private ResolutionTeam resolutionTeam;

    // Método para actualizar el estado del Issue
    public void updateStatus(StatusIssue newStatus) {
        this.statusIssue = newStatus;
    }
}
