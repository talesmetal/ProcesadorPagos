package org.example.dto;

import java.math.BigDecimal;

public class Cupon {
    private final String codigo;
    private final BigDecimal descuento;

    public Cupon(String codigo, BigDecimal descuento) {
        this.codigo = codigo;
        this.descuento = descuento;
    }

    public String getCodigo() {
        return codigo;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }
}
