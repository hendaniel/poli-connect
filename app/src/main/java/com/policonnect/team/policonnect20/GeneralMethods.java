package com.policonnect.team.policonnect20;

import android.app.Activity;
import android.util.Log;

import com.policonnect.team.policonnect20.Objects.DataBienestar;
import com.policonnect.team.policonnect20.Objects.Subject;
import com.policonnect.team.policonnect20.UserScreens.UsuarioHorario;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.TreeSet;

public class GeneralMethods {
    final static String[] daysNames = new String[]{"Lunes", "Martes", "Miercoles", "Jueves",
            "Viernes", "Sábado"};
    final static String[] hourStrings = new String[]{"7:00 - 8:30", "8:40 - 10:10",
            "10:20 - 11:50", "12:00 - 13:30", "13:40 - 15:10", "15:20 - 16:50", "17:00 - 18:30",
            "18:40 - 20:10", "20:20 - 21:50"};

    private static final String TAG = "GENERAL";

    public static int getRandomNumber(int n) {
        Random x = new Random();
        return x.nextInt(n) + 1;
    }

    public static int getRandomBackGroundLibrary() {
        int x = getRandomNumber(6);
        switch (x) {
            case 1:
                return R.drawable.background_lib01;
            case 2:
                return R.drawable.background_lib02;
            case 3:
                return R.drawable.background_lib03;
            case 4:
                return R.drawable.background_lib04;
            case 5:
                return R.drawable.background_lib06;
            case 6:
                return R.drawable.background_lib08;
            default:
                return R.drawable.background_lib01;
        }
    }


    public static String getWeekDayString(int x) {

        return daysNames[x];
    }

    public static String getBlockHour(int x) {

        return hourStrings[x];
    }

    public static String welfareScheduleString(TreeSet<Integer>[] horario) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < horario.length; i++)
            if (!horario[i].isEmpty()) {
                sb.append("\t\t" + daysNames[i] + ":\n");
                for (int j : horario[i])
                    sb.append("\t\t\t\t\t" + hourStrings[j] + "\n");
            }

        return sb.toString();
    }

    public static Subject getNextSubject() {
        ArrayList<Subject>[] horario = DataBase.getListDataUSchedule();

        if (horario != null && horario[0] != null) {
            Date date = new Date();
            int day = (date.getDay()+6)%7;
            int time = getTime(date.getHours(), date.getMinutes());

            Log.d(TAG, "||||||||||||***********|||||||||||  "+day+" "+time);
            for (int i = day; i < day + 6; i++)
                if (i == day) {
                    for (Subject j : horario[i % 6]) {
                        if (j.getTime() >= time) {
                            j.setName(j.getName() + Integer.toString(i % 6));
                            return j;
                        }
                    }
                } else {
                    for (Subject j : horario[i % 6]) {
                        j.setName(j.getName() + Integer.toString(i % 6));
                        return j;
                    }
                }

        }
        return new Subject("0", "-", 0);


    }

    private static int getTime(int h, int m) {

        if (h < 7 || h==7&&m < 0)
            return 0;
        if (h < 8 && h==8&&m < 40)
            return 1;
        if (h < 10 && h==10&&m < 20)
            return 2;
        if (h < 12 && h==12&&m < 0)
            return 3;
        if (h < 13 && h==13&&m < 40)
            return 4;
        if (h < 15 && h==15&&m < 20)
            return 5;
        if (h < 17 && h==17&&m < 0)
            return 6;
        if (h < 18 && h==18&&m < 40)
            return 7;
        if (h < 20 && h==20&&m < 20)
            return 8;

        return 20;

    }

}
