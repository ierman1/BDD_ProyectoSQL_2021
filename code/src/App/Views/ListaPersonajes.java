package App.Views;

import App.Controller;
import App.Models.Personaje;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListaPersonajes extends View {

    private Personaje personajeSel;

    public ListaPersonajes(JFrame frame) {
        super(frame, "Lista de personajes");
    }

    public JPanel render() {
        // Panel superior
        JPanel panelSuperior = new JPanel();
        panelSuperior.setMinimumSize(new Dimension(500, 100));
        panelSuperior.add(new JLabel("Personajes"));

        // Panel botones
        JPanel panelBotones = new JPanel();
        JButton botonCrear = new JButton("Crear personaje");
        panelBotones.setMaximumSize(new Dimension(500, 100));
        panelBotones.add(botonCrear);

        // Panel partido: lista + opciones
        JList lista = new JList(Personaje.getList().toArray());
        JScrollPane scrollLista = new JScrollPane();
        JPanel panelOpciones = new JPanel();
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollLista, panelOpciones);

        lista.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        lista.setLayoutOrientation(JList.VERTICAL);
        lista.setVisibleRowCount(-1);
        scrollLista.setViewportView(lista);
        scrollLista.setMinimumSize(new Dimension(100, 200));

        // Mostrar el contenido
        this.panel.add(panelSuperior, BorderLayout.PAGE_START);
        this.panel.add(splitPane, BorderLayout.CENTER);
        this.panel.add(panelBotones, BorderLayout.PAGE_END);

        // Eventos
        lista.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() == 2)
                    Controller.InfoPersonaje();
            }
        });

        return this.panel;
    }

}
