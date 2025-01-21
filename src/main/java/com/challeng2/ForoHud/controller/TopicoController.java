package com.challeng2.ForoHud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challeng2.ForoHud.domain.topico.TopicDTO;
import com.challeng2.ForoHud.domain.topico.Topico;
import com.challeng2.ForoHud.domain.topico.TopicoService;
import com.challeng2.ForoHud.domain.usuario.Usuario;

@RestController
@RequestMapping("/api/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    // Listar todos los tópicos
    @GetMapping
    public ResponseEntity<List<Topico>> listarTopicos() {
        return ResponseEntity.ok(topicoService.listarTopicos());
    }

    // Registrar un nuevo tópico
    @PostMapping
    // public ResponseEntity<Topico> registrarTopico(@RequestBody Topico topico, Authentication authentication) {
    public ResponseEntity<Topico> registrarTopico(@RequestBody TopicDTO topicDTO){
        //Usuario usuario = (Usuario) authentication.getPrincipal();
        // return ResponseEntity.ok(topicoService.registrarTopico(topico, usuario));
        Topico topico = topicoService.registrarTopico(topicDTO);
        return ResponseEntity.ok(topico);
    }

    // Actualizar un tópico existente
    @PutMapping("/{id}")
    // public ResponseEntity<Topico> actualizarTopico(@PathVariable Long id, @RequestBody Topico topico, Authentication authentication) {
    //     Usuario usuario = (Usuario) authentication.getPrincipal();
    //     return ResponseEntity.ok(topicoService.actualizarTopico(id, topico, usuario));
    // }
    public ResponseEntity<Topico> actualizarTopico(@PathVariable Long id, @RequestBody Topico topico) {
        return ResponseEntity.ok(topicoService.actualizarTopico(id, topico));
    }

    // Eliminar un tópico
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id){
    // public ResponseEntity<Void> eliminarTopico(@PathVariable Long id, Authentication authentication) {
        //Usuario usuario = (Usuario) authentication.getPrincipal();
        //topicoService.eliminarTopico(id, usuario);
        topicoService.eliminarTopico(id);
        return ResponseEntity.noContent().build();
    }
}