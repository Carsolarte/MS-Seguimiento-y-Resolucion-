package com.devInnovators.SeguimientoResolucion.infra.Listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.devInnovators.SeguimientoResolucion.aplication.EventDTO.CreateIssueEvent;

import com.devInnovators.SeguimientoResolucion.aplication.Services.IssueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class EventListener {

    private static final Logger log = LoggerFactory.getLogger(EventListener.class);

    // Inyectar el servicio IssueService
    private final IssueService issueService;

    public EventListener(IssueService issueService) {
        this.issueService = issueService;
    }

    // Escuchar el evento ReporteRevisado
    @RabbitListener(queues = "problemaCreadoQueue")
    public void listenIssue(CreateIssueEvent issueDTO) {
        try {
            System.out.println("Recibido evento ReporteCreado: " + issueDTO);
            issueService.createIssue(issueDTO);
        } catch (Exception e) {
            // Manejo de errores, como loggear o capturar el evento para investigar
            log.error("Error procesando el evento CreateIssueEvent: ", e);
        }
       
    }
 

    
}