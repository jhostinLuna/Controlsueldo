package controlsueldo.github.io;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TurnoNuevo extends AppCompatActivity implements View.OnClickListener {
    //clases donde se guardan los registros
    Registro rEntrada;
    Registro rSalida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turno_nuevo);
        Button fechaEntrada,horaEntrada,fechaSalida,horaSalida;
        // Inicio los botones y los escuchadores
        fechaEntrada = (Button) findViewById(R.id.btn_fecha_entrada);
        horaEntrada = (Button) findViewById(R.id.btn_hora_entrada);
        fechaSalida = (Button) findViewById(R.id.btn_fecha_salida);
        horaSalida = (Button) findViewById(R.id.btn_hora_salida);
        fechaEntrada.setOnClickListener(this);
        horaEntrada.setOnClickListener(this);
        fechaSalida.setOnClickListener(this);
        horaSalida.setOnClickListener(this);
        // Instancia las clases
        rEntrada = new Registro();
        rEntrada.setEntrada(Calendar.getInstance());
        rSalida = new Registro();
        rSalida.setSalida(Calendar.getInstance());
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_fecha_entrada:
                showDatePickerDialog(v.getId());
                break;
            case R.id.btn_hora_entrada:
                showTimePickerDialog(v.getId());
                break;
            case R.id.btn_fecha_salida:
                showDatePickerDialog(v.getId());
                break;
            case R.id.btn_hora_salida:
                showTimePickerDialog(v.getId());
                break;
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
                    nuevaFecha.set(year,month,dayOfMonth);
                    rEntrada.setEntrada(nuevaFecha);
                }else {
                    nuevaFecha = GregorianCalendar.getInstance();
                    nuevaFecha.set(year,month,dayOfMonth);
                    rSalida.setEntrada(nuevaFecha);
                }
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String cadena = String.valueOf(nuevaFecha.get(Calendar.DAY_OF_MONTH))+"/"+nuevaFecha.get(Calendar.MONTH)+"/"+String.valueOf(nuevaFecha.get(Calendar.YEAR));
                fecha.setText(sdf.format(nuevaFecha.getTime()));
            }
        });


        newFragment.show(getSupportFragmentManager(), "datePicker");


    }
    public void showTimePickerDialog(int idButton){
        TimePickerFragment newFragment = TimePickerFragment.newInstance(new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                final String selectTime = hourOfDay+" : "+minute;
                Button hora = findViewById(idButton);
                hora.setText(selectTime);
            }
        });
        newFragment.show(getSupportFragmentManager(),"timePicker");
    }
}