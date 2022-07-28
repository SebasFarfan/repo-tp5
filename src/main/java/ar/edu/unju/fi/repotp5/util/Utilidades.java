package ar.edu.unju.fi.repotp5.util;

public class Utilidades {


    public boolean esNumero(String dato) {
        boolean numero = true;
        for (int i = 0; i < dato.length(); i++) {
            if (!Character.isDigit(dato.charAt(i))) {
                numero = false;
                break;
            }
        }
        return numero;
    }


    public boolean esNumeroValido(String dato) {
        boolean valido = false;
        if (!dato.isBlank()) {
            if (esNumero(dato)) {
                valido = true;
            }
        }
        return valido;
    }
}
