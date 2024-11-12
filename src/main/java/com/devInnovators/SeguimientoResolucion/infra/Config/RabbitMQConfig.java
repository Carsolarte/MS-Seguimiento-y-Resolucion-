package com.devInnovators.SeguimientoResolucion.infra.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;

//colas y rutas de rabbitMQ

@Configuration  
public class RabbitMQConfig {

    //Canal de comunicación
    public static final String EXCHANGE_NAME = "reporte_exchange";

    public static final String QUEUE_PROBLEMA_CREADO = "problemaCreadoQueue";
    public static final String QUEUE_PROBLEMA_ASIGNADO = "problemaAsignadoQueue";
    public static final String QUEUE_PROBLEMA_STATUS = "problemaStatusQueue";

    public static final String ROUTING_KEY_PROBLEMA_CREADO = "problema.creado";
    public static final String ROUTING_KEY_PROBLEMA_ASIGNADO = "problema.asignado";
    public static final String ROUTING_KEY_PROBLEMA_PRIORIZADO = "problema.status";

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
    @Bean
    public Queue problemaCreadoQueue() {
        return new Queue(QUEUE_PROBLEMA_CREADO);
    }

    @Bean
    public Queue problemaAsignadoQueue() {
        return new Queue(QUEUE_PROBLEMA_ASIGNADO);
    }

    @Bean
    public Queue problemaPriorizadoQueue() {
        return new Queue(  QUEUE_PROBLEMA_STATUS);
    }

    @Bean
    public Binding problemaCreadoBinding(TopicExchange exchange) {
        return BindingBuilder.bind(problemaCreadoQueue()).to(exchange).with(ROUTING_KEY_PROBLEMA_CREADO);
    }

    @Bean
    public Binding problemaAsignadoBinding(TopicExchange exchange) {
        return BindingBuilder.bind(problemaAsignadoQueue()).to(exchange).with(ROUTING_KEY_PROBLEMA_ASIGNADO);
    }

    @Bean
    public Binding problemaPriorizadoBinding(TopicExchange exchange) {
        return BindingBuilder.bind(problemaPriorizadoQueue()).to(exchange).with(ROUTING_KEY_PROBLEMA_PRIORIZADO);
    }


  
}
