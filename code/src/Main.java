import App.AppController;
import App.Models.Clase;
import App.Models.Personaje;
import App.Models.Raza;
import App.Popups.RegistroConsultas;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        AppController.start(true);
        AppController.listaPersonajes();
    }

}
