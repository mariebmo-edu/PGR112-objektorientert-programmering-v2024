package model;

import java.time.LocalDate;

public abstract class Item {
    private int id;
    private String coordinates;
    private int finderId;
    private LocalDate foundDate;
    private int estimatedYear;
    private int museumId; //can be null
    private ItemType itemType;

    public Item(int id, String coordinates, int finderId, LocalDate foundDate, int estimatedYear, int museumId, ItemType itemType) {
        this.id = id;
        this.coordinates = coordinates;
        this.finderId = finderId;
        this.foundDate = foundDate;
        this.estimatedYear = estimatedYear;
        this.museumId = museumId;
        this.itemType = itemType;
    }

    public int getId() {
        return id;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public int getFinderId() {
        return finderId;
    }

    public LocalDate getFoundDate() {
        return foundDate;
    }

    public String getFoundDateString() {
        return foundDate.toString();
    }

    public int getEstimatedYear() {
        return estimatedYear;
    }

    public int getMuseumId() {
        return museumId;
    }

    public ItemType getItemType() {
        return itemType;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", coordinates='" + coordinates + '\'' +
                ", finderId=" + finderId +
                ", foundDate=" + foundDate +
                ", estimatedYear=" + estimatedYear +
                ", museumId=" + museumId +
                ", itemType=" + itemType +
                '}';
    }
}
