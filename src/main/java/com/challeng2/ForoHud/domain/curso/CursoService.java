package com.challeng2.ForoHud.domain.curso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    // Listar todos los cursos
    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    // Registrar un nuevo curso
    public Curso registrarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    // Actualizar un curso existente
    public Curso actualizarCurso(Long id, Curso cursoActualizado) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
        curso.setNombre(cursoActualizado.getNombre());
        curso.setCategoria(cursoActualizado.getCategoria());
        return cursoRepository.save(curso);
    }

    // Eliminar un curso
    public void eliminarCurso(Long id) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
        cursoRepository.delete(curso);
    }
}