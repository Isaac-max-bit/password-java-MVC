package password.pkg3;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PasswordView view = new PasswordView();
            new PasswordController(view);
            view.setVisible(true);
        });
    }
}
