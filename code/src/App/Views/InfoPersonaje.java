package App.Views;

import App.Controller;

import javax.swing.*;
import java.awt.*;

public class InfoPersonaje extends View {

    public InfoPersonaje(JFrame frame) {
        super(frame, "Información del personaje");
    }

    public JPanel render() {
        Controller.ListaPersonajes();
        JPanel test = new JPanel();
        JButton botonVolver = new JButton("Volver");
        botonVolver.addActionListener(e -> Controller.ListaPersonajes());

        test.setMinimumSize(new Dimension(500, 400));
        test.add(botonVolver);
        this.panel.add(test, BorderLayout.PAGE_START);

        return this.panel;
    }

}
