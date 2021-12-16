package App.Views;

import App.AppController;
import App.Models.Clase;
import App.Models.Personaje;
import App.Models.Raza;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CrearPersonajeFase3 extends View {

    public CrearPersonajeFase3(JFrame frame) {
        super(frame, "Crear personaje - Elige clase");
    }

    private Clase selectedClase;
    private ArrayList<Clase> claseList = (ArrayList<Clase>) Clase.getList();

    private JComboBox comboBoxClass;

    public JPanel render() {

        JButton btnSiguiente;
        JButton btnVolver;

        JEditorPane epInfo;
        JScrollPane panelInfo;

        // Mostrar el contenido
        JPanel panelRaiz = this.panel;

        panelRaiz.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        panelRaiz.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));

        //izq+derecha
        final JPanel panel2 = new JPanel();

        panel2.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(10, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        panelRaiz.add(panel2, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));


        final JPanel panelIzq = new JPanel();

        panelIzq.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel2.add(panelIzq, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 10, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, new Dimension(200, -1), null, null, 0, false));
        final JLabel labelClase = new JLabel();
        labelClase.setText("Clase");
        panelIzq.add(labelClase, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        panelIzq.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        panelIzq.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        comboBoxClass = new JComboBox();
        panelIzq.add(comboBoxClass, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        panelInfo = new JScrollPane();
        panel2.add(panelInfo, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(550, 270), null, null, 0, false));
        epInfo = new JEditorPane("text/html", "");

        panelInfo.setViewportView(epInfo);



        //panelbotones
        final JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panelRaiz.add(panelBotones, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_SOUTH, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        btnSiguiente = new JButton();
        btnSiguiente.setText("Siguiente");
        panelBotones.add(btnSiguiente, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer7 = new com.intellij.uiDesigner.core.Spacer();
        panelBotones.add(spacer7, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        btnVolver = new JButton();
        btnVolver.setText("Volver");
        panelBotones.add(btnVolver, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));


        //codigo mio
        comboBoxClass.setSelectedIndex(-1);

        for (Clase c : claseList) {
            comboBoxClass.addItem(c.getNombre());
        }

        comboBoxClass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cName = (String) comboBoxClass.getSelectedItem();

                for (Clase c : claseList) {
                    if (c.getNombre().equals(cName)) {
                        selectedClase = c;
                    }
                }


                String text = "<style>* { word-wrap: 'break-word'; font-family: 'Arial'; } h2 { font-size: 12px; margin: 0; } p { margin: 0; } " +
                        "hr { margin-top: 5px; margin-bottom: 5px; }</style> <div style='padding: 5px'>" +
                        "<h2>Descripción<h2><p>" + selectedClase.getDescripcion() + "</p><hr>" +
                        "<h2>Dado vida<h2><p>" + selectedClase.getDadoVida() + "</p><hr>" +
                        "<h2>Dado de salvación<h2><p>" + selectedClase.getSalvacion1() + "</p><hr>" +
                        "<h2>Hechizos de esta clase<h2><p>" + Clase.getHechizosDeClase(selectedClase.getNombre()) + "</p><hr>" +
                        "</div>";
                epInfo.setText(text);

            }
        });


        loadCache();

        // Eventos
        btnVolver.addActionListener(e -> {
            saveCache();
            AppController.crearPersonajeFase2();
        });
        btnSiguiente.addActionListener(e -> {
            saveCache();
            AppController.crearPersonajeFase4();
        });


        return this.panel;
    }

    private void saveCache() {

        //cojo el personaje CACHE
        Personaje p = Personaje.newPesonaje;

        if (selectedClase != null) {
            p.setClase(selectedClase);
        }
    }

    private void loadCache() {

        //cojo el personaje CACHE
        Personaje p = Personaje.newPesonaje;

        Clase c = p.getClase();
        if (c == null) return;
        if (c.getId() == 0) return;

        comboBoxClass.setSelectedItem(c.getNombre());
    }
}

