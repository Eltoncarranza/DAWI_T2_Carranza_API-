package com.cibertec.examenT2.Dto;

import com.cibertec.examenT2.Entity.Boleto;
import org.springframework.stereotype.Component;

@Component
public class BoletoMapper {
    public BoletoDto toDTO(Boleto entity) {
        BoletoDto dto = new BoletoDto();
        dto.setIdBoleto(entity.getIdBoleto());
        dto.setDestino(entity.getDestino());
        dto.setPrecio(entity.getPrecio());
        dto.setIdCliente(entity.getCliente().getIdCliente());
        return dto;
    }

    public Boleto toEntity(BoletoDto dto) {
        Boleto entity = new Boleto();
        entity.setIdBoleto(dto.getIdBoleto());
        entity.setDestino(dto.getDestino());
        entity.setPrecio(dto.getPrecio());
        return entity;
    }
}