package App;

import App.Models.Personaje;
import App.Popups.RegistroConsultas;
import App.Views.*;

import javax.swing.*;


public class AppController {

    private static AppController app;
    private View currentView;
    private JFrame appFrame;
    private RegistroConsultas registro;

    private AppController(boolean debug) {
        this.appFrame = new JFrame();
        this.appFrame.setSize(800, 400);
        this.appFrame.setResizable(false);
        this.appFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.appFrame.setVisible(true);

        if (debug)
            this.registro = new RegistroConsultas();
    }

    public static void start(boolean registrar) {
        AppController.app = new AppController(registrar);
    }

    private void swapWindow(View view) {
        if (this.currentView != null)
            this.appFrame.getContentPane().removeAll();

        this.currentView = view;

        this.appFrame.add(this.currentView.render());
        this.appFrame.revalidate();
        this.appFrame.repaint();
    }

    public static void nuevoRegistro(String registro) {
        if (AppController.app.registro != null)
            AppController.app.registro.nuevaLinea(registro);
    }

    public static void listaPersonajes() {
        AppController.app.swapWindow(new ListaPersonajes(AppController.app.appFrame));
    }

    public static void infoPersonaje(Personaje personaje) {
        AppController.app.swapWindow(new InfoPersonaje(AppController.app.appFrame, personaje));
    }

    public static void inventarioPersonaje(Personaje personaje) {
        AppController.app.swapWindow(new InventarioPersonaje(AppController.app.appFrame, personaje));
    }
    public static void hechizosPersonaje(Personaje personaje) {
        AppController.app.swapWindow(new HechizosPersonaje(AppController.app.appFrame, personaje));
    }


    public static void crearPersonaje() {
        AppController.app.swapWindow(new CrearPersonaje(AppController.app.appFrame));
    }

    public static void crearPersonajeFase2() {
        AppController.app.swapWindow(new CrearPersonajeFase2(AppController.app.appFrame));
    }

    public static void crearPersonajeFase3(){
        AppController.app.swapWindow(new CrearPersonajeFase3(AppController.app.appFrame));
    }

    public static void crearPersonajeFase4(){
        AppController.app.swapWindow(new CrearPersonajeFase4(AppController.app.appFrame));
    }

    public static void crearPersonajeFase5(){
        AppController.app.swapWindow(new CrearPersonajeFase5(AppController.app.appFrame));
    }

}
