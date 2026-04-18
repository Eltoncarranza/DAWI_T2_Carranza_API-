package com.cibertec.examenT2.Dto;

import lombok.Data;

@Data
public class BoletoDto {
    private Integer idBoleto;
    private String destino;
    private Double precio;
    private Integer idCliente;
}