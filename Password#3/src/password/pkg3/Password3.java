package password.pkg3;

import java.util.Random;

public class Password3 {
    private int longitud;
    private boolean incluirNumeros;
    private boolean incluirLetras;
    private boolean incluirSimbolos;

    public Password3(int longitud, boolean incluirNumeros, boolean incluirLetras, boolean incluirSimbolos) {
        this.longitud = longitud;
        this.incluirNumeros = incluirNumeros;
        this.incluirLetras = incluirLetras;
        this.incluirSimbolos = incluirSimbolos;
    }

    public String generarContrasena() {
        String caracteres = "";
        if (incluirLetras) 
            caracteres += "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if (incluirNumeros) 
            caracteres += "0123456789";
        if (incluirSimbolos) 
            caracteres += "!@#$%^&*()_+";

        if (caracteres.isEmpty()) {
            return null; // No se puede generar contraseña si no se selecciona ningún tipo de carácter
        }

        StringBuilder contrasena = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < longitud; i++) {
            int indice = random.nextInt(caracteres.length());
            contrasena.append(caracteres.charAt(indice));
        }

        return contrasena.toString();
    }
}
