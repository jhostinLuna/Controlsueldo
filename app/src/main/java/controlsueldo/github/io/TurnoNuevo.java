package controlsueldo.github.io;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Pattern;

//View.OnclickListener es el escuchador de las vistas
public class TurnoNuevo extends AppCompatActivity implements View.OnClickListener {
    //clases donde se guardan los registros
    Registro cRegistro;
    @RequiresApi(api = Build.VERSION_CODES.O)
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

        fechaEntrada.setText(Registro.getFormatFecha(cRegistro.getEntrada(),"dd/MM/yyyy"));
        fechaSalida.setText(Registro.getFormatFecha(cRegistro.getSalida(),"dd/MM/yyyy"));
        horaEntrada.setText(Registro.getFormatFecha(cRegistro.getEntrada(),"hh:mm"));
        horaSalida.setText(Registro.getFormatFecha(cRegistro.getSalida(),"hh:mm"));
        Toast.makeText(this, "Son las: "+ LocalDateTime.now(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        // Recoge fecha y hora Entrada
        if (R.id.btn_fecha_entrada == v.getId()){
            showDatePickerDialog(v.getId());
        }else if (R.id.btn_hora_entrada == v.getId()) {
            showTimePickerDialog(v.getId());
        }

        //Recoge fecha y hora de salida
        else if (R.id.btn_fecha_salida == v.getId()){
            showDatePickerDialog(v.getId());
        }else if (R.id.btn_hora_salida == v.getId()){
            showTimePickerDialog(v.getId());
        }else if (R.id.btn_ltn_guardar == v.getId()) {//Si presiona boton guardar, lleva a BDD

        }

    }
    //Metodos particulares para crear el fragment Date
    private void showDatePickerDialog(int idButton) {
        //newInstance es mi metodo particular que uso para recoger el Listener de
        DatePickerFragment newFragment = DatePickerFragment.newInstance((view, year, month, dayOfMonth) -> {
            Button btnFecha = findViewById(idButton);

            //Instancio nuevaFecha con la fecha escogida por el usuario en DatePicker
            LocalDate nuevaFecha = LocalDate.of(year,month,dayOfMonth);
            // Si es la fecha de Entrada sigue..
            if(idButton == R.id.btn_fecha_entrada){

                cRegistro.setEntrada(LocalDateTime.of(nuevaFecha,cRegistro.getEntrada().toLocalTime()));
            }else {// Si no es la fecha de entrada tiene que ser la fecha de salida...
                cRegistro.setSalida(LocalDateTime.of(nuevaFecha,cRegistro.getSalida().toLocalTime()));
            }
            btnFecha.setText(Registro.getFormatFecha(nuevaFecha.atTime(LocalTime.now()),"dd/MM/yyyy"));
        });


        newFragment.show(getSupportFragmentManager(), "datePicker");


    }
    //Metodo particular para crear el fragment Time
    public void showTimePickerDialog(int idButton){
        TimePickerFragment newFragment = TimePickerFragment.newInstance((view, hourOfDay, minute) -> {
            Button btn_hora = findViewById(idButton);
            LocalTime nuevaHora = LocalTime.of(hourOfDay,minute);
            //si el boton es de entrada guarda hora en Entrada de cRegistro
            if(idButton == R.id.btn_hora_entrada){
                cRegistro.setEntrada(LocalDateTime.of(cRegistro.getEntrada().toLocalDate(),nuevaHora));
            }else {// Si es de Salida guarda en Salida de cRegistro
                cRegistro.setSalida(LocalDateTime.of(cRegistro.getSalida().toLocalDate(),nuevaHora));
            }
            btn_hora.setText(Registro.getFormatFecha(nuevaHora.atDate(LocalDate.now()),"hh:mm"));
        });
        newFragment.show(getSupportFragmentManager(),"timePicker");
    }

}