package App.Views;

import App.AppController;
import App.Models.ItemInventario;
import App.Models.Objeto;
import App.Models.Personaje;
import App.Popups.ObjetoInventario;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class InventarioPersonaje extends View{

    Personaje personaje;

    public InventarioPersonaje(JFrame frame, Personaje personaje) {
        super(frame, "Inventario "+ personaje.getNombre());
        this.personaje = personaje;
    }

    @Override
    public JPanel render() {
        $$$setupUI$$$();

        return this.panel;
    }


    private void $$$setupUI$$$() {
        JPanel panelBotones;
        JPanel panelSuperior;
        JScrollPane panelTabla;
        JScrollPane panelInformacion;
        JTable tblItems;
        JEditorPane taInformacion;
        JButton btnVolver;
        JButton btnAnadir;

        this.panel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        this.panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        panelBotones = new JPanel();
        panelBotones.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        this.panel.add(panelBotones, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        btnVolver = new JButton();
        btnVolver.setText("Volver");
        panelBotones.add(btnVolver, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        panelBotones.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        btnAnadir = new JButton();
        btnAnadir.setText("Gestionar");
        panelBotones.add(btnAnadir, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        panelSuperior = new JPanel();
        panelSuperior.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        this.panel.add(panelSuperior, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panelTabla = new JScrollPane();
        panelSuperior.add(panelTabla, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));

        panelInformacion = new JScrollPane();
        panelSuperior.add(panelInformacion, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(200, 300), null, null, 0, false));
        taInformacion = new JEditorPane("text/html", "");
        taInformacion.setEditable(false);
        panelInformacion.setViewportView(taInformacion);

        DefaultTableModel tableModel = new DefaultTableModel(new String[] {"#", "Objeto", "Cantidad"}, 0);

        for (ItemInventario item : ItemInventario.getItemsByPj(personaje)) {
            tableModel.addRow(new Object[] {item.getObjeto().getId(), item.getObjeto().getNombre(), item.getCantidad()});
        }

        tblItems = new JTable(tableModel);
        panelTabla.setViewportView(tblItems);
        tblItems.removeColumn(tblItems.getColumn("#"));

        btnVolver.addActionListener(e -> AppController.infoPersonaje(personaje));
        btnAnadir.addActionListener(e -> ObjetoInventario.show(personaje, this));

        tblItems.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                Objeto item = Objeto.getObjetoById(Integer.parseInt(tblItems.getModel().getValueAt(tblItems.getSelectedRow(), 0).toString()));
                String text = "<style>* { word-wrap: 'break-word'; font-family: 'Arial'; } h2 { font-size: 12px; margin: 0; } p { margin: 0; } hr { margin-top: 5px; margin-bottom: 5px; }</style> <div style='padding: 5px'><h2>Descripción<h2><p>" + item.getDesc() + "</p><hr><h2>Peso<h2><p>" + item.getPeso() + "</p><hr><h2>Valor<h2><p>" + item.getValor() + "</p></div>";
                taInformacion.setText(text);
            }
        });

    }

}
