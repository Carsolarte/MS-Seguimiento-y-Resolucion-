package com.devInnovators.SeguimientoResolucion.aplication.Interfaces;

import java.util.List;

import com.devInnovators.SeguimientoResolucion.aplication.DTO.IssueDTO;

import com.devInnovators.SeguimientoResolucion.domain.model.ResolutionTeam;
import com.devInnovators.SeguimientoResolucion.domain.model.StatusIssue;

public interface IssueServiceInterface {
   
    void assignResolutionTeam(String issueId, ResolutionTeam team);
    void updateIssueStatus(String issueId, StatusIssue status);
    List<IssueDTO> getIssuesByStatus(StatusIssue status);
    List<IssueDTO> getAllIssues();
 
    
}
