package App.Views;

import App.AppController;
import App.Models.Hechizos;
import App.Models.ItemInventario;
import App.Models.Personaje;
import App.Popups.AprenderHechizos;

import javax.swing.*;
import java.awt.*;

public class HechizosPersonaje extends View{
    private JList spellList;
    private JButton volverBtn;
    private JButton anadirButton;
    Personaje personaje;
    public HechizosPersonaje(JFrame frame, Personaje personaje) {
        super(frame, "Hechizos "+ personaje.getNombre());
        this.personaje = personaje;
    }


    @Override
    public JPanel render() {
        $$$setupUI$$$();
        volverBtn.addActionListener(e -> AppController.infoPersonaje(personaje));
        anadirButton.addActionListener(e -> AprenderHechizos.show(personaje, this));
        return this.panel;
    }

    public void setItemList(JList itemList) {
        this.spellList = itemList;

        this.getPanel().repaint();
        this.getPanel().revalidate();
        this.getPanel().updateUI();
    }
    public JList getItemList() {
        return this.spellList;
    }

    private void $$$setupUI$$$() {
        this.panel = new JPanel();
        this.panel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        this.panel.add(panel2, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        spellList = new JList(Hechizos.getHechizosByPersonaje(personaje).toArray());

        JScrollPane scrollLista = new JScrollPane();
        scrollLista.setViewportView(spellList);

        panel2.add(scrollLista, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        volverBtn = new JButton();
        volverBtn.setText("Volver");
        panel2.add(volverBtn, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        anadirButton = new JButton();
        anadirButton.setText("Anadir");
        panel2.add(anadirButton, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
    }
}
