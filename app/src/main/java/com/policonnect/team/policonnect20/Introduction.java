
package com.policonnect.team.policonnect20;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.policonnect.team.policonnect20.MainActivityFragments.MainActivity;

public class Introduction extends AppCompatActivity {
    private final int DURACION_SPLASH = 2000;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);
        mAuth = FirebaseAuth.getInstance();

        /**
         * Determina si el usuario esta logeado o no
         */
        new Handler().postDelayed(new Runnable() {
            public void run() {

                if (mAuth.getCurrentUser() != null) {
                    Intent intent = new Intent(Introduction.this, Login.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(Introduction.this, Login.class);
                    startActivity(intent);
                    finish();
                }

            }
        }, DURACION_SPLASH);
    }
}
