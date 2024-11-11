package com.devInnovators.SeguimientoResolucion.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable  // Permite que la clase sea parte de otra entidad como un objeto embebido.
public class Coordinates {

    @NotNull(message = "La latitud no puede ser nula")
    //@Min(value = -90, message = "La latitud mínima es -90")
    //@Max(value = 90, message = "La latitud máxima es 90")
    private double latitude;

    @NotNull(message = "La longitud no puede ser nula")
    //@Min(value = -180, message = "La longitud mínima es -180")
    //@Max(value = 180, message = "La longitud máxima es 180")
    private double longitude;
}
