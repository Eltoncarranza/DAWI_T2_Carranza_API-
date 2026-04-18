package com.cibertec.examenT2.Controller;

import com.cibertec.examenT2.Dto.BoletoDto;
import com.cibertec.examenT2.Service.BoletoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boletos")
public class BoletoController {
    @Autowired
    private BoletoService service;

    @GetMapping
    public ResponseEntity<List<BoletoDto>> listar() { return ResponseEntity.ok(service.listarBoletos()); }

    @GetMapping("/{id}")
    public ResponseEntity<BoletoDto> obtener(@PathVariable Integer id) { return ResponseEntity.ok(service.obtenerBoleto(id)); }

    @PostMapping
    public ResponseEntity<BoletoDto> registrar(@RequestBody BoletoDto dto) { return ResponseEntity.status(201).body(service.registrarBoleto(dto)); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) { service.eliminarBoleto(id); return ResponseEntity.noContent().build(); }

    @PutMapping("/{id}")
    public ResponseEntity<BoletoDto> actualizar(@PathVariable Integer id, @RequestBody BoletoDto dto) {
        return ResponseEntity.ok(service.actualizarBoleto(id, dto));
    }
}
