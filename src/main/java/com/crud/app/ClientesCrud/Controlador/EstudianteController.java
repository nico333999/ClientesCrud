package com.crud.app.ClientesCrud.Controlador;

import com.crud.app.ClientesCrud.Model.Estudiante;
import com.crud.app.ClientesCrud.Servicio.EstudianteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EstudianteController {
    @Autowired
    private EstudianteServicio estudianteServicioservicio;

    @GetMapping({"/estudiantes","/"})
    public String mostrarEstudiantes(Model model){
        model.addAttribute("estudiantes",estudianteServicioservicio.liststudents());
        return "estudiantes";
    }
    @GetMapping("/estudiantes/nuevo")
    public String mostrarFormulario(Model model){
        Estudiante estudiante=new Estudiante();
        model.addAttribute("estudiante",estudiante);
        return "crear_estudiante";
    }
    @PostMapping("/estudiantes")
    public String guardarestudiante(@ModelAttribute("estudiante") Estudiante estudiante) {
        estudianteServicioservicio.guardarestudiante(estudiante);
        return "redirect:/estudiantes";

    }
    @GetMapping("/estudiantes/editar/{id}")
    public String mostrarFormulariodeeditar(@PathVariable Long id, Model model){
      /*  Estudiante estudiante=new Estudiante();*/
        model.addAttribute("estudiante",estudianteServicioservicio.buscarestudianteporid(id));
        return "editar_estudiante";
    }
    @PostMapping("/estudiantes/{id}")
    public String actualizarestudiante(@PathVariable Long id,@ModelAttribute("estudiante") Estudiante estudiante){
        Estudiante estudianteexistente=estudianteServicioservicio.buscarestudianteporid(id);
        estudianteexistente.setId(id);
        estudianteexistente.setNombre(estudiante.getNombre());
        estudianteexistente.setApellido(estudiante.getApellido());
        estudianteexistente.setEmail(estudiante.getEmail());
        estudianteServicioservicio.actualizarestudiante(estudianteexistente);
        return "redirect:/estudiantes";
    }
    @GetMapping("/estudiantes/{id}")
    public String eliminarestudiante(@PathVariable Long id){
        estudianteServicioservicio.eliminarestudiante(id);
        return "redirect:/estudiantes";
    }

}
