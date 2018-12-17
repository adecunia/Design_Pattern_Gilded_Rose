package edu.insightr.gildedrose;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Item {


    private String name;
    private int sellIn;
    private int id;
    private Date creation_date;
    private Date sell_date;
    private Date buy_date;
    private String buyProduct;
    private String sellProduct;
    private String creationProduct;


    private int quality;

    public Item(int id,String name, int sellIn, int quality) {
        super();
        this.id = id;
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
        creation_date = new Date("12/12/2012");
        sell_date = new Date("24/12/2012");
    }

    public Item() {
        super();
        this.name = null;
        this.sellIn = 0;
        this.quality = 0;
        SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
    }

    public int getid() {
        return id;
    }

    public void setid(int ID) {
        this.id = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", sellIn=" + sellIn +
                ", quality=" + quality +
                '}';
    }
}