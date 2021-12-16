package App.Models;

import App.AppController;
import App.Connector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemInventario {
    private int cantidad;
    private Objeto objeto;
    private Personaje personaje;

    public ItemInventario(int cantidad, Objeto objeto, Personaje personaje) {
        this.cantidad = cantidad;
        this.objeto = objeto;
        this.personaje = personaje;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Objeto getObjeto() {
        return objeto;
    }

    public Personaje getPersonaje() {
        return personaje;
    }

    public static List<ItemInventario> getItemsByPj(Personaje p){
        String sql = "SELECT * FROM INVENTARIOS WHERE ID_PERSONAJE = " + p.getId();
        ResultSet rs = Connector.executeQuery(sql);
        List<ItemInventario> result = new ArrayList<>();
        try {
            while(rs.next()){
                result.add(new ItemInventario(
                        rs.getInt("cantidad"),
                        Objeto.getObjetoById(rs.getInt("id_objeto")), p));
            }
        } catch (SQLException e) {

        }

        AppController.nuevoRegistro(sql);
        return result;
    }

    public static void addItemToInv(Objeto o, Personaje p, int cantidad){
        String sql = " INSERT INTO INVENTARIOS (id_personaje, id_objeto, cantidad) " +
                "        VALUES ("+p.getId()+", "+o.getId()+", "+cantidad+") " +
                "        ON CONFLICT (id_personaje, id_objeto) DO UPDATE " +
                "        SET cantidad = INVENTARIOS.cantidad +"+cantidad+" ;";


        Connector.executeUpdate(sql);
        AppController.nuevoRegistro(sql);
    }

    @Override
    public String toString() {
        return "Objeto: "+objeto.getNombre()+", Cantidad: "+ cantidad;
    }


}
