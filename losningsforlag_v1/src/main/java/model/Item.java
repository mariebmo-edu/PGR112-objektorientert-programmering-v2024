package model;

import java.util.Date;

public abstract class Item {
    private int id;
    private int estimatedYear;
    private int finderId;
    private int museumId; //can be null
    private String coordinates;
    private ItemType type;
    private Date foundDate;
}
