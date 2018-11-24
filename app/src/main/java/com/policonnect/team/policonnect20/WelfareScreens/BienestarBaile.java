package com.policonnect.team.policonnect20.WelfareScreens;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.policonnect.team.policonnect20.DataBase;
import com.policonnect.team.policonnect20.GeneralMethods;
import com.policonnect.team.policonnect20.Objects.DataBienestar;
import com.policonnect.team.policonnect20.R;

public class BienestarBaile extends Activity {

    private ImageButton mBackButton;
    private ImageView mHeaderColor;
    private TextView mNameScreen;
    private TextView mNameScreen2;
    private TextView mPlace;
    private TextView mProfessor;
    private TextView mSchedule;
    private DataBienestar datos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienestar);

        setViews();

        datos = DataBase.getWelfareActivity(1);

        mHeaderColor.setImageResource(R.color.colorRumba);
        mNameScreen.setText(datos.getName());
        mNameScreen2.setText(datos.getName());
        mPlace.setText(datos.getPlace());
        mProfessor.setText(datos.getTeacher());
        mSchedule.setText(GeneralMethods.welfareScheduleString(datos.getSchedule()));

        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void setViews() {
        mBackButton = findViewById(R.id.buttonBackBienestar);
        mHeaderColor = findViewById(R.id.headerColor);
        mNameScreen = findViewById(R.id.nameScreen);
        mNameScreen2 = findViewById(R.id.nameScreen2);
        mPlace = findViewById(R.id.place);
        mProfessor = findViewById(R.id.professor);
        mSchedule = findViewById(R.id.schedule);
    }
}
