package com.pe.tintegra.pacienteapi.controller;

import com.pe.tintegra.pacienteapi.controller.dto.RegistrarPacienteRequest;
import com.pe.tintegra.pacienteapi.service.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class PacienteController {

    private PacienteService pacienteService;
    private UbigeoService ubigeoService;

    private SexoService sexoService;

    private ParentescoService parentescoService;
    private TipoDocumentoService tipoDocumentoService;

    @GetMapping("/pacientes")
    public ResponseEntity<?> buscarPacientes(
            @RequestParam(required = false, defaultValue = "0") Integer tipoDocide,
            @RequestParam(required = false, defaultValue = "") String nombres,
            @RequestParam(required = false, defaultValue = "") String apellidos,
            @RequestParam(required = false, defaultValue = "") String doc) {

        return pacienteService.buscarPacientes(tipoDocide, nombres, apellidos, doc);

    }

    @GetMapping("/pacientes/{paciente}")
    public ResponseEntity<?> detallePacienteAcompanante(@PathVariable("paciente") Integer idPaciente) {

        return pacienteService.detallePacienteAcompanante(idPaciente);

    }

    @PostMapping("/pacientes")
    public ResponseEntity<?> registrar(
            @Valid @RequestBody RegistrarPacienteRequest request) {
        return pacienteService.registrarPaciente(request);
    }

    @DeleteMapping("/pacientes/{paciente}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable("paciente") Integer idPaciente) {

        return pacienteService.eliminarPaciente(idPaciente);

    }

    @PutMapping("/pacientes")
    public ResponseEntity<?> actualizarPaciente(
            @RequestBody RegistrarPacienteRequest request) {
        return pacienteService.actualizarPaciente(request);
    }

    @GetMapping("/ubigeo")
    public ResponseEntity<?> listarUbigeo() {

        return ubigeoService.listarUbigeo();

    }

    @GetMapping("/sexo")
    public ResponseEntity<?> listarSexo() {

        return sexoService.listarSexo();

    }


    @GetMapping("/parentesco")
    public ResponseEntity<?> listarParentesco() {
        return parentescoService.listarParentesco();
    }

    @GetMapping("/tipodocumento")
    public ResponseEntity<?> listarTipoDocumentoIdentidad() {
        return tipoDocumentoService.listarTipoDocumentoIdentidad();
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}

