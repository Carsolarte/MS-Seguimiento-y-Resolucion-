package com.devInnovators.SeguimientoResolucion.domain.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devInnovators.SeguimientoResolucion.domain.model.Issue;

import com.devInnovators.SeguimientoResolucion.domain.model.StatusIssue;

public interface IssueRepository extends JpaRepository<Issue, String> {
    List<Issue> findByStatusIssue(StatusIssue status);
    // List<Issue> findByCategory(CategoryIssue category); 
}
