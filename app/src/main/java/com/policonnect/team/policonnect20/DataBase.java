package com.policonnect.team.policonnect20;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.policonnect.team.policonnect20.Objects.Notas;
import com.policonnect.team.policonnect20.Objects.Servicio;
import com.policonnect.team.policonnect20.Objects.Subject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Esta clase maneja el almacenamiento de cada uno de los datos que el usuario tiene permitido ver.
 * Aqui se obtienen todos los datos que existen en la base de datos.
 *
 * @version 1
 * @author: PoliConnect Team
 */
public class DataBase {

    private DatabaseReference mDatabase;
    private static ArrayList<Servicio> listDataBComputer;
    private static ArrayList<Servicio> listDataBStudy;
    private static ArrayList<Servicio> listDataBVideo;
    private static ArrayList<Notas> listDataUGrades;
    private static ArrayList<Subject>[] listDataUSchedule;
    private static DataBase dataBase;
    private String cubiculo = "Cubículo";


    private String computador = "Computador";

    public DataBase() {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        setBComputerData();
        setBStudyData();
        setBVideoData();
        setUGradesData();
        setUScheduleData();
    }

    /**
     * Crea la base de datos
     *
     * @return La base de datos
     */
    public static DataBase enableDataBase() {
        if (dataBase == null) {
            dataBase = new DataBase();
        }
        return dataBase;
    }

    /**
     * @return Los datos correspondientes a los computadores disponibles.
     */
    private void setBComputerData() {

        listDataBComputer = new ArrayList<>();
        mDatabase.child("COMPUTER").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                GenericTypeIndicator<List<Servicio>> genericTypeIndicator =new GenericTypeIndicator<List<Servicio>>(){};
                List<Servicio> computerList = dataSnapshot.getValue(genericTypeIndicator);

                for(int i = 0; i < computerList.size(); i++){
                    listDataBComputer.add(computerList.get(i));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
       /* for (int i = 0; i < 40; i += 5) {
            listDataBComputer.add(new Servicio(computador, 1 + i, true, false));
            listDataBComputer.add(new Servicio(computador, 2 + i, true, false));
            listDataBComputer.add(new Servicio(computador, 3 + i, false, false));
            listDataBComputer.add(new Servicio(computador, 4 + i, false, false));
            listDataBComputer.add(new Servicio(computador, 5 + i, true, false));
        }
        */
    }

    /**
     * @return Los datos correspondientes a los cubículos de estudio disponibles.
     */
    private void setBStudyData() {
        listDataBStudy = new ArrayList<>();
        listDataBStudy.add(new Servicio(cubiculo, 1, true, true));
        listDataBStudy.add(new Servicio(cubiculo, 2, true, true));
        listDataBStudy.add(new Servicio(cubiculo, 3, false, true));
        listDataBStudy.add(new Servicio(cubiculo, 4, true, true));
        listDataBStudy.add(new Servicio(cubiculo, 5, true, true));
        listDataBStudy.add(new Servicio(cubiculo, 6, false, true));
        listDataBStudy.add(new Servicio(cubiculo, 7, true, true));
        listDataBStudy.add(new Servicio(cubiculo, 8, false, false));
        listDataBStudy.add(new Servicio(cubiculo, 9, false, false));
        listDataBStudy.add(new Servicio(cubiculo, 10, false, true));
        listDataBStudy.add(new Servicio(cubiculo, 11, true, false));
        listDataBStudy.add(new Servicio(cubiculo, 12, true, false));
        listDataBStudy.add(new Servicio(cubiculo, 13, false, true));
        listDataBStudy.add(new Servicio(cubiculo, 14, false, false));
        listDataBStudy.add(new Servicio(cubiculo, 15, true, false));
        listDataBStudy.add(new Servicio(cubiculo, 16, true, true));
    }

    /**
     * @return Los datos correspondientes a los cubículos de video.
     */
    private void setBVideoData() {
        listDataBVideo = new ArrayList<>();
        listDataBVideo.add(new Servicio(cubiculo, 1, true, true));
        listDataBVideo.add(new Servicio(cubiculo, 2, true, false));
        listDataBVideo.add(new Servicio(cubiculo, 3, false, false));
        listDataBVideo.add(new Servicio(cubiculo, 4, false, false));
        listDataBVideo.add(new Servicio(cubiculo, 5, true, false));
    }

    /**
     * @return Los datos correspondientes a las notas del usuario.
     */
    private void setUGradesData() {
        listDataUGrades = new ArrayList<>();
        listDataUGrades.add(new Notas("Matemática", 4.8, 161));
        listDataUGrades.add(new Notas("Algebra", 3.0, 162));
        listDataUGrades.add(new Notas("Publicidad", 2.98, 181));
        listDataUGrades.add(new Notas("Introducción a la Ingeniería", 3.0, 181));
        listDataUGrades.add(new Notas("Francés I", 2.98, 181));
        listDataUGrades.add(new Notas("Probabilidad", 3.0, 181));
        listDataUGrades.add(new Notas("Estructura de Datos", 2.98, 181));
        listDataUGrades.add(new Notas("Física I", 3.0, 181));
        listDataUGrades.add(new Notas("Cálculo I", 4.98, 162));
        listDataUGrades.add(new Notas("Cálculo II", 3.0, 171));
        listDataUGrades.add(new Notas("Cálculo III", 2.98, 172));
        listDataUGrades.add(new Notas("Bases de Datos", 3.0, 181));
        listDataUGrades.add(new Notas("Programación de Computadores", 5.0, 162));
        listDataUGrades.add(new Notas("Lecto-Escritura", 3.0, 181));
    }

    private void setUScheduleData() {
        listDataUSchedule = new ArrayList[6];

        for (int i = 0; i < listDataUSchedule.length; i++)
            listDataUSchedule[i] = new ArrayList<Subject>();

        listDataUSchedule[1].add(new Subject("Francés I", 0));
        listDataUSchedule[1].add(new Subject("Probabilidad", 6));
        listDataUSchedule[1].add(new Subject("Circuitos Lógicos", 4));
        listDataUSchedule[1].add(new Subject("Circuitos Lógicos", 5));

        listDataUSchedule[3].add(new Subject("Francés I", 0));
        listDataUSchedule[3].add(new Subject("Circuitos Lógicos", 5));

        listDataUSchedule[4].add(new Subject("Probabilidad", 3));

        listDataUSchedule[5].add(new Subject("Práctica Aplicada", 3));
        listDataUSchedule[5].add(new Subject("Práctica Aplicada", 4));

        for (int i = 0; i < listDataUSchedule.length; i++)
            Collections.sort(listDataUSchedule[i]);
    }

    public static ArrayList<Servicio> getListDataBComputer() {
        return listDataBComputer;
    }

    public static ArrayList<Servicio> getListDataBStudy() {
        return listDataBStudy;
    }

    public static ArrayList<Servicio> getListDataBVideo() {
        return listDataBVideo;
    }

    public static ArrayList<Notas> getListDataUGrades() {
        return listDataUGrades;
    }

    public static ArrayList<Subject>[] getListDataUSchedule() {
        return listDataUSchedule;
    }
}
