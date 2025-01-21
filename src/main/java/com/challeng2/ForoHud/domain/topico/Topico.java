package com.challeng2.ForoHud.domain.topico;

import java.time.LocalDateTime;
import java.util.List;

import com.challeng2.ForoHud.domain.curso.Curso;
import com.challeng2.ForoHud.domain.respuesta.Respuesta;
import com.challeng2.ForoHud.domain.usuario.Usuario;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "topicos")
@Getter
@Setter
@NoArgsConstructor
public class Topico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensaje;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion = LocalDateTime.now();
    // private LocalDateTime fechaCreacion;

    private String status;

    // @ManyToOne
    // @JoinColumn(name = "autor_id")
    // private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    // @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL)
    // private List<Respuesta> respuestas;
}
