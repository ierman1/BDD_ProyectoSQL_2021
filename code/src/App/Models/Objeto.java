package App.Models;

import App.Connector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Objeto {

    public static String TABLE_NAME_DAD = "objetos";
    private int id;
    private String nombre;
    private String desc;
    private int peso;
    private String volumen;
    private int valor;
    private boolean equipable;


    public Objeto(int id, String nombre, String desc, int peso, String volumen, int valor, boolean equipable) {
        this.id = id;
        this.nombre = nombre;
        this.desc = desc;
        this.peso = peso;
        this.volumen = volumen;
        this.valor = valor;
        this.equipable = equipable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public boolean isEquipable() {
        return equipable;
    }

    public void setEquipable(boolean equipable) {
        this.equipable = equipable;
    }

    public static List<Objeto> getObjectList() {
        ResultSet rs = Connector.executeQuery("SELECT "+TABLE_NAME_DAD+".*  FROM " + TABLE_NAME_DAD);
        List<Objeto> result = new ArrayList<>();

        try {
            while(rs.next()){
                result.add(new Objeto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getInt("peso"),
                        rs.getString("volumen"),
                        rs.getInt("valor"),
                        rs.getBoolean("equipable")));
            }
        } catch (SQLException e) {

        }

        return result;

    }
    @Override
    public String toString() {
        return this.nombre ;
    }


}
