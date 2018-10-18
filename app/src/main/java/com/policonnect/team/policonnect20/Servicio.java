package com.policonnect.team.policonnect20;


/**
 * Esta clase maneja todos los atributos que tiene un elemento de algun servicio de la bilbioteca:
 * cubiculos de estudio, cubículos de video y computadores
 *
 * @version 1
 * @author: PoliConnect Team
 */
public class Servicio {

    /**
     * @param idServicio Identifica que servicio es el que está en el objeto 1 Cubículos de estudio,
     * 2 Computadores y 3 Cubiculos de video
     */
    private int idServicio;
    private String name;
    private int number;
    private boolean occupied;
    private boolean group;
    private int piso;


    public Servicio(String name, int number, boolean occupied, boolean group) {
        this.name = name;
        this.number = number;
        this.occupied = occupied;
        this.group = group;
    }


    public Servicio() {
        this.name = "Servicio";
        this.number = -1;
        this.occupied = false;
        this.group = false;

    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGroup() {
        return group;
    }

    public void setGroup(boolean group) {
        this.group = group;
    }
}
