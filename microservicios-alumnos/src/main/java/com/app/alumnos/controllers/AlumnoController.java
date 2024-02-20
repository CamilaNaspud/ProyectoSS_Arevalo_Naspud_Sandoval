package com.app.alumnos.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.alumnos.models.entity.Alumno;
import com.app.alumnos.models.services.AlumnoService;

@RestController
public class AlumnoController {

    @Autowired
    private AlumnoService service;

    @GetMapping("/pagina")
    public ResponseEntity<Page<Alumno>> listar(Pageable pageable) {
        Page<Alumno> alumnos = service.findAll(pageable);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Value");
        return ResponseEntity.ok().headers(headers).body(alumnos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> ver(@PathVariable Long id) {
        Optional<Alumno> o = service.findById(id);
        if (!o.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Value");
        return ResponseEntity.ok().headers(headers).body(o.get());
    }

    @PostMapping
    @Secured("ROLE_ADMIN") // Solo los usuarios con el rol "ADMIN" pueden acceder a este método
    public ResponseEntity<?> crear(@Valid @RequestBody Alumno alumno, BindingResult result) {

        if (result.hasErrors()) {
            return this.validar(result);
        }
        Alumno alumnoDb = service.save(alumno);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Value");
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(alumnoDb);
    }

    protected ResponseEntity<?> validar(BindingResult resultado) {
        Map<String, Object> errores = new HashMap<>();
        resultado.getFieldErrors().forEach(err -> {
            errores.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Value");
        return ResponseEntity.badRequest().headers(headers).body(errores);
    }
}
