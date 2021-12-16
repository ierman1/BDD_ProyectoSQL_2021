package App.Components;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class ScrollablePanel extends JPanel
        implements Scrollable
{
    public Dimension getPreferredScrollableViewportSize()
    {
        return getPreferredSize();
    }

    public int getScrollableUnitIncrement(
            Rectangle visibleRect, int orientation, int direction)
    {
        return 20;
    }

    public int getScrollableBlockIncrement(
            Rectangle visibleRect, int orientation, int direction)
    {
        return 60;
    }

    public boolean getScrollableTracksViewportWidth()
    {
        return true;
    }

    public boolean getScrollableTracksViewportHeight()
    {
        return false;
    }
}
