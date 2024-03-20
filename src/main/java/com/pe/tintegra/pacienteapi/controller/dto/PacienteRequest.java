package com.pe.tintegra.pacienteapi.controller.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class PacienteRequest {

    private Integer idPaciente;
    @NotNull(message = "Tipo de documento. Es requerido")
    private Integer tipoDocumento;
    @NotBlank(message = "Numero de documento. Es requerido")
    private String documento;
    @NotBlank(message = "Apellido paterno. Es requerido")
    private String apellidoPat;
    @NotBlank(message = "Apellido materno. Es requerido")
    private String apellidoMat;
    @NotBlank(message = "nombre. Es requerido")
    private String nombres;
    @NotNull(message = "Sexo. Es requerido")
    private Integer idSexo;
    @NotNull(message = "Fecha de nacimiento. Es requerido")
    private LocalDate fechaNacimiento;
    @NotBlank(message = "Lugar de nacimiento. Es requerido")
    private String lugarNacimiento;
    @NotBlank(message = "Direccion. Es requerido")
    private String direccion;
    @NotBlank(message = "Ubigeo. Es requerido")
    private String ubigeo;
}
