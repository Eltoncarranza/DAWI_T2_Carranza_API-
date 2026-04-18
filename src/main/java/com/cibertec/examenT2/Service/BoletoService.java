package com.cibertec.examenT2.Service;

import com.cibertec.examenT2.Dto.BoletoDto;
import java.util.List;

public interface BoletoService {
    List<BoletoDto> listarBoletos(); // El nombre debe ser exacto
    BoletoDto obtenerBoleto(Integer id);
    BoletoDto registrarBoleto(BoletoDto dto);
    BoletoDto actualizarBoleto(Integer id, BoletoDto dto);
    void eliminarBoleto(Integer id);
}