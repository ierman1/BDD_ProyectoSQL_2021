package App.Views;

import App.AppController;
import App.Components.ScrollablePanel;
import App.Components.TarjetaPersonaje;
import App.Models.Personaje;
import App.Popups.Resumen;

import javax.swing.*;
import java.awt.*;
import java.util.List;

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

        JButton botonResumen = new JButton("Ver Resumen");
        panelBotones.add(botonResumen);
        // Panel partido: lista + opciones
        ScrollablePanel panelPersonajes = new ScrollablePanel();
        panelPersonajes.setLayout(new FlowLayout(FlowLayout.LEFT));

        List<Personaje> lst = Personaje.getList();
        for (Personaje p : lst)
            panelPersonajes.add(new TarjetaPersonaje(p));

        // Mostrar el contenido
        this.panel.add(panelPersonajes, BorderLayout.CENTER);
        this.panel.add(panelBotones, BorderLayout.PAGE_END);

        botonCrear.addActionListener(e -> AppController.crearPersonaje());
        botonResumen.addActionListener(e -> Resumen.show());

        return this.panel;
    }

}
