package com.policonnect.team.policonnect20;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.policonnect.team.policonnect20.LibraryScreens.BibliotecaComputers;
import com.policonnect.team.policonnect20.LibraryScreens.BibliotecaStudy;
import com.policonnect.team.policonnect20.LibraryScreens.BibliotecaVideo;
import com.policonnect.team.policonnect20.MainActivityFragments.PantallaBiblioteca;
import com.policonnect.team.policonnect20.MainActivityFragments.PantallaUsuario;
import com.policonnect.team.policonnect20.Objects.DataBienestar;
import com.policonnect.team.policonnect20.Objects.Notas;
import com.policonnect.team.policonnect20.Objects.Servicio;
import com.policonnect.team.policonnect20.Objects.Subject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Esta clase maneja el almacenamiento de cada uno de los datos que el usuario tiene permitido ver.
 * Aqui se obtienen todos los datos que existen en la base de datos.
 *
 * @version 1
 * @author: PoliConnect Team
 */
public class DataBase {
    private DatabaseReference mDatabase;

    private static ArrayList<Notas> listDataUGrades;
    private static ArrayList<Subject>[] listDataUSchedule;
    private static String studentName;
    private static String studentCode;

    private static ArrayList<Servicio> listDataBComputer;
    private static ArrayList<Servicio> listDataBStudy;
    private static ArrayList<Servicio> listDataBVideo;
    private static int availableComputer;
    private static int availableStudy;
    private static int availableVideo;
    private static FirebaseUser userDB;

    private static DataBienestar[] welfareData;

    private static final String TAG = "DataBase";

    private static DataBase dataBase;

    /**
     * Crea la base de datos
     *
     * @return La base de datos
     */
    public static DataBase enableDataBase(FirebaseUser user) {
        if (dataBase == null) {
            userDB = user;
            dataBase = new DataBase();
        }
        return dataBase;
    }

    public DataBase() {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        setStudentData();
        setLibraryData();
        setWelfareData();

    }

    private void setWelfareData() {
        welfareData = new DataBienestar[6];

        //código 0 Ping Pong
        welfareData[0] = new DataBienestar("Ping Pong", "Juan Pablo López", "Mesas de Ping Pong");
        welfareData[0].addTimeToDay(1, 1);
        welfareData[0].addTimeToDay(2, 2);
        welfareData[0].addTimeToDay(3, 2);
        welfareData[0].addTimeToDay(3, 4);

        //código 1 Rumba Aeróbica
        welfareData[1] = new DataBienestar("Rumba Aeróbica", "Mariantonieta de las Nieves", "Salón de Danza");
        welfareData[1].addTimeToDay(5, 4);
        welfareData[1].addTimeToDay(6, 5);
        welfareData[1].addTimeToDay(5, 5);

        //código 2 Guitarra Eléctrica
        welfareData[2] = new DataBienestar("Guitarra Eléctrica", "Pepito Pérez", "Salón de Música");
        welfareData[2].addTimeToDay(4, 2);
        welfareData[2].addTimeToDay(5, 2);
        welfareData[2].addTimeToDay(6, 2);

        //código 3 Guitarra Acústica
        welfareData[3] = new DataBienestar("Guitarra Acústica", "Alberto Echeverry", "Salón de Música");
        welfareData[3].addTimeToDay(2, 4);
        welfareData[3].addTimeToDay(3, 4);
        welfareData[3].addTimeToDay(4, 4);
        welfareData[3].addTimeToDay(5, 4);
        /*
        //código 4 Gimnasio
        welfareData[4] = new DataBienestar("Gimaniso", "Pedro Fontalvo y Mariana Guerrero", "Gimnasio");
        for (int i = 0; i < 6; i++)
            for (int j = 1; i < 10; j++)
                welfareData[4].addTimeToDay(j, i);
                */


        //código 5 Pintura
        welfareData[5] = new DataBienestar("Taller de Pintura", "Leonardo Da Vinci", "Salón de artes");
        welfareData[3].addTimeToDay(2, 5);
        welfareData[3].addTimeToDay(3, 5);
        welfareData[3].addTimeToDay(4, 5);
        welfareData[3].addTimeToDay(5, 5);
        welfareData[3].addTimeToDay(2, 0);
        welfareData[3].addTimeToDay(3, 0);
        welfareData[3].addTimeToDay(4, 0);
        welfareData[3].addTimeToDay(5, 0);
        welfareData[3].addTimeToDay(6, 0);
        welfareData[3].addTimeToDay(7, 0);
        welfareData[3].addTimeToDay(8, 0);
        welfareData[3].addTimeToDay(9, 0);
    }

    private void setLibraryData() {
        setBComputerData();
        setBStudyData();
        setBVideoData();
    }

    private void setStudentData() {

        mDatabase.child("USER").child(userDB.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                StringTokenizer st = new StringTokenizer(dataSnapshot.child("U_Name").getValue().toString());
                studentName = st.nextToken() + " ";
                st = new StringTokenizer(dataSnapshot.child("U_LName").getValue().toString());
                studentName+=st.nextToken();
                studentCode=dataSnapshot.child("U_Code").getValue().toString();
                PantallaUsuario.setUserData();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        setUGradesData();
        setUScheduleData();
    }


    /**
     * @return Los datos correspondientes a los computadores disponibles.
     */
    private void setBComputerData() {
        listDataBComputer = new ArrayList<>();
        mDatabase.child("COMPUTER").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listDataBComputer.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Servicio service = snapshot.getValue(Servicio.class);
                    listDataBComputer.add(service);
                }
                setAvailableComputer();
                orderLibraryDataByIdNumber(listDataBComputer);
                PantallaBiblioteca.setAvailablesCounters();
                BibliotecaComputers.setView();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    /**
     * @return Los datos correspondientes a los cubículos de estudio disponibles.
     */
    private void setBStudyData() {
        listDataBStudy = new ArrayList<>();
        mDatabase.child("CUBICLE").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listDataBStudy.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Servicio service = snapshot.getValue(Servicio.class);
                    listDataBStudy.add(service);
                }
                setAvailableStudy();
                orderLibraryDataByIdNumber(listDataBStudy);
                PantallaBiblioteca.setAvailablesCounters();
                BibliotecaStudy.setView();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        setAvailableStudy();
    }

    /**
     * @return Los datos correspondientes a los cubículos de video.
     */
    private void setBVideoData() {
        listDataBVideo = new ArrayList<>();

        mDatabase.child("VIDEO").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listDataBVideo.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Servicio service = snapshot.getValue(Servicio.class);
                    listDataBVideo.add(service);
                }
                setAvailableVideo();
                orderLibraryDataByIdNumber(listDataBVideo);
                PantallaBiblioteca.setAvailablesCounters();
                BibliotecaVideo.setView();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        setAvailableVideo();
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

        listDataUSchedule[1].add(new Subject("Francés I", "H-207", 0));
        listDataUSchedule[1].add(new Subject("Probabilidad", "K-010", 6));
        listDataUSchedule[1].add(new Subject("Circuitos Lógicos", "K-008", 4));
        listDataUSchedule[1].add(new Subject("Circuitos Lógicos", "C-207", 5));

        listDataUSchedule[3].add(new Subject("Francés I", "H-207", 0));
        listDataUSchedule[3].add(new Subject("Circuitos Lógicos", "C-207", 5));

        listDataUSchedule[4].add(new Subject("Probabilidad", "K-010", 3));

        listDataUSchedule[5].add(new Subject("Práctica Aplicada", "C-201", 3));
        listDataUSchedule[5].add(new Subject("Práctica Aplicada", "C-201", 4));

        for (int i = 0; i < listDataUSchedule.length; i++)
            Collections.sort(listDataUSchedule[i]);
    }

    public void setAvailableComputer() {
        availableComputer = 0;
        for (int i = 0; i < listDataBComputer.size(); i++)
            if (!listDataBComputer.get(i).isOccupied())
                availableComputer++;
    }

    private void setAvailableStudy() {
        availableStudy = 0;
        for (int i = 0; i < listDataBStudy.size(); i++)
            if (!listDataBStudy.get(i).isOccupied())
                availableStudy++;
    }

    private void setAvailableVideo() {
        availableVideo = 0;
        for (int i = 0; i < listDataBVideo.size(); i++)
            if (!listDataBVideo.get(i).isOccupied())
                availableVideo++;
    }

    private void orderLibraryDataByIdNumber(ArrayList<Servicio> list) {
        Collections.sort(list, new Comparator<Servicio>() {
            @Override
            public int compare(Servicio x, Servicio y) {
                return Integer.compare(x.getNumber(), y.getNumber());
            }

        });
    }

    public static ArrayList<Notas> getListDataUGrades() {
        return listDataUGrades;
    }

    public static ArrayList<Subject>[] getListDataUSchedule() {
        return listDataUSchedule;
    }

    public static String getStudentName() {
        return studentName;
    }

    public static String getStudentCode() {
        return studentCode;
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

    public static String getAvailableComputerString() {
        return Integer.toString(availableComputer);
    }

    public static String getAvailableStudyString() {
        return Integer.toString(availableStudy);
    }

    public static String getAvailableVideoString() {
        return Integer.toString(availableVideo);
    }

    public static DataBienestar getWelfareActivity(int code) {
        return welfareData[code];
    }

}
