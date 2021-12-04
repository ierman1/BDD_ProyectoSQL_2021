package App.Models;

import App.Connector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Personaje {

    private static String TABLE_NAME = "personajes";
    private static List<Personaje> LIST;

    private int id;
    private int idClase;
    private int idRaza;

    private String nombre;
    private int nivel;
    private boolean estaInspirado;
    private String trasfondo;
    private int edad;
    private int altura;
    private int peso;
    private int vida_max;
    private int vida_actual;
    private int oro;

    private int fuerza;
    private int destreza;
    private int constitucion;
    private int inteligencia;
    private int sabiduria;
    private int carisma;

    private Clase clase;
    private Raza raza;

    public Personaje(int id, int idClase, int idRaza, String nombre, int nivel, boolean estaInspirado, String trasfondo, int edad, int altura, int peso, int vida_max, int vida_actual, int oro, int fuerza, int destreza, int constitucion, int inteligencia, int sabiduria, int carisma) {
        this.id = id;
        this.idClase = idClase;
        this.idRaza = idRaza;
        this.nombre = nombre;
        this.nivel = nivel;
        this.estaInspirado = estaInspirado;
        this.trasfondo = trasfondo;
        this.altura = altura;
        this.peso = peso;
        this.vida_max = vida_max;
        this.vida_actual = vida_actual;
        this.oro = oro;
        this.fuerza = fuerza;
        this.destreza = destreza;
        this.constitucion = constitucion;
        this.inteligencia = inteligencia;
        this.sabiduria = sabiduria;
        this.carisma = carisma;
    }

    public Clase getClase() {
        if (this.clase == null)
            this.clase = Clase.find(this.idClase);

        return this.clase;
    }

    public Raza getRaza() {
        if (this.raza == null)
            this.raza = Raza.find(this.idRaza);

        return this.raza;
    }

    private static List<Personaje> get() {
        ResultSet rs = Connector.executeQuery("SELECT * FROM " + TABLE_NAME);
        List<Personaje> result = new ArrayList<>();

        try {
            while(rs.next()){
                result.add(new Personaje(
                        rs.getInt("id"),
                        rs.getInt("id_clase"),
                        rs.getInt("id_raza"),
                        rs.getString("nombre"),
                        rs.getInt("nivel"),
                        rs.getBoolean("esta_inspirado"),
                        rs.getString("trasfondo"),
                        rs.getInt("edad"),
                        rs.getInt("altura"),
                        rs.getInt("peso"),
                        rs.getInt("vida_max"),
                        rs.getInt("vida_actual"),
                        rs.getInt("oro"),
                        rs.getInt("fuerza"),
                        rs.getInt("destreza"),
                        rs.getInt("constitucion"),
                        rs.getInt("inteligencia"),
                        rs.getInt("sabiduria"),
                        rs.getInt("carisma")));
            }
        } catch (SQLException e) {

        }

        return result;
    }

    public static List<Personaje> getList() {
        Personaje.LIST = Personaje.get();
        return Personaje.LIST;
    }

    public static List<Personaje> getList(boolean refresh) {
        if (Personaje.LIST == null || refresh)
            return Personaje.getList();

        return Personaje.LIST;
    }

    public static Personaje find(int id) {
        Personaje result;

        try {
            result = (Personaje) Personaje.getList().stream().filter(personaje -> personaje.id == id).toArray()[0];
        } catch (ArrayIndexOutOfBoundsException ex) {
            return null;
        }

        return result;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
