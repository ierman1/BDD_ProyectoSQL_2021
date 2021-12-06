import App.AppController;
import App.Models.Clase;
import App.Models.Personaje;
import App.Models.Raza;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Personaje> pjs = Personaje.getList();
        for (Personaje pj : pjs) {
            System.out.println(pj.toString());
        }

        List<Clase> cs = Clase.getList();
        for (Clase c : cs) {
            System.out.println(c.toString());
        }

        List<Raza> rs = Raza.getList();
        for (Raza r : rs) {
            System.out.println(r.toString());
        }

        Personaje pj = Personaje.find(2);
        if (pj != null) System.out.println(pj.getClase().toString());
        if (pj != null) System.out.println(pj.getRaza().toString());

        AppController.start();
        AppController.listaPersonajes();
    }

}
