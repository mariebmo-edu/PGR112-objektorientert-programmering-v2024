package model;

import java.sql.Date;

public abstract class Item {
    private int id;
    private String coordinates;
    private int finderId;
    private Date foundDate;
    private int estimatedYear;
    private int museumId; //can be null
    private ItemType itemType;

    public Item(int id, String coordinates, int finderId, Date foundDate, int estimatedYear, int museumId, ItemType itemType) {
        this.id = id;
        this.coordinates = coordinates;
        this.finderId = finderId;
        this.foundDate = foundDate;
        this.estimatedYear = estimatedYear;
        this.museumId = museumId;
        this.itemType = itemType;
    }
}
