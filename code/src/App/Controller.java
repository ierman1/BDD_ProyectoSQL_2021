package App;

import App.Views.ListaPersonajes;
import App.Views.InfoPersonaje;
import App.Views.View;

import javax.swing.*;

public class Controller {

    private static View currentView;
    private static JFrame appFrame;

    public static void initialize() {
        if (Controller.appFrame == null) {
            Controller.appFrame = new JFrame();
            Controller.appFrame.setVisible(true);
            Controller.appFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            Controller.appFrame.setSize(500, 400);
        }

        Controller.ListaPersonajes();
    }

    private static void swapWindow(View view) {
        if (Controller.currentView != null)
            Controller.appFrame.getContentPane().removeAll();

        Controller.currentView = view;
        Controller.appFrame.getContentPane().add(Controller.currentView.render());
        Controller.appFrame.repaint();
    }

    public static void ListaPersonajes() {
        Controller.swapWindow(new ListaPersonajes(Controller.appFrame));
    }

    public static void InfoPersonaje() {
        Controller.swapWindow(new InfoPersonaje(Controller.appFrame));
    }

}
