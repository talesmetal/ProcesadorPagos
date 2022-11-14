package org.example.service;

import org.example.dto.Cupon;
import org.example.exception.CuponException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CuponService {
    private final List<Cupon> cupones;

    public CuponService() {
        cupones = new ArrayList<>();
    }

    public void crearCupon(Cupon cupon) {
        if (cupon.getCodigo() == null) {
            throw new CuponException("El campo código no puede ir null");
        }

        if (cupon.getCodigo().equals("")) {
            throw new CuponException("El campo código no puede ir vacío");
        }

        if (cupon.getDescuento() == null) {
            throw new CuponException("El campo descuento no puede ir null");
        }

        if (cupon.getDescuento().compareTo(BigDecimal.ZERO) <= 0 || cupon.getDescuento().compareTo(new BigDecimal("20")) == 1) {
            throw new CuponException("El rango del descuento debe ser mayor a 0.00 y menor o igual a 20");
        }

        if (buscarCupon(cupon.getCodigo()) != null) {
            throw new CuponException("El cupón con el código %s ya existe".formatted(cupon.getCodigo()));
        }

        cupones.add(cupon);
    }

    public Cupon buscarCupon(String codigo) {
        if (codigo == null) {
            throw new CuponException("El campo código no puede ir null");
        }

        if (codigo.equals("")) {
            throw new CuponException("El campo código no puede ir vacío");
        }

        return cupones.stream()
                .filter(c -> c.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
    }

    public void eliminarCupon(String codigo) {
        if (codigo == null) {
            throw new CuponException("El campo código no puede ir null");
        }

        if (codigo.equals("")) {
            throw new CuponException("El campo código no puede ir vacío");
        }

        cupones.removeIf(c -> c.getCodigo().equals(codigo));
    }
}
