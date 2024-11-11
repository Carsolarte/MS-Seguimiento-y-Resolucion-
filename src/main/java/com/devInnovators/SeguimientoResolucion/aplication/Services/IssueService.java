package com.devInnovators.SeguimientoResolucion.aplication.Services;


import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devInnovators.SeguimientoResolucion.aplication.DTO.CommentDTO;
import com.devInnovators.SeguimientoResolucion.aplication.DTO.IssueDTO;
import com.devInnovators.SeguimientoResolucion.aplication.DTO.ReportDTO;
import com.devInnovators.SeguimientoResolucion.aplication.Interfaces.IssueServiceInterface;
import com.devInnovators.SeguimientoResolucion.domain.Repository.IssueRepository;
import com.devInnovators.SeguimientoResolucion.domain.model.Comment;
import com.devInnovators.SeguimientoResolucion.domain.model.Issue;
import com.devInnovators.SeguimientoResolucion.domain.model.Report;
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
                .map(this::convertIssueToDTO)
                .collect(Collectors.toList());
    }
    @Override
    public List<IssueDTO> getAllIssues() {
        List<Issue> issues = issueRepository.findAll();
        System.out.printf("Found %d issues in the database%n", issues.size());  // Verifica el tamaño de la lista
    
        // Si la lista de issues está vacía o contiene problemas, imprime los datos
        if (issues.isEmpty()) {
            System.out.printf("No issues found in the database");
        }
    
        return issues.stream()
                     .map(this::convertIssueToDTO)
                     .collect(Collectors.toList());
    }
    private IssueDTO convertIssueToDTO(Issue issue) {
        IssueDTO dto = new IssueDTO();
        dto.setId(issue.getId());
        dto.setCategoryIssue(issue.getCategoryIssue().name());
        dto.setStatusIssue(issue.getStatusIssue());
        dto.setPriority(issue.getPriority());
            
        // Mapeo de la lista de ReportDTO si `Issue` tiene una lista de `Report` relacionados
        List<ReportDTO> reportDTOs = issue.getReportList().stream()
        .map(this::convertToReportDTO) // Método para convertir `Report` a `ReportDTO`
        .collect(Collectors.toList());
        dto.setReportList(reportDTOs);

        // Asignación de relaciones con objetos relacionados como `AdminC` y `ResolutionTeam`
        if (issue.getAdminc() != null) {
            dto.setAdminc(issue.getAdminc().getId()); // Asumiendo que `AdminC` tiene un método `getId()`
        }
        
        if (issue.getResolutionTeam() != null) {
            dto.setResolutionTeam(issue.getResolutionTeam()); // Asigna el objeto si `ResolutionTeam` es adecuado para `IssueDTO`
        }

        return dto;
        
       
    }
    private ReportDTO convertToReportDTO(Report report) {
        ReportDTO reportDTO = new ReportDTO();
    
        reportDTO.setIdReport(report.getIdReport());
        reportDTO.setDescription(report.getDescription());
        reportDTO.setIdCitizen(report.getCitizen().getId()); // Asumiendo que `Citizen` tiene un atributo `id`
        reportDTO.setIdissue(report.getIssue().getId()); // Asumiendo que `Issue` tiene un atributo `id`
        reportDTO.setIdAdminC(report.getAdminC().getId()); // Asumiendo que `AdminC` tiene un atributo `id`
        
        // Mapeo de comentarios si tienes una lista de comentarios asociados al reporte
        List<CommentDTO> commentDTOs = report.getComments().stream()
        .map(this::convertToDTO) // Método para convertir `Comment` a `CommentDTO`
        .collect(Collectors.toList());
        reportDTO.setComment(commentDTOs);
        reportDTO.setStatus(report.getStatus());
        reportDTO.setCategoryIssue(report.getCategoryIssue());
        reportDTO.setCoordinates(report.getCoordinates());
        reportDTO.setCreateDate(report.getCreateDate());
        reportDTO.setUpdateDate(report.getUpdateDate());
        reportDTO.setFotoUrl(report.getFotoUrl());
        reportDTO.setNumLikes(report.getNumLikes());
        reportDTO.setNumDislikes(report.getNumDislikes());
    
        return reportDTO;
    }

    private CommentDTO convertToDTO(Comment comment) {
        CommentDTO dto = new CommentDTO();
        dto.setId(comment.getId());
        dto.setDescription(comment.getDescription());
        dto.setCitizenId(comment.getCitizenId().getId());
        dto.setCreateDate(comment.getCreateDate());
        dto.setReportId(comment.getReport().getIdReport());
        return dto;
    }


}