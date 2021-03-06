package App.Models;

import App.AppController;
import App.Connector;
import jdk.jshell.spi.ExecutionControl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Clase {

    private static String TABLE_NAME = "clases";
    private static List<Clase> LIST;


    private int id;
    private String nombre;
    private String descripcion;
    private int dadoVida;
    private int salvacion1;
    private Integer salvacion2;

    public Clase(int id, String nombre, String descripcion, int dadoVida, int salvacion1, Integer salvacion2) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.dadoVida = dadoVida;
        this.salvacion1 = salvacion1;
        this.salvacion2 = salvacion2;
    }

    public int getId() {
        return id;
    }

    private static List<Clase> get() {
        String sql = "SELECT * FROM " + TABLE_NAME;
        ResultSet rs = Connector.executeQuery(sql);
        List<Clase> result = new ArrayList<>();

        try {
            while(rs.next()){
                result.add(new Clase(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getInt("dado_vida"),
                        rs.getInt("salvacion_1"),
                        rs.getInt("salvacion_2")));
            }
        } catch (SQLException e) {

        }

        AppController.nuevoRegistro(sql);

        return result;
    }

    public static String getHechizosDeClase(String nombre) {
        String sql = "SELECT string_agg(h.nombre, ', ') as atr FROM hechizos h " +
                "JOIN hechizos_clase hc ON (h.id = hc.id_hechizo) " +
                "JOIN " + TABLE_NAME + " c ON (hc.id_clase = c.id) " +
                "WHERE c.nombre = '" + nombre + "'";
        ResultSet rs = Connector.executeQuery(sql);

        String result = "";
        try {
            rs.next();
            result = rs.getString("atr");

        } catch (SQLException e) {
            throw new RuntimeException("SQL error : " + e.getMessage());
        }

        AppController.nuevoRegistro(sql);
        if(result == null ) return "Aun no tiene hechizos de clase.";
        return result;
    }

    public String getObjetosInicialesDeClase(String nombre){
        String sql = "SELECT string_agg(o.nombre, ', ') as atr FROM objetos o "+
        "JOIN objetos_iniciales oi ON (oi.id_objeto = o.id) " +
        "JOIN " + TABLE_NAME + " c ON (c.id = oi.id_clase) " +
        "WHERE c.nombre = '" + nombre + "'";
        ResultSet rs = Connector.executeQuery(sql);

        String result = "";
        try {
            rs.next();
            result = rs.getString("atr");

        } catch (SQLException e) {
            throw new RuntimeException("SQL error : " + e.getMessage());
        }

        AppController.nuevoRegistro(sql);

        return result;
    }
    

    public static List<Clase> getList() {
        Clase.LIST = Clase.get();
        return Clase.LIST;
    }

    public static List<Clase> getList(boolean refresh) {
        if (Clase.LIST == null || refresh)
            return Clase.getList();

        return Clase.LIST;
    }

    public static Clase find(int id) {
        if(id == 0){
            return null;
        }
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE ID = " + id;
        List<Clase> result = new ArrayList<>();

        ResultSet rs = Connector.executeQuery(sql);
        try {
            while(rs.next()){
                result.add(new Clase(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getInt("dado_vida"),
                        rs.getInt("salvacion_1"),
                        rs.getInt("salvacion_2")));
            }
        } catch (SQLException e) {

        }

        AppController.nuevoRegistro(sql);
        return result.get(0);
    }

    public String getNombre() {
    	return this.nombre;
    }
    
    @Override
    public String toString() {
        return "App.Models.Clase{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getDadoVida() {
        return dadoVida;
    }

    public int getSalvacion1() {
        return salvacion1;
    }

    public Integer getSalvacion2() {
        return salvacion2;
    }
}
