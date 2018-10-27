package com.policonnect.team.policonnect20.Objects;


/**
 * Esta clase maneja todos los atributos que tiene una materia para ser agregado al horario
 *
 * @version 1
 * @author: PoliConnect Team
 */
public class Subject implements Comparable<Subject> {

    /**
     * @param time Identifica la hora a la que se ve la materia siendo 1 de 7:00 a 8:30, 2 de 8:40 a
     * 10:10, 3 de 10:20 a 11:50, 4 de 12:00 a 13:30, 5 de 13:40 a 15:10, 6 de 15:20 a
     * 16:50, 7 de 17:00 a 18:30, 8 de 18:40 a 20:10, 9 de 20:20 a 21:50.
     */
    private String name;
    private int time;

    public Subject(String name, int time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public int compareTo(Subject o) {
        return Integer.compare(time, o.getTime());
    }

}
