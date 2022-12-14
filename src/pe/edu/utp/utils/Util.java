package pe.edu.utp.utils;

public class Util {

    public String llenarCeros(String texto, int cantidad) {
        String ceros = "";
        cantidad = cantidad - texto.length();
        if (cantidad >= 1) {
            for (int i = 0; i < cantidad; i++) {
                ceros += "0";
            }
            return (ceros + texto);
        } else {
            return texto;
        }
    }
}
