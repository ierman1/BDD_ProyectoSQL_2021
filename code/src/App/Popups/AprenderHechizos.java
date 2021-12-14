package App.Popups;

import App.AppController;
import App.Models.Hechizos;
import App.Models.ItemInventario;
import App.Models.Objeto;
import App.Models.Personaje;
import App.Views.HechizosPersonaje;
import App.Views.InventarioPersonaje;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AprenderHechizos {

    private static boolean up = false;

    public static void show(Personaje p, HechizosPersonaje hechizoPersonaje) {
        if (AprenderHechizos.up)
            return;

        AprenderHechizos.up = true;
        JFrame frame = new JFrame("Aprender hechizos");
        frame.setSize(500, 300);
        frame.setResizable(false);
        frame.setVisible(true);

        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
            AprenderHechizos.up = false;
            }
        });

        JPanel panelRaiz;
        JPanel panelAprendidos;
        JPanel panelCentral;
        JPanel panelAprendibles;
        JButton aprenderButton;
        JButton desaprenderButton;
        final JList lstAprendidos;
        final JList lstAprendibles;

        panelRaiz = new JPanel();
        panelRaiz.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panelRaiz.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        panelAprendidos = new JPanel();
        panelAprendidos.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        panelRaiz.add(panelAprendidos, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Aprendidos");
        panelAprendidos.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lstAprendidos = new JList(Hechizos.getHechizosByPersonaje(p).toArray());

        JScrollPane scrollListaAprendidos = new JScrollPane();
        scrollListaAprendidos.setViewportView(lstAprendidos);
        panelAprendidos.add(scrollListaAprendidos, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        panelCentral = new JPanel();
        panelCentral.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        panelRaiz.add(panelCentral, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        aprenderButton = new JButton();
        aprenderButton.setText("Aprender");
        panelCentral.add(aprenderButton, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_SOUTH, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        desaprenderButton = new JButton();

        desaprenderButton.setText("Desaprender");
        panelCentral.add(desaprenderButton, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        panelAprendibles = new JPanel();
        panelAprendibles.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        panelRaiz.add(panelAprendibles, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Aprendibles");
        panelAprendibles.add(label2, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lstAprendibles = new JList(Hechizos.getHechizosAprendiblesByPj(p).toArray());

        JScrollPane scrollListaAprendibles = new JScrollPane();
        scrollListaAprendibles.setViewportView(lstAprendibles);

        panelAprendibles.add(scrollListaAprendibles, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));

        aprenderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Hechizos.aprenderHechizo((Hechizos)lstAprendibles.getSelectedValue(), p);

                DefaultListModel aprendidos =new DefaultListModel();
                aprendidos.addAll(Hechizos.getHechizosByPersonaje(p));
                lstAprendidos.setModel(aprendidos);

                DefaultListModel aprendibles =new DefaultListModel();
                aprendibles.addAll(Hechizos.getHechizosAprendiblesByPj(p));
                lstAprendibles.setModel(aprendibles);

            }
        });
        desaprenderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Hechizos.desaprenderHechizo((Hechizos) lstAprendidos.getSelectedValue(), p);
                DefaultListModel aprendidos =new DefaultListModel();
                aprendidos.addAll(Hechizos.getHechizosByPersonaje(p));
                lstAprendidos.setModel(aprendidos);

                DefaultListModel aprendibles =new DefaultListModel();
                aprendibles.addAll(Hechizos.getHechizosAprendiblesByPj(p));
                lstAprendibles.setModel(aprendibles);
            }
        });

        frame.add(panelRaiz);
    }

}
