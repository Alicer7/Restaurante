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
public class Pedidos {
    private Integer idPedido;
    private Integer facturaId;
    private Integer menuId;
    private Integer menuCantidad;
    private Integer comidaId;
    private Integer comidaCantidad;
    private Integer bebidaId;
    private Integer bebidaCantidad;
    private Double costo;
    private String tiempo;
    private String solvente;

    public Pedidos() {
    }
 
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
            String tiempo,
            String solvente
    ) {
        this.idPedido=idPedido;
        this.facturaId=facturaId;
        this.menuId=menuId;
        this.menuCantidad=menuCantidad;
        this.comidaId=menuCantidad;
        this.comidaCantidad=comidaCantidad;
        this.bebidaId=bebidaCantidad;
        this.bebidaCantidad=bebidaCantidad;
        this.costo=costo;
        this.tiempo=tiempo;
        this.solvente=solvente;
    }

    public ArrayList<Pedidos> listaPedidosDia (String fecha){
        Connection conn= new Conexion2().connect();
        
        ArrayList<Pedidos> listaPedidos= new ArrayList<>();
        String sql="SELECT * FROM `factura_pedido` WHERE date(`time`) = \""+fecha+"\"";
        
        try {
            Statement stm;
            stm = conn.createStatement();
            ResultSet rst;
            rst = stm.executeQuery(sql);
            
            while (rst.next()){
                Pedidos pedido = new Pedidos(
                        rst.getInt(1), 
                        rst.getInt(2), 
                        rst.getInt(3), 
                        rst.getInt(4), 
                        rst.getInt(5), 
                        rst.getInt(6), 
                        rst.getInt(7), 
                        rst.getInt(8), 
                        rst.getDouble(9), 
                        rst.getString(10), 
                        rst.getString(11)
                );
                
                listaPedidos.add(pedido);
                
            }
        } catch (SQLException e) {
            System.err.println("Error: "+e);
        }
        return listaPedidos;
    }
    
    public ArrayList<Pedidos> listaPedidosNumeroFactura ( Integer numeroFactura){
        Connection conn= new Conexion2().connect();
        
        ArrayList<Pedidos> listaPedidos= new ArrayList<>();
        String sql="SELECT * FROM `factura_pedido` WHERE `factura_venta_id` = "+numeroFactura;
        
        try {
            Statement stm;
            stm = conn.createStatement();
            ResultSet rst;
            rst = stm.executeQuery(sql);
            
            while (rst.next()){
                Pedidos pedido = new Pedidos(
                        rst.getInt(1), 
                        rst.getInt(2), 
                        rst.getInt(3), 
                        rst.getInt(4), 
                        rst.getInt(5), 
                        rst.getInt(6), 
                        rst.getInt(7), 
                        rst.getInt(8), 
                        rst.getDouble(9), 
                        rst.getString(10), 
                        rst.getString(11)
                );
                
                listaPedidos.add(pedido);
                
            }
        } catch (SQLException e) {
            System.err.println("Error: "+e);
        }
        return listaPedidos;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public Integer getFacturaId() {
        return facturaId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public Integer getMenuCantidad() {
        return menuCantidad;
    }

    public Integer getComidaId() {
        return comidaId;
    }

    public Integer getComidaCantidad() {
        return comidaCantidad;
    }

    public Integer getBebidaId() {
        return bebidaId;
    }

    public Integer getBebidaCantidad() {
        return bebidaCantidad;
    }

    public Double getCosto() {
        return costo;
    }

    public String getTiempo() {
        return tiempo;
    }

    public String getSolvente() {
        return solvente;
    }
    
}
