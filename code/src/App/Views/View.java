package App.Views;

import javax.swing.*;
import java.awt.*;

public abstract class View {

    protected JFrame frame;
    protected JPanel panel;

    public View(JFrame frame, String viewTitle) {
        this.frame = frame;
        this.frame.setTitle(viewTitle);
        this.panel = new JPanel();
        this.panel.setLayout(new BorderLayout());
    }

    public abstract JPanel render();

}
