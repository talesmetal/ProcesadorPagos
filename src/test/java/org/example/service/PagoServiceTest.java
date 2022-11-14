package org.example.service;

import org.example.exception.CuponException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PagoServiceTest {
    private final CuponService cuponService;
    private final PagoService pagoService;

    PagoServiceTest() {
        cuponService = new CuponService();
        pagoService = new PagoService(cuponService);
    }

    @Test
    void cargarPago() {
        Assertions.assertThrows(CuponException.class, () -> pagoService.cargarPago(null));
    }

    @Test
    void aplicarCupon() {
    }

    @Test
    void removerCupon() {
    }

    @Test
    void finalizarPago() {
    }

    @Test
    void getPago() {
    }
}