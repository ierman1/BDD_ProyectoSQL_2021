package App.Views.Components;

import javax.swing.*;
import java.awt.*;

public class TextArea extends JPanel {

    private JLabel label;
    private JTextArea textArea;

    public TextArea(String name) {
        this.label = new JLabel(name);
        this.textArea = new JTextArea();

        this.setLayout(new GridLayout(2, 1));
        this.add(this.label);
        this.add(this.textArea);
    }

    public JLabel getLabel() {
        return label;
    }

    public JTextArea getTextArea() {
        return textArea;
    }
    
}
