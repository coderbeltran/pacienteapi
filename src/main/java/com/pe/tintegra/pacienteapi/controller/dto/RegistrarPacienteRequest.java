package com.pe.tintegra.pacienteapi.controller.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public class RegistrarPacienteRequest {
    @Valid
    @NotNull(message = "paciente es obligatorio")
    public PacienteRequest paciente;
    public AcompananteRequest acompanante;
}
