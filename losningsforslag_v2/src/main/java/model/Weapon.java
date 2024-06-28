package model;

import java.time.LocalDate;

public class Weapon extends Item {
    private String weaponType;
    private String material;
    private int weight;

    public Weapon(int id, String coordinates, int finderId, LocalDate foundDate, int estimatedYear, int museumId, String weaponType, String material, int weight) {
        super(id, coordinates, finderId, foundDate, estimatedYear, museumId, ItemType.WEAPON);
        this.weaponType = weaponType;
        this.material = material;
        this.weight = weight;
    }

    public String getWeaponType() {
        return weaponType;
    }

    public String getMaterial() {
        return material;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "weaponType='" + weaponType + '\'' +
                ", material='" + material + '\'' +
                ", weight=" + weight +
                super.toString() + '}';
    }
}
