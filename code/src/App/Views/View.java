package App.Views;

import App.AppController;

import javax.swing.*;
import java.awt.*;

public abstract class View {

    protected JPanel panel;

    public View(JFrame frame, String viewTitle) {
        frame.setTitle(viewTitle);
        this.panel = new JPanel();
        this.panel.setLayout(new BorderLayout());
    }

    public JPanel getPanel(){
        return this.panel;
    }
    public abstract JPanel render();

}
