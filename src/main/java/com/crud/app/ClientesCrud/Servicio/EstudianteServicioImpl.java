package com.crud.app.ClientesCrud.Servicio;

import com.crud.app.ClientesCrud.Model.Estudiante;
import com.crud.app.ClientesCrud.Repositorio.EstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EstudianteServicioImpl implements EstudianteServicio{
    @Autowired
    private EstudianteRepositorio estudianterepositorio;
    @Override
    public List<Estudiante> liststudents() {
        return estudianterepositorio.findAll();
    }

    @Override
    public Estudiante guardarestudiante(Estudiante estudiante) {
        return estudianterepositorio.save(estudiante);
    }

    @Override
    public Estudiante buscarestudianteporid(Long id) {
        return estudianterepositorio.findById(id).get();
    }

    @Override
    public Estudiante actualizarestudiante(Estudiante estudiante) {
        return estudianterepositorio.save(estudiante);
    }

    @Override
    public void eliminarestudiante(Long id) {
        estudianterepositorio.deleteById(id);

    }
}
