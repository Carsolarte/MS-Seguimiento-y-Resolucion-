package com.devInnovators.SeguimientoResolucion.aplication.Services;


import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devInnovators.SeguimientoResolucion.aplication.DTO.IssueDTO;

import com.devInnovators.SeguimientoResolucion.aplication.Interfaces.IssueServiceInterface;
import com.devInnovators.SeguimientoResolucion.domain.Repository.IssueRepository;
import com.devInnovators.SeguimientoResolucion.domain.model.Issue;
import com.devInnovators.SeguimientoResolucion.domain.model.ResolutionTeam;
import com.devInnovators.SeguimientoResolucion.domain.model.StatusIssue;

import java.util.List;


@Service
public class IssueService implements IssueServiceInterface {


    @Autowired
    private IssueRepository issueRepository;


    @Override
    public void assignResolutionTeam(String issueId, ResolutionTeam resolutionTeam) {
        Issue issue = issueRepository.findById(issueId)
                .orElseThrow(() -> new RuntimeException("Issue not found with ID: " + issueId));
        issue.setResolutionTeam(resolutionTeam); // Asigna el equipo de resolución
        issueRepository.save(issue); // Guarda los cambios
    }

    @Override
    public void updateIssueStatus(String issueId, StatusIssue newStatus) {
        Issue issue = issueRepository.findById(issueId)
                .orElseThrow(() -> new RuntimeException("Issue not found with ID: " + issueId));
        issue.updateStatus(newStatus); // Actualiza el estado del issue
        issueRepository.save(issue); // Guarda los cambios
    }

    @Override
    public List<IssueDTO> getIssuesByStatus(StatusIssue status) {
        return issueRepository.findByStatusIssue(status).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    @Override
    public List<IssueDTO> getAllIssues() { // Implementa el método aquí
        return issueRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    private IssueDTO convertToDTO(Issue issue) {
        return new IssueDTO(issue.getId(), issue.getStatusIssue(), issue.getCategory(),
                issue.getPriority(), issue.getReports(), // Directamente usamos ReportDTO
                issue.getIdAdminUser(), issue.getResolutionTeam());
    }
     

}
    
