package com.example.demo.service;

import com.example.demo.entity.TipoCambio;
import com.example.demo.repository.TipoCambioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TipoCambioService {
    @Autowired
    private TipoCambioRepository repository;

    public BigDecimal calcularCambio(String origen, String destino, BigDecimal monto) {
        TipoCambio tipoCambio = repository.findByMonedaOrigenAndMonedaDestino(origen, destino);
        if (tipoCambio == null) throw new RuntimeException("Tipo de cambio no encontrado");
        return monto.multiply(tipoCambio.getTipoCambio());
    }

    public TipoCambio guardarTipoCambio(TipoCambio tipoCambio) {
        return repository.save(tipoCambio);
    }

    public TipoCambio actualizarTipoCambio(Long id, TipoCambio tipoCambio) {
        TipoCambio existente = repository.findById(id).orElseThrow(() -> new RuntimeException("Tipo de cambio no encontrado"));
        existente.setMonedaOrigen(tipoCambio.getMonedaOrigen());
        existente.setMonedaDestino(tipoCambio.getMonedaDestino());
        existente.setTipoCambio(tipoCambio.getTipoCambio());
        return repository.save(existente);
    }
}
