package App.Models;

import App.AppController;
import App.Connector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Personaje {

    public static Personaje newPesonaje = new Personaje(0,0,0,"",0,false,"",0,0,0,0,0,0,0,0,0,0,0,0);

    private static String TABLE_NAME = "personajes";
    private static List<Personaje> LIST;

    private static Personaje nuevoPersonaje = new Personaje(0, 0, 0, "", 0, false, "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    private int id;

    private ArrayList<Objeto> objetosIniciales;


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
        this.edad = edad;
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

    public static int getMaxId(){
        String sql = "SELECT max(id) FROM personajes";

        ResultSet rs = Connector.executeQuery(sql);

        int result = 0;

        try {
            while(rs.next()){
                result = rs.getInt("max");
            }
        } catch (SQLException e) {

        }

        return result;
    }

    public static void insert(Personaje p) {

        //Hago parametrized query en vez de normal, más seguro / readable
        String sql = "INSERT into " + TABLE_NAME + " (id_clase,id_raza,nombre,nivel,esta_inspirado,trasfondo,edad,altura,peso,vida_max,vida_actual,oro,fuerza,destreza,constitucion,inteligencia,sabiduria,carisma) VALUES " +
                "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        Connection c = Connector.getConnection();
        PreparedStatement  s = null;
        try {
            s = c.prepareStatement(sql);
            s.setInt(1, p.getClase().getId());
            s.setInt(2, 1); //p.getRaza().getId()
            s.setString(3, p.getNombre());
            s.setInt(4, p.getNivel());
            s.setBoolean(5, p.isEstaInspirado());
            s.setString(6, p.getTrasfondo());
            s.setInt(7, p.getEdad());
            s.setInt(8, p.getAltura());
            s.setInt(9, p.getPeso());
            s.setInt(10, p.getVida_max());
            s.setInt(11, p.getVida_actual());
            s.setInt(12, p.getOro());

            s.setInt(13, p.getFuerza());
            s.setInt(14, p.getDestreza());
            s.setInt(15, p.getConstitucion());
            s.setInt(16, p.getInteligencia());
            s.setInt(17, p.getSabiduria());
            s.setInt(18, p.getCarisma());

            s.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdClase() {
        return idClase;
    }

    public int getIdRaza() {
        return idRaza;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public boolean isEstaInspirado() {
        return estaInspirado;
    }

    public String getTrasfondo() {
        return trasfondo;
    }

    public int getEdad() {
        return edad;
    }

    public int getAltura() {
        return altura;
    }

    public int getPeso() {
        return peso;
    }

    public int getVida_max() {
        return vida_max;
    }

    public int getVida_actual() {
        return vida_actual;
    }

    public int getOro() {
        return oro;
    }

    public int getFuerza() {
        return fuerza;
    }

    public int getDestreza() {
        return destreza;
    }

    public int getConstitucion() {
        return constitucion;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public int getSabiduria() {
        return sabiduria;
    }

    public int getCarisma() {
        return carisma;
    }

    // Relaciones
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

    public static void setNuevoPersonaje(Personaje nuevoPersonaje) {
        Personaje.nuevoPersonaje = nuevoPersonaje;
    }

    public static Personaje getNuevoPersonaje() {
        return nuevoPersonaje;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setEstaInspirado(boolean estaInspirado) {
        this.estaInspirado = estaInspirado;
    }

    public void setTrasfondo(String trasfondo) {
        this.trasfondo = trasfondo;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setVida_max(int vida_max) {
        this.vida_max = vida_max;
    }

    public void setVida_actual(int vida_actual) {
        this.vida_actual = vida_actual;
    }

    public void setOro(int oro) {
        this.oro = oro;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public void setConstitucion(int constitucion) {
        this.constitucion = constitucion;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public void setSabiduria(int sabiduria) {
        this.sabiduria = sabiduria;
    }

    public void setCarisma(int carisma) {
        this.carisma = carisma;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }

    public ArrayList<Objeto> getObjetosIniciales() {
        return objetosIniciales;
    }

    public void setObjetosIniciales(ArrayList<Objeto> objetosIniciales) {
        this.objetosIniciales = objetosIniciales;
    }

    public void updatePersonaje(){
        String SQL = "UPDATE " +TABLE_NAME+
                " SET "+
                " nombre= '"+this.nombre +"', "+
                " nivel= '"+this.nivel+"', " +
                " esta_inspirado= '"+this.estaInspirado+"', " +
                " trasfondo= '"+this.trasfondo+"', " +
                " edad= '"+this.edad+"', " +
                " altura= '"+this.altura+"', " +
                " peso= '"+this.peso+"', " +
                " vida_max= '"+this.vida_max+"', " +
                " vida_actual= '"+this.vida_actual+"', " +
                " oro= '"+this.oro+"', " +
                " fuerza='"+this.fuerza+"', " +
                " destreza='"+this.destreza+"', " +
                " constitucion='"+this.constitucion+"', " +
                " inteligencia='"+this.inteligencia+"', " +
                " sabiduria='"+this.sabiduria+"', " +
                " carisma= '"+this.carisma+"'" +
                " WHERE id = '"+this.id+"';";
            Connector.executeUpdate(SQL);

            AppController.nuevoRegistro(SQL);

    }

    private static List<Personaje> get() {
        String sql = "SELECT * FROM " + TABLE_NAME;
        ResultSet rs = Connector.executeQuery(sql);
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

        AppController.nuevoRegistro(sql);
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
