package org.example.service;

import org.example.dto.Pago;

import java.math.BigDecimal;

public class PagoService {
    private Pago pago;
    private final CuponService cuponService;

    public PagoService(CuponService cuponService, BigDecimal total) {
        this.cuponService = cuponService;
    }

    public void cargarPago(BigDecimal total) {

    }

    public void aplicarCupon(String codigo) {

    }

    public void removerCupon() {

    }

    public void finalizarPago() {
        
    }

    public Pago getPago() {
        return pago;
    }
}
