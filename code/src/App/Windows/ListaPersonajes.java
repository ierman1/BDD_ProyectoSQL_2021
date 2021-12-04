package App.Windows;

import App.Models.Personaje;

import javax.swing.*;

public class ListaPersonajes extends Window {

    private JFrame frame;

    public void render() {
        frame = new JFrame("Personajes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        JList list = new JList(Personaje.getList().toArray());
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setVisibleRowCount(-1);

        frame.getContentPane().add(list);
        frame.setVisible(true);
    }

    public void close() {
        frame.setVisible(false);
    }

}
