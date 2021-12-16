package App;

import App.Models.Personaje;
import App.Views.*;

import javax.swing.*;


public class AppController {

    private static AppController app;
    private static View currentView;
    private JFrame appFrame;

    private AppController() {
        this.appFrame = new JFrame();
        this.appFrame.setSize(800, 400);
        this.appFrame.setResizable(false);
        this.appFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.appFrame.setVisible(true);
    }

    public static void start() {
        AppController.app = new AppController();
    }

    private void swapWindow(View view) {
        if (this.currentView != null)
            this.appFrame.getContentPane().removeAll();

        this.currentView = view;

        this.appFrame.add(this.currentView.render());
        this.appFrame.revalidate();
        this.appFrame.repaint();
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

        CrearPersonaje v = new CrearPersonaje(AppController.app.appFrame);
        //v.nuevoPersonaje = p;
        AppController.app.swapWindow(v);
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

    public static void crearPersonajeGuardar(){

        //guardar personaje + INSERT

        AppController.app.swapWindow(new CrearPersonajeFase5(AppController.app.appFrame));
    }
}
