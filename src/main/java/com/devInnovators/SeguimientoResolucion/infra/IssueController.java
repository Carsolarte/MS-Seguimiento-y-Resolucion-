package com.devInnovators.SeguimientoResolucion.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import com.devInnovators.SeguimientoResolucion.aplication.DTO.IssueDTO;
import com.devInnovators.SeguimientoResolucion.domain.model.StatusIssue;
import com.devInnovators.SeguimientoResolucion.aplication.Services.IssueService;
import com.devInnovators.SeguimientoResolucion.domain.model.ResolutionTeam;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/issues")
public class IssueController {

    @Autowired
    private IssueService issueService;

    @PatchMapping("/{issueId}/assign")
    public ResponseEntity<Void> assignResolutionTeam(@PathVariable String issueId, @RequestBody ResolutionTeam resolutionTeam) {
        issueService.assignResolutionTeam(issueId, resolutionTeam);
        return ResponseEntity.ok().build();
    }
    @PatchMapping("/{issueId}/status")
    public ResponseEntity<Void> updateIssueStatus(@PathVariable String issueId, @RequestBody StatusIssue newStatus) {
        
        issueService.updateIssueStatus(issueId, newStatus);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{status}")
    public ResponseEntity<List<IssueDTO>> getIssuesByStatus(@PathVariable StatusIssue status) {
        List<IssueDTO> issues = issueService.getIssuesByStatus(status);
        return ResponseEntity.ok(issues);
    }

     @GetMapping
    public ResponseEntity<List<IssueDTO>> getAllIssues() {
        
        try {
            // Obtener la lista de issues desde el servicio
            List<IssueDTO> issues = issueService.getAllIssues();

            // Validar si la lista está vacía
            if (issues.isEmpty()) {
                // Si está vacía, retornar un 404 (No Content)
                return ResponseEntity.noContent().build();
            }

            // Si no está vacía, retornar un 200 (OK) con la lista de issues
            return ResponseEntity.ok(issues);
        } catch (Exception e) {
            // Si ocurre un error durante la ejecución, retornar un 500 (Internal Server Error)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .body(Collections.emptyList()); // Puedes retornar una lista vacía si lo deseas
        }
    }//este lo obtengo de el otro microservicio
}
