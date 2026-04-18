package com.cibertec.examenT2.Repository;

import com.cibertec.examenT2.Entity.Boleto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoletoRepository extends JpaRepository<Boleto, Integer> {
    // JpaRepository ya incluye los métodos findAll(), findById(), save() y deleteById()
}