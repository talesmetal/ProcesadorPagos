package org.example.service;

import org.example.dto.Pago;
import org.example.exception.CuponException;

import java.math.BigDecimal;

public class PagoService {
    private Pago pago;
    private final CuponService cuponService;

    public PagoService(CuponService cuponService) {
        this.cuponService = cuponService;
    }

    public void cargarPago(BigDecimal total) {
        if(total == null) {
            throw new CuponException("El total no puede ir null");
        }
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
