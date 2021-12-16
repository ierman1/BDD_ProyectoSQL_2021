package App.Popups;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class RegistroConsultas {

    private JTextArea taConsultas;

    public RegistroConsultas() {
        JFrame frame = new JFrame("Registro");
        frame.setSize(400, 200);
        frame.setVisible(true);

        JPanel panelRaiz;
        JScrollPane scrollConsultas;

        panelRaiz = new JPanel();
        panelRaiz.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panelRaiz.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        scrollConsultas = new JScrollPane();
        panelRaiz.add(scrollConsultas, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        taConsultas = new JTextArea();
        taConsultas.setEditable(false);
        scrollConsultas.setViewportView(taConsultas);

        frame.add(panelRaiz);

        frame.repaint();
        frame.revalidate();
    }

    public void nuevaLinea(String consulta) {
        taConsultas.setText(taConsultas.getText() + consulta + "\n");
    }

}
