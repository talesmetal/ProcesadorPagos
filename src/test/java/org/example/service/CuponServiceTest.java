package org.example.service;


import org.example.dto.Cupon;
import org.example.exception.CuponException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class CuponServiceTest {
    private final CuponService cuponService;

    CuponServiceTest() {
        cuponService = new CuponService();
    }

    @Test
    void crearCupon() {
        Cupon c1 = new Cupon("", BigDecimal.TEN);
        Assertions.assertThrows(CuponException.class, () -> cuponService.crearCupon(c1));

        Cupon c2 = new Cupon(null, BigDecimal.TEN);
        Assertions.assertThrows(CuponException.class, () -> cuponService.crearCupon(c2));

        Cupon c3 = new Cupon("ABC", null);
        Assertions.assertThrows(CuponException.class, () -> cuponService.crearCupon(c3));

        Assertions.assertThrows(CuponException.class, () ->
                cuponService.crearCupon(new Cupon("ABC", BigDecimal.ZERO)));

        Assertions.assertThrows(CuponException.class, () ->
                cuponService.crearCupon(new Cupon("ABC", BigDecimal.TEN.negate())));

        Assertions.assertThrows(CuponException.class, () ->
                cuponService.crearCupon(new Cupon("ABC", new BigDecimal("21"))));

        //CUPÓN CREADO
        Assertions.assertDoesNotThrow(() -> cuponService.crearCupon(new Cupon("ABC", new BigDecimal("15"))));

        //CUPÓN DUPLICADO
        Assertions.assertThrows(CuponException.class, () ->
                cuponService.crearCupon(new Cupon("ABC", new BigDecimal("15"))));

        Cupon cuponBus = cuponService.buscarCupon("ABC");

        Assertions.assertNotNull(cuponBus);
        Assertions.assertEquals(0, cuponBus.getDescuento().compareTo(new BigDecimal("15")));
    }

    @Test
    void buscarCupon() {
        Assertions.assertThrows(CuponException.class, () -> cuponService.buscarCupon(null));

        Assertions.assertThrows(CuponException.class, () -> cuponService.buscarCupon(""));
    }

    @Test
    void eliminarCupon() {
        //CUPÓN CREADO
        Assertions.assertDoesNotThrow(() -> cuponService.crearCupon(new Cupon("AAA", new BigDecimal("15"))));

        Assertions.assertDoesNotThrow(() -> cuponService.eliminarCupon("AAA"));
        Cupon cuponElim = cuponService.buscarCupon("AAA");

        Assertions.assertNull(cuponElim);

        Assertions.assertThrows(CuponException.class, () -> cuponService.eliminarCupon(null));

        Assertions.assertThrows(CuponException.class, () -> cuponService.eliminarCupon(""));
    }
}