package com.policonnect.team.policonnect20;

import java.util.ArrayList;

public class DataBase {


    public ArrayList<Servicio> listDataBComputer;
    public ArrayList<Servicio> listDataBStudy;
    public ArrayList<Servicio> listDataBVideo;
    public ArrayList<Notas> listDataUGrades;
    private String cubiculo;
    private String computador;

    public DataBase() {
        cubiculo = "Cubículo";
        computador = "Computador";
        setBComputerData();
        setBStudyData();
        setBVideoData();
        setUGradesData();
    }

    private void setBComputerData() {
        listDataBComputer = new ArrayList<>();
        for (int i = 0; i < 40; i += 5) {
            listDataBComputer.add(new Servicio(computador, 1 + i, true, false));
            listDataBComputer.add(new Servicio(computador, 2 + i, true, false));
            listDataBComputer.add(new Servicio(computador, 3 + i, false, false));
            listDataBComputer.add(new Servicio(computador, 4 + i, false, false));
            listDataBComputer.add(new Servicio(computador, 5 + i, true, false));
        }
    }

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

    private void setBVideoData() {
        listDataBVideo = new ArrayList<>();
        listDataBVideo.add(new Servicio(cubiculo, 1, true, true));
        listDataBVideo.add(new Servicio(cubiculo, 2, true, false));
        listDataBVideo.add(new Servicio(cubiculo, 3, false, false));
        listDataBVideo.add(new Servicio(cubiculo, 4, false, false));
        listDataBVideo.add(new Servicio(cubiculo, 5, true, false));
    }


    private void setUGradesData() {
        listDataUGrades = new ArrayList<>();
        listDataUGrades.add(new Notas("Matemática",4.8,161));
        listDataUGrades.add(new Notas("Algebra",3.0,162));
        listDataUGrades.add(new Notas("Publicidad",2.98,181));
        listDataUGrades.add(new Notas("Introducción a la Ingeniería",3.0,181));
        listDataUGrades.add(new Notas("Francés I",2.98,181));
        listDataUGrades.add(new Notas("Probabilidad",3.0,181));
        listDataUGrades.add(new Notas("Estructura de Datos",2.98,181));
        listDataUGrades.add(new Notas("Física I",3.0,181));
        listDataUGrades.add(new Notas("Cálculo I",4.98,162));
        listDataUGrades.add(new Notas("Cálculo II",3.0,171));
        listDataUGrades.add(new Notas("Cálculo III",2.98,172));
        listDataUGrades.add(new Notas("Bases de Datos",3.0,181));
        listDataUGrades.add(new Notas("Programación de Computadores",5.0,162));
        listDataUGrades.add(new Notas("Lecto-Escritura",3.0,181));
    }

    public ArrayList<Servicio> getListDataBComputer() {
        return listDataBComputer;
    }

    public ArrayList<Servicio> getListDataBStudy() {
        return listDataBStudy;
    }

    public ArrayList<Servicio> getListDataBVideo() {
        return listDataBVideo;
    }

    public ArrayList<Notas> getListDataUGrades() {
        return listDataUGrades;
    }
}
