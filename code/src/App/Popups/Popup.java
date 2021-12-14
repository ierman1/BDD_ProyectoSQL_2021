package App.Popups;

import javax.swing.*;

public abstract class Popup {

    public static void showError(String title, String message) {
        JOptionPane.showMessageDialog(new JFrame(), message, title, JOptionPane.ERROR_MESSAGE);
    }

    public static void showOk(String title, String message) {
        JOptionPane.showConfirmDialog(new JFrame(), message, title, JOptionPane.YES_OPTION);
    }

    public static int showConfirm(String title, String message) {
        return JOptionPane.showConfirmDialog(new JFrame(), message, title, JOptionPane.OK_CANCEL_OPTION);
    }

}
