package com.devInnovators.SeguimientoResolucion.infra.Publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import org.springframework.stereotype.Component;

import com.devInnovators.SeguimientoResolucion.aplication.EventDTO.AssignedIssueEvent;
import com.devInnovators.SeguimientoResolucion.aplication.EventDTO.AssignedStatusEvent;


@Component
public class EventPublisher {

    // Inyectar el RabbitTemplate
    private final RabbitTemplate rabbitTemplate;

    public EventPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    // Publicar el evento IssueAssigned
    public void publishIssueAssigned(AssignedIssueEvent issueAssignedDTO) {
        rabbitTemplate.convertAndSend("reporte_exchange", "problema.asignado", issueAssignedDTO);
        System.out.println("Publicado evento ReporteRevisado: " + issueAssignedDTO);
    }

    // Publicar el evento StatusAssigned
    public void publishStatusAssigned(AssignedStatusEvent statusAssignedDTO) {
        rabbitTemplate.convertAndSend("reporte_exchange", "status.asignado", statusAssignedDTO);
        System.out.println("Publicado evento StatusAsignado: " + statusAssignedDTO);
    }

  
}