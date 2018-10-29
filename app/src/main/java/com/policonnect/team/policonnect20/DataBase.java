package com.policonnect.team.policonnect20;

import com.policonnect.team.policonnect20.Objects.Notas;
import com.policonnect.team.policonnect20.Objects.Servicio;
import com.policonnect.team.policonnect20.Objects.Subject;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Esta clase maneja el almacenamiento de cada uno de los datos que el usuario tiene permitido ver.
 * Aqui se obtienen todos los datos que existen en la base de datos.
 *
 * @version 1
 * @author: PoliConnect Team
 */
public class DataBase {

    private static ArrayList<Servicio> listDataBComputer;
    private static ArrayList<Servicio> listDataBStudy;
    private static ArrayList<Servicio> listDataBVideo;
    private static ArrayList<Notas> listDataUGrades;
    private static ArrayList<Subject>[] listDataUSchedule;

    private static int availableComputer;
    private static int availableStudy;
    private static int availableVideo;

    private static String studentName;
    private static String studentCode;

    private static DataBase dataBase;

    private String cubiculo = "Cubículo";
    private String computador = "Computador";


    public DataBase() {
        setStudentData();
        setBComputerData();
        setBStudyData();
        setBVideoData();
    }

    private void setStudentData() {
        studentName = "Alejandro Arévalo";
        studentCode = "1520010666";
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
        for (int i = 0; i < 40; i += 5) {
            listDataBComputer.add(new Servicio(computador, 1 + i, true, false));
            listDataBComputer.add(new Servicio(computador, 2 + i, true, false));
            listDataBComputer.add(new Servicio(computador, 3 + i, false, false));
            listDataBComputer.add(new Servicio(computador, 4 + i, false, false));
            listDataBComputer.add(new Servicio(computador, 5 + i, true, false));
        }

        setAvailableComputer();
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

        setAvailableStudy();
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

    public static String getAvailableComputerString() {
        return Integer.toString(availableComputer);
    }

    public static String getAvailableStudyString() {
        return Integer.toString(availableStudy);
    }

    public static String getAvailableVideoString() {
        return Integer.toString(availableVideo);
    }

    public static String getStudentName() {
        return studentName;
    }

    public static String getStudentCode() {
        return studentCode;
    }
}
