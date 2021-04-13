package controlsueldo.github.io;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TurnoNuevo extends AppCompatActivity implements View.OnClickListener {
    //clases donde se guardan los registros
    Registro cRegistro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turno_nuevo);
        Button fechaEntrada,horaEntrada,fechaSalida,horaSalida;
        // Inicio los botones y los escuchadores
        fechaEntrada = findViewById(R.id.btn_fecha_entrada);
        horaEntrada = findViewById(R.id.btn_hora_entrada);
        fechaSalida = findViewById(R.id.btn_fecha_salida);
        horaSalida = findViewById(R.id.btn_hora_salida);
        fechaEntrada.setOnClickListener(this);
        horaEntrada.setOnClickListener(this);
        fechaSalida.setOnClickListener(this);
        horaSalida.setOnClickListener(this);
        // Instancia las clases
        cRegistro = new Registro();
        cRegistro.setEntrada(Calendar.getInstance());
        cRegistro.setSalida(Calendar.getInstance());
    }

    @Override
    public void onClick(View v) {

        if (R.id.btn_fecha_entrada == v.getId()){
            showDatePickerDialog(v.getId());
        }else if (R.id.btn_hora_entrada == v.getId()) {
            showTimePickerDialog(v.getId());
        }
        else if (R.id.btn_fecha_salida == v.getId()){
            showDatePickerDialog(v.getId());
        }else if (R.id.btn_hora_salida == v.getId()){
            showTimePickerDialog(v.getId());
        }

    }
    private void showDatePickerDialog(int idButton) {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            Calendar nuevaFecha;
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Button fecha = findViewById(idButton);
                if(idButton == R.id.btn_fecha_entrada){
                    nuevaFecha = Calendar.getInstance();
                    nuevaFecha.set(year,month,dayOfMonth,cRegistro.getEntrada().get(Calendar.HOUR_OF_DAY),cRegistro.getEntrada().get(Calendar.HOUR));
                    cRegistro.setEntrada(nuevaFecha);
                }else {
                    nuevaFecha = GregorianCalendar.getInstance();
                    nuevaFecha.set(year,month,dayOfMonth,cRegistro.getSalida().get(Calendar.HOUR_OF_DAY),cRegistro.getSalida().get(Calendar.HOUR));
                    cRegistro.setSalida(nuevaFecha);
                }
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                //String cadena = String.valueOf(nuevaFecha.get(Calendar.DAY_OF_MONTH))+"/"+nuevaFecha.get(Calendar.MONTH)+"/"+String.valueOf(nuevaFecha.get(Calendar.YEAR));
                fecha.setText(sdf.format(nuevaFecha.getTime()));
            }
        });


        newFragment.show(getSupportFragmentManager(), "datePicker");


    }
    public void showTimePickerDialog(int idButton){
        TimePickerFragment newFragment = TimePickerFragment.newInstance(new TimePickerDialog.OnTimeSetListener() {
            Calendar nuevaHora;
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Button hora = findViewById(idButton);

                if(idButton == R.id.btn_hora_entrada){
                    nuevaHora = Calendar.getInstance();
                    nuevaHora.set(
                            cRegistro.getEntrada().get(Calendar.YEAR),
                            cRegistro.getEntrada().get(Calendar.MONTH),
                            cRegistro.getEntrada().get(Calendar.DAY_OF_MONTH),
                            hourOfDay,
                            minute);
                    cRegistro.setEntrada(nuevaHora);
                }else {
                    nuevaHora = GregorianCalendar.getInstance();
                    nuevaHora.set(
                            cRegistro.getSalida().get(Calendar.YEAR),
                            cRegistro.getSalida().get(Calendar.MONTH),
                            cRegistro.getSalida().get(Calendar.DAY_OF_MONTH),
                            hourOfDay,
                            minute);
                    cRegistro.setSalida(nuevaHora);
                }
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
                //String cadena = String.valueOf(nuevaFecha.get(Calendar.DAY_OF_MONTH))+"/"+nuevaFecha.get(Calendar.MONTH)+"/"+String.valueOf(nuevaFecha.get(Calendar.YEAR));
                hora.setText(sdf.format(nuevaHora.getTime()));
            }
        });
        newFragment.show(getSupportFragmentManager(),"timePicker");
    }
}