package App;

import App.Windows.ListaPersonajes;
import App.Windows.Window;

public class Controller {

    private static Window window;

    private static void swapWindow(Window window) {
        if (Controller.window != null)
            Controller.window.close();

        Controller.window = window;
        Controller.window.render();
    }

    public static void ListaPersonajes() {
        Controller.swapWindow(new ListaPersonajes());
    }

}
