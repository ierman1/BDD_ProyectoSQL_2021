package App.Views;

import App.AppController;
import App.Models.Personaje;

import javax.swing.*;
import java.awt.*;

public class InfoPersonaje extends View {

    private Personaje personaje;

    public InfoPersonaje(JFrame frame, Personaje personaje) {
        super(frame, personaje.getNombre());
        this.personaje = personaje;
    }

    public JPanel render() {
        JButton botonVolver = new JButton("Volver");

        // Mostrar el contenido
        this.panel.add(botonVolver, BorderLayout.PAGE_START);

        // Eventos
        botonVolver.addActionListener(e -> AppController.listaPersonajes());

        return this.panel;
    }

}
