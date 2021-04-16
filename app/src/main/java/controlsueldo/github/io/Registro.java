package controlsueldo.github.io;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Registro {
    private Calendar entrada;
    private Calendar salida;

    private String nota;
    // Instancia actual fecha de calendario Gregoriano implantado en mayor parte del mundo
    public Registro() {
        entrada = GregorianCalendar.getInstance();
        salida = GregorianCalendar.getInstance();
    }

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

    // Devuelve la fecha en formato dd/mm/yyyy
    public static String getFormatFecha(Calendar fecha,String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, new Locale("es","ES"));
        //String cadena = String.valueOf(nuevaFecha.get(Calendar.DAY_OF_MONTH))+"/"+nuevaFecha.get(Calendar.MONTH)+"/"+String.valueOf(nuevaFecha.get(Calendar.YEAR));
        return sdf.format(fecha.getTime());
    }
}
