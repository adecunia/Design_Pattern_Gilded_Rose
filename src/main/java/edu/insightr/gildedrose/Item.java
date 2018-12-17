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
        this.setId(id);
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
        setCreation_date(new Date("12/12/2012"));
        setSell_date(new Date("24/12/2012"));
    }

    public Item() {
        super();
        this.name = null;
        this.sellIn = 0;
        this.quality = 0;
        SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
        setCreation_date(new Date("12/12/2012"));
        setSell_date(new Date("24/12/2012"));
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Date getSell_date() {
        return sell_date;
    }

    public void setSell_date(Date sell_date) {
        this.sell_date = sell_date;
    }

    public Date getBuy_date() {
        return buy_date;
    }

    public void setBuy_date(Date buy_date) {
        this.buy_date = buy_date;
    }

    public String getBuyProduct() {
        return buyProduct;
    }

    public void setBuyProduct(String buyProduct) {
        this.buyProduct = buyProduct;
    }

    public String getSellProduct() {
        return sellProduct;
    }

    public void setSellProduct(String sellProduct) {
        this.sellProduct = sellProduct;
    }

    public String getCreationProduct() {
        return creationProduct;
    }

    public void setCreationProduct(String creationProduct) {
        this.creationProduct = creationProduct;
    }
}