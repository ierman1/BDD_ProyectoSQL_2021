package App.Views;

import App.AppController;
import App.Models.Personaje;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CrearPersonaje extends View {

    public CrearPersonaje(JFrame frame) {
        super(frame, "Crear personaje");
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
