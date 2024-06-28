package model;

import java.time.LocalDate;

public class Coin extends Item {
    private int diameter;
    private String metal;

    public Coin(int id, String coordinates, int finderId, LocalDate foundDate, int estimatedYear, int museumId, int diameter, String metal) {
        super(id, coordinates, finderId, foundDate, estimatedYear, museumId, ItemType.COIN);
        this.diameter = diameter;
        this.metal = metal;
    }

    public int getDiameter() {
        return diameter;
    }

    public String getMetal() {
        return metal;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "diameter=" + diameter +
                ", metal='" + metal + '\'' +
                super.toString() + '}';
    }
}
