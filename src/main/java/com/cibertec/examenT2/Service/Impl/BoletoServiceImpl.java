package com.cibertec.examenT2.Service.Impl;

import com.cibertec.examenT2.Dto.BoletoDto;
import com.cibertec.examenT2.Dto.BoletoMapper;
import com.cibertec.examenT2.Entity.Boleto;
import com.cibertec.examenT2.Entity.Cliente;
import com.cibertec.examenT2.Repository.BoletoRepository;
import com.cibertec.examenT2.Repository.ClienteRepository;
import com.cibertec.examenT2.Service.BoletoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class BoletoServiceImpl implements BoletoService {

    @Autowired private BoletoRepository repo;
    @Autowired private ClienteRepository clienteRepo;
    @Autowired private BoletoMapper mapper;

    @Override
    public List<BoletoDto> listarBoletos() {

        return repo.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BoletoDto obtenerBoleto(Integer id) {

        Boleto b = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Boleto no encontrado"));
        return mapper.toDTO(b);
    }

    @Override
    public void eliminarBoleto(Integer id) {

        if(!repo.existsById(id)) {
            throw new RuntimeException("No se puede eliminar: Boleto no existe");
        }
        repo.deleteById(id);
    }

    @Override
    public BoletoDto registrarBoleto(BoletoDto dto) {
        Boleto b = mapper.toEntity(dto);

        Cliente c = clienteRepo.findById(dto.getIdCliente())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        b.setCliente(c);
        return mapper.toDTO(repo.save(b));
    }

    @Override
    public BoletoDto actualizarBoleto(Integer id, BoletoDto dto) {

        Boleto b = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Boleto no encontrado"));


        b.setDestino(dto.getDestino());
        b.setPrecio(dto.getPrecio());

        Cliente c = clienteRepo.findById(dto.getIdCliente())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        b.setCliente(c);

        return mapper.toDTO(repo.save(b));
    }


}