package org.example.service;

import org.example.dto.Pago;

import java.math.BigDecimal;

public class PagoService {
    private final Pago pago;

    public PagoService(BigDecimal total) {
        pago = new Pago(total);
    }

    public void aplicarCupon(String codigo) {

    }

    public void removerCupon() {

    }

    public void finalizarPago() {
        
    }
}
