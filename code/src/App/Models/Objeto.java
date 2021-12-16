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

    /**
     * Esta funcion devuelve lista de nombres de items de un pack de aventurero.
     * @return
     */
    public static List<Objeto> getObjectsFromPackAventurero() {
        ResultSet rs = Connector.executeQuery("select o.* from objetos_packs_iniciales opi " +
                        "    join packs_iniciales packs_ini on (packs_ini.id = opi.id_pack_inicial) " +
                        "    join objetos o on (o.id = opi.id_objeto) " +
                        "    where packs_ini.nombre = 'Pack de aventurero'");
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

    public static String getPackFromClase(String nombre_clase){
        ResultSet rs = Connector.executeQuery("select ini.nombre from packs_iniciales ini " +
                "join clases c on (ini.id_clase = c.id) " +
                "where c.nombre ='" + nombre_clase + "'");
        String result = null;

        try {
            while(rs.next()){
                result= rs.getString("nombre");
            }
        } catch (SQLException e) {

        }

        return result;
    }

    public static List<Objeto> getObjectsFromPackClase(String nombre_clase) {
        ResultSet rs = Connector.executeQuery("select o.* from objetos_packs_iniciales opi " +
                "join packs_iniciales packs_ini on (packs_ini.id = opi.id_pack_inicial) " +
                "join clases c on (c.id = packs_ini.id_clase) " +
                "join objetos o on (o.id = opi.id_objeto) " +
                "where c.nombre = '" + nombre_clase + "'");
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


    public static Objeto getObjetoById(int id){
        String sql = "SELECT "+TABLE_NAME_DAD+".* FROM "+TABLE_NAME_DAD+" WHERE ID = "+id+";";
        List<Objeto> result = new ArrayList<>();

        ResultSet rs = Connector.executeQuery(sql);
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
        return result.get(0);

    }

    @Override
    public String toString() {
        return this.nombre ;
    }


}
