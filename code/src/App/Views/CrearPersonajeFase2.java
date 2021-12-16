package App.Views;

import App.AppController;
import App.Models.Personaje;
import App.Models.Raza;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CrearPersonajeFase2 extends View {

    public CrearPersonajeFase2(JFrame frame) {
        super(frame, "Crear personaje - Elige raza");
    }

    private Raza selectedRaza;
    private Raza selectedSubRaza;
    private ArrayList<Raza> razaList = (ArrayList<Raza>) Raza.getList();

    private JPanel panelForm;
    private JPanel panelBotones;
    private JButton btnVolver;
    private JButton btnSiguiente;
    private JPanel panelSelects;
    private JScrollPane panelInfo;
    private JEditorPane epInfo;
    private JLabel lblRaza;
    private JComboBox ComboBoxRaza;
    private JLabel lblSubRaza;
    private JComboBox comboBoxSubRaza;

    public JPanel render() {



        // Mostrar el contenido

        JPanel panelRaiz = this.panel;
        panelRaiz.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        panelRaiz.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));

        panelForm = new JPanel();
        panelForm.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        panelRaiz.add(panelForm, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panelSelects = new JPanel();
        panelSelects.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(5, 1, new Insets(0, 0, 0, 0), -1, -1));
        panelForm.add(panelSelects, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        lblRaza = new JLabel();
        lblRaza.setText("Raza");
        panelSelects.add(lblRaza, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        panelSelects.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        ComboBoxRaza = new JComboBox();
        panelSelects.add(ComboBoxRaza, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lblSubRaza = new JLabel();
        lblSubRaza.setText("Label");
        panelSelects.add(lblSubRaza, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBoxSubRaza = new JComboBox();
        panelSelects.add(comboBoxSubRaza, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));


        panelInfo = new JScrollPane();
        panelForm.add(panelInfo, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(600, 300), null, null, 0, false));
        epInfo = new JEditorPane("text/html", "");
        panelInfo.setViewportView(epInfo);

        panelBotones = new JPanel();
        panelBotones.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panelRaiz.add(panelBotones, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_SOUTH, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        btnVolver = new JButton();
        btnVolver.setText("Volver");
        panelBotones.add(btnVolver, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        panelBotones.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        btnSiguiente = new JButton();
        btnSiguiente.setText("Siguiente");
        panelBotones.add(btnSiguiente, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));



        //codigo mio


        //fix

        comboBoxSubRaza.setVisible(false);
        lblSubRaza.setVisible(false);

        ComboBoxRaza.setSelectedIndex(-1);
        ComboBoxRaza.addItem("");

        for (Raza r : Raza.getList() ){
            if(r.getIdRazaPadre() == 0) {
                ComboBoxRaza.addItem(r.getNombre());
            }
        }

        ComboBoxRaza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String rName = (String)ComboBoxRaza.getSelectedItem();


                comboBoxSubRaza.removeAllItems();
                selectedSubRaza = null;

                for (Raza r : razaList ) {
                    if (r.getNombre().equals(rName)) {
                        selectedRaza = r;
                    }
                }

                for (Raza subr : Raza.getSubrazas(selectedRaza.getId()) ){
                    comboBoxSubRaza.addItem(subr.getNombre());
                }


                if(comboBoxSubRaza.getItemCount() != 0){
                    comboBoxSubRaza.setVisible(true);
                    lblSubRaza.setVisible(true);
                }else{

                    comboBoxSubRaza.setVisible(false);
                    lblSubRaza.setVisible(false);
                }

                //falta populate stats
                String text = "<style>* { word-wrap: 'break-word'; font-family: 'Arial'; } h2 { font-size: 12px; margin: 0; } p { margin: 0; } " +
                        "hr { margin-top: 5px; margin-bottom: 5px; }</style> <div style='padding: 5px'>" +
                        "<h2>Descripción<h2><p>" + selectedRaza.getDescripcion() + "</p><hr>" +
                        "<h2>Velocidad a pie<h2><p>" + Integer.toString( selectedRaza.getVelocidadAPie()) + "</p><hr>" +
                        "<h2>Idiomas<h2><p>" + selectedRaza.getIdiomas() + "</p><hr>" +
                        "<h2>Ventajas<h2><p>" + selectedRaza.getVentajas() + "</p>" +
                        "</div>";
                epInfo.setText(text);
            }
        });


        comboBoxSubRaza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String srName = (String)comboBoxSubRaza.getSelectedItem();

                for (Raza r : razaList ) {
                    if (r.getNombre().equals(srName)) {
                        selectedSubRaza = r;
                    }
                }

                String text = "<style>* { word-wrap: 'break-word'; font-family: 'Arial'; } h2 { font-size: 12px; margin: 0; } p { margin: 0; } " +
                        "hr { margin-top: 5px; margin-bottom: 5px; }</style> <div style='padding: 5px'>" +
                        "<h2>Descripción<h2><p>" + selectedRaza.getDescripcion() + "<br>" + selectedSubRaza.getDescripcion() + "</p><hr>" +
                        "<h2>Velocidad a pie<h2><p>" + Integer.toString( selectedRaza.getVelocidadAPie()) + "</p><hr>" +
                        "<h2>Idiomas<h2><p>" + selectedRaza.getIdiomas() + "</p><hr>" +
                        "<h2>Ventajas<h2><p>" + selectedRaza.getVentajas() + "</p>" +
                        "</div>";
                epInfo.setText(text);
            }
        });





        loadCache();

        // Eventos
        btnVolver.addActionListener(e -> {
            saveCache();
            AppController.crearPersonaje();
        });
        btnSiguiente.addActionListener(e -> {
            saveCache();
            AppController.crearPersonajeFase3();
        });



        return this.panel;
    }

    private void saveCache() {

        //cojo el personaje CACHE
        Personaje p = Personaje.newPesonaje;

        if(selectedSubRaza != null){
            p.setRaza(selectedSubRaza);
        }else{
            p.setRaza(selectedRaza);
        }

    }

    private void loadCache() {

        //cojo el personaje CACHE
        Personaje p = Personaje.newPesonaje;

        Raza r = p.getRaza();
        if(r == null) return;
        if(r.getId() == 0) return;

        if(r.getIdRazaPadre() == 0){
            //es de una raza sin subrazas
            ComboBoxRaza.setSelectedItem(r.getNombre());
        }else{
            //tiene subraza, asi que seteo combobox padre y hijo

            for (Raza raza : razaList ) {
                if (raza.getId() == r.getIdRazaPadre()) {
                    ComboBoxRaza.setSelectedItem(raza.getNombre());
                }
            }

            comboBoxSubRaza.setSelectedItem(r.getNombre());
        }


    }

}

