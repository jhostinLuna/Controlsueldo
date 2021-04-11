package controlsueldo.github.io;

import java.util.Calendar;

public class Registro {
    private Calendar entrada;
    private Calendar salida;

    private String nota;
    public Registro() {}

    public Registro(Calendar entrada, Calendar salida, String nota) {
        this.entrada = entrada;
        this.salida = salida;
        this.nota = nota;
    }

    public Calendar getEntrada() {
        return entrada;
    }

    public void setEntrada(Calendar entrada) {
        this.entrada = entrada;
    }

    public Calendar getSalida() {
        return salida;
    }

    public void setSalida(Calendar salida) {
        this.salida = salida;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
}
