package model;

import java.sql.Date;

public class Coin extends Item {
    private int diameter;
    private String metal;

    public Coin(int id, String coordinates, int finderId, Date foundDate, int estimatedYear, int museumId, int diameter, String metal) {
        super(id, coordinates, finderId, foundDate, estimatedYear, museumId, ItemType.COIN);
        this.diameter = diameter;
        this.metal = metal;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "diameter=" + diameter +
                ", metal='" + metal + '\'' +
                '}';
    }
}
