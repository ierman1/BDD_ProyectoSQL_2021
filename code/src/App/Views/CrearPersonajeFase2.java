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

    public JComboBox ComboBoxRaza;
    public JComboBox comboBoxSubRaza;
    private JButton btnSiguiente;
    private JButton btnVolver;
    private JTextArea textAreaDescripcion;
    private JLabel lblRaza;
    private JLabel lblSubRaza;
    private JLabel lblDesc;
    private JLabel lblIdiomas;
    private JLabel lblVelocidadAPie;
    private JLabel lblVentajasTitle;
    private JLabel lblVentajasValue;

    public JPanel render() {



        // Mostrar el contenido

        this.panel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        this.panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 1, new Insets(0, 0, 0, 0), -1, -1));
        this.panel.add(panel2, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        ComboBoxRaza = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        ComboBoxRaza.setModel(defaultComboBoxModel1);
        panel2.add(ComboBoxRaza, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lblRaza = new JLabel();
        lblRaza.setText("Raza");
        panel2.add(lblRaza, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lblSubRaza = new JLabel();
        lblSubRaza.setText("Subraza");
        panel2.add(lblSubRaza, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBoxSubRaza = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel2 = new DefaultComboBoxModel();
        comboBoxSubRaza.setModel(defaultComboBoxModel2);
        panel2.add(comboBoxSubRaza, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        final JPanel panel3 = new JPanel();
        panel3.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        this.panel.add(panel3, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_SOUTH, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        btnSiguiente = new JButton();
        btnSiguiente.setText("Siguiente");
        panel3.add(btnSiguiente, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        panel3.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        btnVolver = new JButton();
        btnVolver.setText("Volver");
        panel3.add(btnVolver, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(9, 2, new Insets(0, 0, 0, 0), -1, -1));
        this.panel.add(panel4, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        lblDesc = new JLabel();
        lblDesc.setText("Descripción");
        panel4.add(lblDesc, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textAreaDescripcion = new JTextArea();
        textAreaDescripcion.setEditable(false);
        panel4.add(textAreaDescripcion, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        final JPanel panel5 = new JPanel();
        panel5.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel4.add(panel5, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("");
        panel5.add(label1, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        panel5.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        lblIdiomas = new JLabel();
        lblIdiomas.setText("Idiomas");
        panel5.add(lblIdiomas, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel6 = new JPanel();
        panel6.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel4.add(panel6, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Velocidad a pie");
        panel6.add(label2, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer3 = new com.intellij.uiDesigner.core.Spacer();
        panel6.add(spacer3, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        lblVelocidadAPie = new JLabel();
        lblVelocidadAPie.setText("");
        panel6.add(lblVelocidadAPie, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer4 = new com.intellij.uiDesigner.core.Spacer();
        panel4.add(spacer4, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));

        final com.intellij.uiDesigner.core.Spacer spacer5 = new com.intellij.uiDesigner.core.Spacer();
        panel4.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer6 = new com.intellij.uiDesigner.core.Spacer();
        panel4.add(spacer3, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));

        lblVentajasTitle = new JLabel();
        lblVentajasTitle.setText("Ventajas");
        panel4.add(lblVentajasTitle, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lblVentajasValue = new JLabel();
        lblVentajasValue.setText("");
        panel4.add(lblVentajasValue, new com.intellij.uiDesigner.core.GridConstraints(8, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        //codigo mio



        textAreaDescripcion.setMaximumSize(new Dimension(150, 50));
        textAreaDescripcion.setLineWrap(true);
        textAreaDescripcion.setWrapStyleWord(true);
        Dimension maxArea = new Dimension(250, 100);
        textAreaDescripcion.setPreferredSize(maxArea);
        textAreaDescripcion.setMaximumSize(maxArea);
        textAreaDescripcion.setMinimumSize(maxArea);
        textAreaDescripcion.setLineWrap(true);
        textAreaDescripcion.setWrapStyleWord(true);

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
                textAreaDescripcion.setText(selectedRaza.getDescripcion());
                lblVelocidadAPie.setText(Integer.toString( selectedRaza.getVelocidadAPie() ));
                label1.setText(selectedRaza.getIdiomas());
                lblVentajasValue.setText(selectedRaza.getVentajas());
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

                textAreaDescripcion.setText(selectedSubRaza.getDescripcion());
                lblVelocidadAPie.setText(Integer.toString( selectedSubRaza.getVelocidadAPie() ));
                label1.setText(selectedSubRaza.getIdiomas());
                lblVentajasValue.setText(selectedRaza.getVentajas());
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

