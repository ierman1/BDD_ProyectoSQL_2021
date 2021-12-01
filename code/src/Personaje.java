import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Personaje {

    private static String TABLE_NAME = "personajes";

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
        ArrayList<Personaje> result = new ArrayList<>();

        try {
            while(rs.next()){
                result.add(new Personaje(rs.getInt("id"), rs.getString("nombre"), rs.getInt("nivel")));
            }
        } catch (SQLException e) {

        }

        return result;
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
