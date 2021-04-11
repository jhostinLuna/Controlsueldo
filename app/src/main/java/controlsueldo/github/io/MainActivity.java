package controlsueldo.github.io;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button nuevoTurno = findViewById(R.id.btn_nuevo_turno);
        nuevoTurno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNuevaEntrada = new Intent(getApplicationContext(), TurnoNuevo.class);
                startActivity(intentNuevaEntrada);

            }
        });

    }

}