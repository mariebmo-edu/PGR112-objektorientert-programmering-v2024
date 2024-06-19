package model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Jewelry extends Item {
    private String category;
    private int valueEstimate;
    private String imgName;

    public Jewelry(int id, String coordinates, int finderId, LocalDate foundDate, int estimatedYear, int museumId, String category, int valueEstimate, String imgName) {
        super(id, coordinates, finderId, foundDate, estimatedYear, museumId, ItemType.JEWELRY);
        this.category = category;
        this.valueEstimate = valueEstimate;
        this.imgName = imgName;
    }

    public String getCategory() {
        return category;
    }

    public int getValueEstimate() {
        return valueEstimate;
    }

    public String getImgName() {
        return imgName;
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
