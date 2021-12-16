package App.Models;

import App.AppController;
import App.Connector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Hechizo {


    private int id;
    private String nombre;
    private String descripcion;
    private int rango;
    private String tiempoCast;
    private String duracion;
    private String coste;
    private int nivel;

    public Hechizo(int id, String nombre, String descripcion, int rango, String tiempoCast, String duracion, String coste, int nivel) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rango = rango;
        this.tiempoCast = tiempoCast;
        this.duracion = duracion;
        this.coste = coste;
        this.nivel = nivel;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getRango() {
        return rango;
    }

    public String getTiempoCast() {
        return tiempoCast;
    }

    public String getDuracion() {
        return duracion;
    }

    public String getCoste() {
        return coste;
    }

    public int getNivel() {
        return nivel;
    }

    public static List<Hechizo> getHechizosByPersonaje(Personaje p){
            String sql = "SELECT hechizos.* FROM hechizos WHERE id in (select id_hechizo from hechizos_aprendidos where id_personaje ="+p.getId()+") ORDER BY hechizos.nivel;";
            List<Hechizo> result = new ArrayList<>();

            ResultSet rs = Connector.executeQuery(sql);
            try {
                while(rs.next()){
                    result.add(new Hechizo(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("descripcion"),
                            rs.getInt("rango"),
                            rs.getString("tiempo_canalizacion"),
                            rs.getString("duracion"),
                            rs.getString("coste"),
                            rs.getInt("nivel")));
                }
            } catch (SQLException e) {

            }

            AppController.nuevoRegistro(sql);
            return result;
    }

    public static Hechizo getHechizoById(int id){
        String sql = "SELECT * FROM hechizos WHERE ID = "+id+";";
        List<Hechizo> result = new ArrayList<>();

        ResultSet rs = Connector.executeQuery(sql);
        try {
            while(rs.next()){
                result.add(new Hechizo(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getInt("rango"),
                        rs.getString("tiempo_canalizacion"),
                        rs.getString("duracion"),
                        rs.getString("coste"),
                        rs.getInt("nivel")));
            }
        } catch (SQLException e) {

        }

        AppController.nuevoRegistro(sql);
        return result.get(0);
    }

    public static List<Hechizo> getHechizosAprendiblesByPj(Personaje p){
        String sql =
                "select * from hechizos where id in "
                + "(select hc.id_hechizo from hechizos_clase hc "
                + "where hc.id_clase ="+p.getClase().getId()+" "
                + "union "
                + "select hr.id_hechizo from hechizos_raza hr "
                + "where hr.id_raza = "+p.getRaza().getId()+") "
                + "and id not in "
                + "(select id_hechizo from hechizos_aprendidos where id_personaje = "+p.getId()+")";
        List<Hechizo> result = new ArrayList<>();

        ResultSet rs = Connector.executeQuery(sql);
        try {
            while(rs.next()){
                result.add(new Hechizo(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getInt("rango"),
                        rs.getString("tiempo_canalizacion"),
                        rs.getString("duracion"),
                        rs.getString("coste"),
                        rs.getInt("nivel")));
            }
        } catch (SQLException e) {

        }

        AppController.nuevoRegistro(sql);
        return result;
    }

    public static void aprenderHechizo(Hechizo h, Personaje p){
        if(h!=null){
            String sql = "INSERT INTO hechizos_aprendidos (id_personaje, id_hechizo) values ("+p.getId()+", "+h.id+")";
            Connector.executeUpdate(sql);
        }
    }
    public static void desaprenderHechizo(Hechizo h, Personaje p){
        if(h != null){
            String sql = "DELETE FROM hechizos_aprendidos WHERE id_personaje= "+p.getId()+" and id_hechizo = "+h.id+";";
            Connector.executeUpdate(sql);
        }
    }

    @Override
    public String toString() {
        return "Hechizo: "+nombre+", Nivel: "+ nivel+", Coste: "+coste+", Rango: "+rango+ ", Duracion: "+duracion + ", Efecto: "+descripcion ;
    }
}
