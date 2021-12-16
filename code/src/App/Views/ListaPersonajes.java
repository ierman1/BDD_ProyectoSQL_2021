package App.Views;

import App.AppController;
import App.Components.ScrollablePanel;
import App.Components.TarjetaPersonaje;
import App.Models.Personaje;
import App.Popups.AprenderHechizos;
import App.Popups.ObjetoInventario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListaPersonajes extends View {

    public ListaPersonajes(JFrame frame) {
        super(frame, "Lista de personajes");
    }

    public JPanel render() {
        // Panel botones
        JPanel panelBotones = new JPanel();
        JButton botonCrear = new JButton("Crear personaje");
        panelBotones.setMaximumSize(new Dimension(500, 100));
        panelBotones.add(botonCrear);

        // Panel partido: lista + opciones
        ScrollablePanel panelPersonajes = new ScrollablePanel();
        panelPersonajes.setLayout(new FlowLayout(FlowLayout.LEFT));

        for (Personaje p : Personaje.getList())
            panelPersonajes.add(new TarjetaPersonaje(p));

        // Mostrar el contenido
        this.panel.add(panelPersonajes, BorderLayout.CENTER);
        this.panel.add(panelBotones, BorderLayout.PAGE_END);

        botonCrear.addActionListener(e -> AppController.crearPersonaje());

        return this.panel;
    }

}
