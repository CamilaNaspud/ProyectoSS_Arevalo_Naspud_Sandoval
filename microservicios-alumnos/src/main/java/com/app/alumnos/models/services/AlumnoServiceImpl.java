package com.app.alumnos.models.services;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;

import com.app.alumnos.models.entity.Alumno;
import com.app.alumnos.models.repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    private AlumnoRepository repository;

    @Override
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')") // Usuarios con el rol "USER" o "ADMIN" pueden acceder a este método
    public Optional<Alumno> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')") // Solo los usuarios con el rol "ADMIN" pueden acceder a este método
    public Alumno save(Alumno alumno) {
        return repository.save(alumno);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')") // Solo los usuarios con el rol "ADMIN" pueden acceder a este método
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Secured("ROLE_ADMIN") // Solo los usuarios con el rol "ADMIN" pueden acceder a este método
    public Page<Alumno> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
