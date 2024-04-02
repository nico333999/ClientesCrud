package com.crud.app.ClientesCrud.Servicio;

import com.crud.app.ClientesCrud.Model.Estudiante;

import java.util.List;

public interface EstudianteServicio {
    public List<Estudiante> liststudents();
    public Estudiante guardarestudiante(Estudiante estudiante);
    public Estudiante buscarestudianteporid(Long id);
    public Estudiante actualizarestudiante(Estudiante estudiante);
    public void eliminarestudiante(Long id);
}
