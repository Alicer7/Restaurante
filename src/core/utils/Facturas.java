/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.utils;

import java.sql.Timestamp;

/**
 *
 * @author freddy
 */
public class Facturas {
    private Integer idFactura;
    private String nitCliente,solvente;
    private Double 
            costo,
            pagoEfectivo,
            pagoElectronico,
            cambio;
    private Timestamp fecha;

    public Facturas(
            Integer idFactura, 
            String nitCliente,
            Double costo,
            Double pagoEfectifo,
            Double pagoElectronico,
            Double cambio,
            Timestamp fecha,
            String solvente
        ) {
        this.idFactura=idFactura;
        this.nitCliente=nitCliente;
        this.costo=costo;
        this.pagoEfectivo=pagoEfectifo;
        this.pagoElectronico=pagoElectronico;
        this.cambio=cambio;
        this.fecha=fecha;
        this.solvente=solvente;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public String getNitCliente() {
        return nitCliente;
    }

    public String getSolvente() {
        return solvente;
    }

    public Double getCosto() {
        return costo;
    }

    public Double getPagoEfectivo() {
        return pagoEfectivo;
    }

    public Double getPagoElectronico() {
        return pagoElectronico;
    }

    public Double getCambio() {
        return cambio;
    }

    public Timestamp getFecha() {
        return fecha;
    }


}
