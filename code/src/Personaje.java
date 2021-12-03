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

    public Personaje(int id, String nombre, int nivel) {
        this.id = id;
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public static List<Personaje> get() {
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

    public Personaje find(int id) {
        return null;
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                '}';
    }
}
