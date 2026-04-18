package com.cibertec.examenT2.Service.Impl;

import com.cibertec.examenT2.Dto.BoletoDto;
import com.cibertec.examenT2.Dto.BoletoMapper;
import com.cibertec.examenT2.Entity.Boleto;
import com.cibertec.examenT2.Repository.BoletoRepository;
import com.cibertec.examenT2.Service.BoletoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoletoServiceImpl implements BoletoService {

    @Autowired
    private BoletoRepository repo;
    @Autowired private BoletoMapper mapper;

    @Override
    public List<BoletoDto> listarBoletos() {
        return repo.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public BoletoDto     obtenerBoleto(Integer id) {
        Boleto b = repo.findById(id).orElseThrow(() -> new RuntimeException("No encontrado"));
        return mapper.toDTO(b);
    }

    @Override
    public BoletoDto registrarBoleto(BoletoDto dto) {
        Boleto b = mapper.toEntity(dto);
        // Aquí deberías asignar el cliente buscando por dto.getIdCliente()
        return mapper.toDTO(repo.save(b));
    }

    @Override
    public BoletoDto actualizarBoleto(Integer id, BoletoDto dto) {
        return null;
    }

    @Override
    public void eliminarBoleto(Integer id) { repo.deleteById(id); }
    // Implementar actualizarBoleto similar a registrar...
}