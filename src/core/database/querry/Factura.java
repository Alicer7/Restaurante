/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.database.querry;

import core.database.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author freddy
 */
public class Factura {
    private Connection conn= new Conexion().connect();
    
    private Integer idFactura;
    private String nitCliente;
    private Double costo;
    private Double pagoEfectivo;
    private Double pagoElectronico;
    private Double cambio;
    private String fecha;
    private String solvente;

    public Factura() {
    }
    
    public Factura(
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
    
    public ArrayList<Factura> listaFacturasActivas (){
        
        ArrayList<Factura> listaFacturases= new ArrayList<>();
        String sql="SELECT * FROM `cafebar`.`temp_venta` WHERE `estado` = \"Activa\"";
        
        try {
            Statement stm;
            stm = conn.createStatement();
            ResultSet rst;
            rst = stm.executeQuery(sql);
            
            while (rst.next()){
                Factura factura= new Factura (
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
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaFacturases;
    }
    
    public ArrayList<Factura> listaFacturasFechaActivas (String fecha){
        
        ArrayList<Factura> listaFacturases= new ArrayList<>();
        String sql="SELECT * FROM `cafebar`.`temp_venta` WHERE date(`fecha`) = \""+fecha+"\"AND `solvente` = \"Activa\"";
        
        try {
            Statement stm;
            stm = conn.createStatement();
            ResultSet rst;
            rst = stm.executeQuery(sql);
            
            while (rst.next()){
                Factura factura= new Factura (
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
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaFacturases;
    }
    
    public ArrayList<Factura> listaFacturasFecha (String fecha){
        
        ArrayList<Factura> listaFacturases= new ArrayList<>();
        String sql="SELECT * FROM `cafebar`.`temp_venta` WHERE date(fecha) = \""+fecha+"\"";
        
        try {
            Statement stm;
            stm = conn.createStatement();
            ResultSet rst;
            rst = stm.executeQuery(sql);
            
            while (rst.next()){
                Factura factura= new Factura (
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
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaFacturases;
    }
    
    public void solventarFactura(Double TOTAL,Double EFECTIVO,Double ELECTRONICO,Double CAMBIO, Integer CLIENTEID){
        Conexion cone = new Conexion();
        com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) cone.connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            ps = conn.prepareStatement(
                  "UPDATE `cafebar`.`temp_venta`  SET "
                + "`estado` = ?, `costo` = ?, `pago_efectivo` = ?, `pago_electronico` = ?, `cambio` = ? "
                + "WHERE `id` = ?;"
            );
            
            ps.setString(1, "Solvente");
            ps.setDouble(2, TOTAL);
            ps.setDouble(3, EFECTIVO);
            ps.setDouble(4, ELECTRONICO);
            ps.setDouble(5, CAMBIO);
            ps.setInt(6, CLIENTEID);
            
            ps.execute();
            
        } catch (SQLException ex) {
            System.err.println("Factura > Error al actulzar el estado: "+ex);
        } finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
