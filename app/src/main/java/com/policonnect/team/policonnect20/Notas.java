package com.policonnect.team.policonnect20;

public class Notas {

    /**
     * @param state si es 0 se está cursando, si es -1 está reprobada, si es 1 está aprobada
     */
    private String materia;
    private double grade;
    private int state;
    private int date;

    public Notas(String materia, double grade, int date) {
        this.materia = materia.substring(0,Math.min(materia.length(),15));
        this.grade = ((int) (grade * 10)) / 10.0;
        this.date = date;
        if (this.date == 182)
            state = 0;
        else if (grade < 3.0)
            state = -1;
        else
            state = 1;
    }

    public Notas(String materia, double grade, int state, int date) {
        this.materia = materia;
        this.grade = grade;
        this.state = state;
        this.date = date;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public double getGrade() {
        return grade;
    }

    public String getGradeString() {
        return Double.toString(grade);
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

}
