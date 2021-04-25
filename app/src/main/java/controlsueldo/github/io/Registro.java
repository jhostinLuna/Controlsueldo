package controlsueldo.github.io;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Registro implements Serializable {
    private LocalDateTime entrada;
    private LocalDateTime salida;

    private String nota;
    // Instancia actual fecha de calendario Gregoriano implantado en mayor parte del mundo
    public Registro() {
        entrada = LocalDateTime.now();
        salida = LocalDateTime.now();
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
    }

    public LocalDateTime getSalida() {
        return salida;
    }

    public void setSalida(LocalDateTime salida) {
        this.salida = salida;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    // Devuelve la fecha en formato dd/mm/yyyy
    public static String getFormatFecha(LocalDateTime date,String pattern) {
        DateTimeFormatter miDateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(miDateTimeFormatter);
    }

}
