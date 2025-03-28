package password.pkg3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordController {
    private PasswordView view;
    private Password3 model;

    public PasswordController(PasswordView view) {
        this.view = view;
        this.view.setGenerarContrasenaListener(new GenerarContrasenaListener());
    }

    class GenerarContrasenaListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int longitud = view.getLongitud();
                if (longitud < 8 || longitud > 12) {
                    view.mostrarMensaje("La longitud debe estar entre 8 y 12 caracteres.");
                    return;
                }

                boolean incluirNumeros = view.isIncluirNumeros();
                boolean incluirLetras = view.isIncluirLetras();
                boolean incluirSimbolos = view.isIncluirSimbolos();

                // Check if at least one checkbox is selected
                if (!incluirNumeros && !incluirLetras && !incluirSimbolos) {
                    view.mostrarMensaje("Debe seleccionar al menos un tipo de carácter (números, letras o símbolos).");
                    return;
                }

                // Create the model object
                model = new Password3(longitud, incluirNumeros, incluirLetras, incluirSimbolos);
                String contrasena = model.generarContrasena();

                if (contrasena == null) {
                    view.mostrarMensaje("No se pudo generar la contraseña. Verifique los parámetros.");
                } else {
                    view.setContrasena(contrasena);
                }
            } catch (NumberFormatException ex) {
                view.mostrarMensaje("Por favor, ingrese un número válido para la longitud.");
            }
        }
    }
}
