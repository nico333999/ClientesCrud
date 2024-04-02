package com.crud.app.ClientesCrud.Repositorio;

import com.crud.app.ClientesCrud.Model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepositorio extends JpaRepository<Estudiante,Long> {
}
