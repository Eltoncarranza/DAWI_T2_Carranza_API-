package com.cibertec.examenT2.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 8, unique = true)
    private String dni;

    // Relación inversa (opcional para el listado si se requiere bidireccionalidad)
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Boleto> boletos;
}