package com.challeng2.ForoHud.domain.topico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challeng2.ForoHud.domain.curso.Curso;
import com.challeng2.ForoHud.domain.curso.CursoRepository;
import com.challeng2.ForoHud.domain.usuario.Usuario;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    // Listar todos los tópicos
    public List<Topico> listarTopicos() {
        return topicoRepository.findAll();
    }

    // Registrar un nuevo tópico
    public Topico registrarTopico( TopicDTO topicDTO ) {
        // Verificar si el curso existe
        Curso curso = cursoRepository.findById(topicDTO.cursoId())
            .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        // Crear el nuevo tópico
        Topico topico = new Topico();
        topico.setTitulo(topicDTO.titulo());
        topico.setMensaje(topicDTO.mensaje());
        topico.setStatus(topicDTO.status());
        topico.setCurso(curso);

        return topicoRepository.save(topico);
    }


    // Actualizar un tópico
    // public Topico actualizarTopico(Long id, Topico nuevoTopico, Usuario usuario) {
    public Topico actualizarTopico(Long id, Topico nuevoTopico) {

        Topico existente = topicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tópico no encontrado"));

        // if (!existente.getAutor().equals(usuario)) {
        //     throw new RuntimeException("No tienes permisos para actualizar este tópico");
        // }

        existente.setTitulo(nuevoTopico.getTitulo());
        existente.setMensaje(nuevoTopico.getMensaje());
        return topicoRepository.save(existente);
    }

    // Eliminar un tópico
    // public void eliminarTopico(Long id, Usuario usuario) {
    public void eliminarTopico(Long id) {

        Topico existente = topicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tópico no encontrado"));

        // if (!existente.getAutor().equals(usuario)) {
        //     throw new RuntimeException("No tienes permisos para eliminar este tópico");
        // }

        topicoRepository.delete(existente);
    }
}