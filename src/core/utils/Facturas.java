/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.utils;

import core.database.Conexion2;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author freddy
 */
public class Facturas {
    private final Connection conn= new Conexion2().connect();
    private final Integer idFactura;
    private final String nitCliente,solvente,fecha;
    private final Double 
            costo,
            pagoEfectivo,
            pagoElectronico,
            cambio;
    public Facturas(
            Integer idFactura, 
            String nitCliente,
            Double costo,
            Double pagoEfectifo,
            Double pagoElectronico,
            Double cambio,
            String fecha,
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
    
    public ArrayList<Facturas> listaFacturasDia (String fecha){
        
        ArrayList<Facturas> listaFacturases= new ArrayList<Facturas>();
        String sql="SELECT * FROM `cafebar`.`factura_venta` WHERE date(fecha) ="+fecha;
        
        try {
            Statement stm;
            stm = conn.createStatement();
            ResultSet rst;
            rst = stm.executeQuery(sql);
            
            while (rst.next()){
                Facturas factura= new Facturas (
                        rst.getInt(1), 
                        rst.getString(2), 
                        rst.getDouble(3), 
                        rst.getDouble(4), 
                        rst.getDouble(5), 
                        rst.getDouble(6), 
                        rst.getString(7), 
                        rst.getString(8)
                );
                
                listaFacturases.add(factura);
                
            }
        } catch (SQLException e) {
            System.err.println("Error: "+e);
        }
        return listaFacturases;
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

    public String getFecha() {
        return fecha;
    }


}
