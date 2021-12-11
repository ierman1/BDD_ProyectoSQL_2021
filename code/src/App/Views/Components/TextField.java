package App.Views.Components;

import javax.swing.*;
import java.awt.*;

public class TextField extends JPanel {

    private JLabel label;
    private JTextField field;

    public TextField(String name) {
        this.label = new JLabel(name);
        this.field = new JTextField();

        this.setLayout(new GridLayout(2, 1));
        this.add(this.label);
        this.add(this.field);
    }

    public JLabel getLabel() {
        return label;
    }

    public JTextField getField() {
        return field;
    }

}
