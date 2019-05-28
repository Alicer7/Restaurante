/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import java.util.Date;

/**
 *
 * @author Alicer
 */
public class personal {

    public String Nombre;
    public String Apellidos;
    public String Dpi;
    public String Sexo;
    public int Telefono;
    public int Id_Cargo;
    public int Id_Turno;
    public Date FechaIngreso;
    public String Estado;

    public personal(String Nombre, String Apellidos, String DPI, String SEXO, int TELEFONO, int CARGO, int TURNO, Date Fecha, String ESTADO) {
        super();
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Dpi = DPI;
        this.Sexo = SEXO;
        this.Telefono = TELEFONO;
        this.Id_Cargo = CARGO;
        this.Id_Turno = TURNO;
        this.FechaIngreso = Fecha;
        this.Estado = ESTADO;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDpi() {
        return Dpi;
    }

    public void setDpi(String Dpi) {
        this.Dpi = Dpi;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public int getId_Cargo() {
        return Id_Cargo;
    }

    public void setId_Cargo(int Id_Cargo) {
        this.Id_Cargo = Id_Cargo;
    }

    public int getId_Turno() {
        return Id_Turno;
    }

    public void setId_Turno(int Id_Turno) {
        this.Id_Turno = Id_Turno;
    }

    public Date getFechaIngreso() {
        return FechaIngreso;
    }

    public void setFechaIngreso(Date FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    

}
//    
//id
//nombre
//apellidos
//dpi
//sexo
//telefono
//id_cargo
//id_turno
//fecha_ingreso
//estado
