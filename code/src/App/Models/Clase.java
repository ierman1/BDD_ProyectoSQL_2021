package App.Models;

import App.Connector;

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
}
