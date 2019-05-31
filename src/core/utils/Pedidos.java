/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.utils;

import core.database.Conexion2;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author freddy
 */
public class Pedidos {
    private Connection conn= new core.database.Conexion2().connect();
    private Integer idPedido;
    private Integer facturaId;
    private Integer menuId;
    private Integer menuCantidad;
    private Integer comidaId;
    private Integer comidaCantidad;
    private Integer bebidaId;
    private Integer bebidaCantidad;
    private Double costo;
    private Timestamp time;

    public Pedidos(
            Integer idPedido,
            Integer facturaId,
            Integer menuId,
            Integer menuCantidad,
            Integer comidaId,
            Integer comidaCantidad,
            Integer bebidaId,
            Integer bebidaCantidad,
            Double costo,
            Timestamp time
    ) {
        this.idPedido=idPedido;
        this.facturaId=facturaId;
        this.menuId=menuId;
        this.menuCantidad=menuCantidad;
        this.comidaId=menuCantidad;
        this.bebidaId=bebidaCantidad;
        this.costo=costo;
        this.time=time;
    }
    
    public ArrayList<Pedidos> listaPedidos (){
        try {
            
        } catch (Exception e) {
            System.err.println(e);
        }
        
        ArrayList<Pedidos> listaPedidos= new ArrayList<>();
            
        String sql="SELECT * FROM `cafebar`.`factura_pedido`";
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Pedidos pedidos;
            while (rs.next()){
                pedidos= new Pedidos(
                        rs.getInt(idPedido), 
                        rs.getInt(facturaId), 
                        rs.getInt(menuId), 
                        rs.getInt(menuCantidad), 
                        rs.getInt(comidaId), 
                        rs.getInt(comidaCantidad), 
                        rs.getInt(bebidaId), 
                        rs.getInt(bebidaCantidad), 
                        rs.getDouble(costo.toString()), 
                        rs.getTimestamp(time.toString())
                );
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return listaPedidos;
    }
    
}
