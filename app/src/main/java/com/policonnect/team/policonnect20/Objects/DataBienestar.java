package com.policonnect.team.policonnect20.Objects;

import java.util.TreeSet;

public class DataBienestar {

    private String name;
    private String teacher;
    private String place;
    private static TreeSet<Integer>[] horario;

    public DataBienestar(String name, String teacher, String place) {
        this.name = name;
        this.teacher = teacher;
        this.place = place;
        horario = new TreeSet[6];
        for (int i = 0; i < horario.length; i++)
            horario[i] = new TreeSet<Integer>();
    }

    public String getName() {
        return name;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getPlace() {
        return place;
    }

    /**
     * Agrega un bloque al dia seleccionado
     *
     * @param time Identifica la hora a la que se ve la actividad en el dia day siendo 1
     *             de 7:00 a 8:30, 2 de 8:40 a 10:10, 3 de 10:20 a 11:50, 4 de 12:00 a 13:30, 5 de
     *             13:40 a 15:10, 6 de 15:20 a 16:50, 7 de 17:00 a 18:30, 8 de 18:40 a 20:10, 9 de
     *             20:20 a 21:50.
     * @param day  Dia en el que se ve la actividad siendo 0 Lunes, 1 Martes, 2 Miércoles, 3 Jueves,
     *             4 Viernes y 5 Sábado.
     * @return true si el bloque ya estaba agregado, falso sino
     */
    public boolean addTimeToDay(int time, int day) {
        return horario[day].add(time);
    }

    /**

     * @return Arreglo de set conteniendo en horario
     */
    public static TreeSet<Integer>[] getSchedule() {
        return horario;
    }


}
