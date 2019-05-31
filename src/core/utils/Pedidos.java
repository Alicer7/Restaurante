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
    
}
