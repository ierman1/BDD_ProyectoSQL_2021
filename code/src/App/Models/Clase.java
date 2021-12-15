package App.Models;

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
        ResultSet rs = Connector.executeQuery("SELECT * FROM " + TABLE_NAME);
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
        Clase result;

        try {
            result = (Clase) Clase.getList().stream().filter(clase -> clase.id == id).toArray()[0];
        } catch (ArrayIndexOutOfBoundsException ex) {
            return null;
        }

        return result;
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
