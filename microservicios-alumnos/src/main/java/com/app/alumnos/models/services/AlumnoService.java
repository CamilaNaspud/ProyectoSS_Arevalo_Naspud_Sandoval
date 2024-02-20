package com.app.alumnos.models.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

import com.app.alumnos.models.entity.Alumno;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;

public interface AlumnoService {

    @Secured("ROLE_ADMIN") // Solo los usuarios con el rol "ADMIN" pueden acceder a este método
    Page<Alumno> findAll(Pageable pageable);

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')") // Usuarios con el rol "USER" o "ADMIN" pueden acceder a este método
    Optional<Alumno> findById(Long id);

    @PreAuthorize("hasRole('ADMIN')") // Solo los usuarios con el rol "ADMIN" pueden acceder a este método
    Alumno save(Alumno alumno);

    @PreAuthorize("hasRole('ADMIN')") // Solo los usuarios con el rol "ADMIN" pueden acceder a este método
    void deleteById(Long id);
}
