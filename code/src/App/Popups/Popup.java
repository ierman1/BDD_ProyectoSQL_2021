package App.Popups;

import javax.swing.*;

public abstract class Popup {

    public static void showError(String title, String message) {
        JOptionPane.showMessageDialog(new JFrame(), message, title, JOptionPane.ERROR_MESSAGE);
    }

    public static int showOk(String title, String message) {
        return JOptionPane.showConfirmDialog(new JFrame(), message, title, JOptionPane.OK_OPTION);
    }

    public static int showConfirm(String title, String message) {
        return JOptionPane.showConfirmDialog(new JFrame(), message, title, JOptionPane.OK_CANCEL_OPTION);
    }

}
