package model;

import java.sql.Date;

public class Weapon extends Item {
    private String weaponType;
    private String material;
    private int weight;

    public Weapon(int id, String coordinates, int finderId, Date foundDate, int estimatedYear, int museumId, String weaponType, String material, int weight) {
        super(id, coordinates, finderId, foundDate, estimatedYear, museumId, ItemType.WEAPON);
        this.weaponType = weaponType;
        this.material = material;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "weaponType='" + weaponType + '\'' +
                ", material='" + material + '\'' +
                ", weight=" + weight +
                '}';
    }
}
