package App.Models;

import App.AppController;
import App.Connector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Raza {

    private static String TABLE_NAME = "razas";
    private static List<Raza> LIST;

    private int id;
    private Integer idRazaPadre;
    private String nombre;
    private String descripcion;
    private int velocidadAPie;
    private int velocidadNado;
    private int velocidadVuelo;
    private String ventajas;
    private String idiomas;
    private String altura;

    public Raza(int id, Integer idRazaPadre, String nombre, String descripcion, int velocidadAPie, int velocidadNado, int velocidadVuelo, String ventajas, String idiomas, String altura) {
        this.id = id;
        this.idRazaPadre = idRazaPadre;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.velocidadAPie = velocidadAPie;
        this.velocidadNado = velocidadNado;
        this.velocidadVuelo = velocidadVuelo;
        this.ventajas = ventajas;
        this.idiomas = idiomas;
        this.altura = altura;
    }

    private static List<Raza> get() {
        String sql = "SELECT * FROM " + TABLE_NAME;
        ResultSet rs = Connector.executeQuery(sql);
        List<Raza> result = new ArrayList<>();

        try {
            while(rs.next()){
                result.add(new Raza(
                        rs.getInt("id"),
                        rs.getInt("id_raza_padre"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getInt("velocidad_a_pie"),
                        rs.getInt("velocidad_nado"),
                        rs.getInt("velocidad_vuelo"),
                        rs.getString("ventajas"),
                        rs.getString("idiomas"),
                        rs.getString("altura")));
            }
        } catch (SQLException e) {

        }

        AppController.nuevoRegistro(sql);
        return result;
    }

    public static List<Raza> getSubrazas(Integer idRazaPadre) {

        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE id_raza_padre = " + idRazaPadre;
        ResultSet rs = Connector.executeQuery(sql);
        List<Raza> result = new ArrayList<>();

        try {
            while(rs.next()){
                result.add(new Raza(
                        rs.getInt("id"),
                        rs.getInt("id_raza_padre"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getInt("velocidad_a_pie"),
                        rs.getInt("velocidad_nado"),
                        rs.getInt("velocidad_vuelo"),
                        rs.getString("ventajas"),
                        rs.getString("idiomas"),
                        rs.getString("altura")));
            }
        } catch (SQLException e) {

        }

        AppController.nuevoRegistro(sql);
        return result;
    }

    public static List<Raza> getList() {
        Raza.LIST = Raza.get();
        return Raza.LIST;
    }

    public static List<Raza> getList(boolean refresh) {
        if (Raza.LIST == null || refresh)
            return Raza.getList();

        return Raza.LIST;
    }

    public String getNombre() {
    	return this.nombre;
    }
    
    public static Raza find(int id) {
        if(id == 0){
            return null;
        }
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE ID = " + id;
        List<Raza> result = new ArrayList<>();

        ResultSet rs = Connector.executeQuery(sql);
        try {
            while(rs.next()){
                result.add(new Raza(
                        rs.getInt("id"),
                        rs.getInt("id_raza_padre"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getInt("velocidad_a_pie"),
                        rs.getInt("velocidad_nado"),
                        rs.getInt("velocidad_vuelo"),
                        rs.getString("ventajas"),
                        rs.getString("idiomas"),
                        rs.getString("altura")));
            }
        } catch (SQLException e) {

        }

        AppController.nuevoRegistro(sql);
        return result.get(0);
    }

    public int getId() {
        return id;
    }

    public Integer getIdRazaPadre() {
        return idRazaPadre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getVelocidadAPie() {
        return velocidadAPie;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public String getVentajas() {
        return ventajas;
    }

    @Override
    public String toString() {
        return "App.Models.Raza{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

}
