package model;

import java.sql.Date;

public class Jewelry extends Item {
    private String category;
    private int valueEstimate;
    private String imgName;

    public Jewelry(int id, String coordinates, int finderId, Date foundDate, int estimatedYear, int museumId, String category, int valueEstimate, String imgName) {
        super(id, coordinates, finderId, foundDate, estimatedYear, museumId, ItemType.JEWELRY);
        this.category = category;
        this.valueEstimate = valueEstimate;
        this.imgName = imgName;
    }

    @Override
    public String toString() {
        return "Jewelry{" +
                "category='" + category + '\'' +
                ", valueEstimate=" + valueEstimate +
                ", imgName='" + imgName + '\'' +
                '}';
    }
}
