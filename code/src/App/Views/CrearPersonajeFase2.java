package App.Views;

import App.AppController;

import javax.swing.*;
import java.awt.*;

public class CrearPersonajeFase2 extends View {

    public CrearPersonajeFase2(JFrame frame) {
        super(frame, "Crear personaje - Elige clase");
    }

    public JPanel render() {
        JButton botonVolver = new JButton("Volver");

        // Mostrar el contenido
        this.panel.add(botonVolver, BorderLayout.PAGE_START);

        // Eventos
        botonVolver.addActionListener(e -> AppController.crearPersonaje());

        return this.panel;
    }

}
