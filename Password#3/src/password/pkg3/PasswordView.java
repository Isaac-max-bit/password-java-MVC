package password.pkg3;

import javax.swing.*;
import java.awt.event.ActionListener;

public class PasswordView extends JFrame {
    private JTextField txtLongitud;
    private JCheckBox chkNumeros, chkLetras, chkSimbolos;
    private JTextField txtContrasena;
    private JButton btnGenerar;

    public PasswordView() {
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setTitle("Generador de Contraseña");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblLongitud = new JLabel("Longitud (entre 8 y 12 caracteres):");
        lblLongitud.setBounds(20, 20, 250, 30);
        add(lblLongitud);

        txtLongitud = new JTextField();
        txtLongitud.setBounds(250, 20, 50, 30);
        add(txtLongitud);

        chkNumeros = new JCheckBox("Incluye Números?");
        chkNumeros.setBounds(20, 60, 200, 30);
        add(chkNumeros);

        chkLetras = new JCheckBox("Incluye Letras?");
        chkLetras.setBounds(20, 90, 200, 30);
        add(chkLetras);

        chkSimbolos = new JCheckBox("Incluye Símbolos?");
        chkSimbolos.setBounds(20, 120, 200, 30);
        add(chkSimbolos);

        JLabel lblContrasena = new JLabel("Contraseña Generada:");
        lblContrasena.setBounds(20, 160, 200, 30);
        add(lblContrasena);

        txtContrasena = new JTextField();
        txtContrasena.setBounds(20, 190, 300, 30);
        txtContrasena.setEditable(false);
        add(txtContrasena);

        btnGenerar = new JButton("Generar Contraseña");
        btnGenerar.setBounds(20, 230, 200, 30);
        add(btnGenerar);
    }

    public void setGenerarContrasenaListener(ActionListener listener) {
        btnGenerar.addActionListener(listener);
    }

    public int getLongitud() throws NumberFormatException {
        return Integer.parseInt(txtLongitud.getText());
    }

    public boolean isIncluirNumeros() {
        return chkNumeros.isSelected();
    }

    public boolean isIncluirLetras() {
        return chkLetras.isSelected();
    }

    public boolean isIncluirSimbolos() {
        return chkSimbolos.isSelected();
    }

    public void setContrasena(String contrasena) {
        txtContrasena.setText(contrasena);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}
