/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.ArrayList;
import Main.Producto;

public class Carniceria {
    String nombre;
    CarniceriaTipos tipo;
    ArrayList <Producto> inventario;

    public ArrayList<Producto> getInventario() {
        return inventario;
    }

    public Carniceria() {
        inventario=new ArrayList<Producto>();
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CarniceriaTipos getTipo() {
        return tipo;
    }

    public void setTipo(CarniceriaTipos tipo) {
        this.tipo = tipo;
    } 
}
