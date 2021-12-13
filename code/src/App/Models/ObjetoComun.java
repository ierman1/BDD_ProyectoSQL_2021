package App.Models;

import App.Connector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ObjetoComun extends Objeto {

    private static String TABLE_NAME = "objetos_comunes";
    private String efecto;

    public ObjetoComun(int id, String nombre, String desc, int peso, String volumen, int valor, boolean equipable, String efecto) {
        super(id, nombre, desc, peso, volumen, valor, equipable);
        this.efecto = efecto;
    }

    public static List<Objeto> getObjectList() {
            ResultSet rs = Connector.executeQuery("SELECT "+TABLE_NAME+".* , "+Objeto.TABLE_NAME_DAD+".* FROM " + TABLE_NAME + " LEFT JOIN " +
                    " ON "+TABLE_NAME+".ID_OBJETO = "+Objeto.TABLE_NAME_DAD+".ID");
            List<Objeto> result = new ArrayList<>();

            try {
                while(rs.next()){
                    result.add(new ObjetoComun(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("descripcion"),
                            rs.getInt("peso"),
                            rs.getString("volumen"),
                            rs.getInt("valor"),
                            rs.getBoolean("equipable"),
                            rs.getString("efecto")));
                }
            } catch (SQLException e) {

            }

            return result;

    }
}
