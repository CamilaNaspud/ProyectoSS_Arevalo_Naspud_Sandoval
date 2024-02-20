package com.app.alumnos.models.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.alumnos.models.entity.Alumno;

public interface AlumnoRepository extends PagingAndSortingRepository<Alumno,Long> {

}
