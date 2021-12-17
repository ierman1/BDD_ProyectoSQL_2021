package App.Popups;

import App.AppController;
import App.Models.ItemInventario;
import App.Models.Objeto;
import App.Models.Personaje;
import App.Views.InventarioPersonaje;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.List;

public class ObjetoInventario {

    private static boolean up = false;

    public static void show(Personaje p, InventarioPersonaje inventarioPersonaje) {
        if (ObjetoInventario.up)
            return;

        ObjetoInventario.up = true;
        JFrame frame = new JFrame("Anadir objeto al inventario");
        frame.setSize(350, 200);
        frame.setResizable(false);
        frame.setVisible(true);

        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                ObjetoInventario.up = false;
            }
        });

        JList lstObjetos;
        JTextField tfCantidad;
        JButton btnAnadir;
        JButton btnQuitar;
        JLabel lblCantidad;
        JPanel panelDerecha;
        JPanel panelIzquierda;
        JPanel panelRaiz;


        panelRaiz = new JPanel();
        panelRaiz.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        panelIzquierda = new JPanel();
        panelIzquierda.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panelRaiz.add(panelIzquierda, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        lstObjetos = new JList(Objeto.getObjectList().toArray());

        JScrollPane scrollLista = new JScrollPane();
        scrollLista.setViewportView(lstObjetos);
        panelIzquierda.add(scrollLista, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 100), null, 0, false));
        panelDerecha = new JPanel();
        panelDerecha.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 1, new Insets(0, 0, 0, 0), -1, -1));
        panelRaiz.add(panelDerecha, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        lblCantidad = new JLabel();
        lblCantidad.setText("Cantidad");
        panelDerecha.add(lblCantidad, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        panelDerecha.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        tfCantidad = new JTextField("1");
        panelDerecha.add(tfCantidad, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        btnAnadir = new JButton();

        btnAnadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Objeto o = (Objeto) lstObjetos.getSelectedValue();
                String qty = tfCantidad.getText();
                ItemInventario.addItemToInv(o, p, Integer.parseInt(qty));
                AppController.inventarioPersonaje(p);
                ObjetoInventario.up = false;
                frame.dispose();
                ObjetoInventario.up = false;

                Popup.showOk("Objeto añadido", "Se ha añadido " + o.getNombre() + " x" + qty);
            }
        });

        btnAnadir.setText("Anadir");
        panelDerecha.add(btnAnadir, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        btnQuitar = new JButton();

        btnQuitar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Objeto o = (Objeto) lstObjetos.getSelectedValue();
                String qty = tfCantidad.getText();
                ItemInventario.removeItemFromInv(o, p, Integer.parseInt(qty));
                AppController.inventarioPersonaje(p);
                ObjetoInventario.up = false;
                frame.dispose();
                ObjetoInventario.up = false;

                Popup.showOk("Objeto quitado", "Se ha quitado " + o.getNombre() + " x" + qty);
            }
        });

        btnQuitar.setText("Quitar");
        panelDerecha.add(btnQuitar, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));




        frame.add(panelRaiz);
    }

}
