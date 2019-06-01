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
    private Connection conn= new Conexion2().connect();
    private Integer idPedido;
    private Integer facturaId;
    private Integer menuId;
    private Integer menuCantidad;
    private Integer comidaId;
    private Integer comidaCantidad;
    private Integer bebidaId;
    private Integer bebidaCantidad;
    private Double costo;
    private Timestamp tiempo;
    private String solvente;
 
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
            Timestamp tiempo,
            String solvente
    ) {
        this.idPedido=idPedido;
        this.facturaId=facturaId;
        this.menuId=menuId;
        this.menuCantidad=menuCantidad;
        this.comidaId=menuCantidad;
        this.bebidaId=bebidaCantidad;
        this.costo=costo;
        this.tiempo=tiempo;
        this.solvente=solvente;
    }

    
      public final ArrayList<Pedidos> listaPedidosDia (String dia){
        
        ArrayList<Pedidos> listaPedidos= new ArrayList<Pedidos>();
            
        String sql="SELECT * FROM `cafebar`.`factura_pedido` WHERE day(`time`) ="+dia;
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            System.out.println(rs);
            Pedidos pedidos;
            System.err.println("RS es: "+rs.next());;
            while (rs.next()){
                System.out.println(rs.getInt(idPedido));
                pedidos = new Pedidos(
                        rs.getInt(idPedido), 
                        rs.getInt(facturaId), 
                        rs.getInt(menuId), 
                        rs.getInt(menuCantidad), 
                        rs.getInt(comidaId), 
                        rs.getInt(comidaCantidad), 
                        rs.getInt(bebidaId), 
                        rs.getInt(bebidaCantidad), 
                        rs.getDouble(costo.toString()), 
                        rs.getTimestamp(tiempo.toString()),
                        rs.getString(solvente)
                );
                listaPedidos.add(pedidos);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        System.out.println("In clasee tamaño lista: "+listaPedidos.size());
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
    public String getCostoString() {
        return costo.toString();
    }

    public Timestamp getTiempo() {
        return tiempo;
    }
    
    public String getTiempoString() {
        return tiempo.toString();
    }


    public String getSolvente() {
        return solvente;
    }
    
}
