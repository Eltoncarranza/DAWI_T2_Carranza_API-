package com.cibertec.examenT2.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Boleto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBoleto;
    private String destino;
    private Double precio;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
}