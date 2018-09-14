package com.policonnect.team.policonnect20;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class Dummy extends AppCompatActivity {
    private static long back_pressed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy);


    }

    /**
     * Este método asegura que el usuario salga de la aplicación cuando este oprima e botón "atrás" dos
     * veces con un lapso de tiempo de menos de 2 segundos.
     * Sobreescribe en metodo onBackPressed
     **/
    @Override
    public void onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis()) {
            System.exit(0);
        } else
            Toast.makeText(getBaseContext(), R.string.toast_backagain, Toast.LENGTH_SHORT).show();
        back_pressed = System.currentTimeMillis();
    }
}
