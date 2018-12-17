package edu.insightr.gildedrose;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;


import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private Item[] items;

    private int ID = 0;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }


    public Inventory(Item[] items) {
        super();
        this.InventorySetItems(items);
    }



    public Inventory() {
        super();
        InventorySetItems(new Item[]{
                new Item(0,"+5 Dexterity Vest", 10, 20),
                new Item(1,"Aged Brie", 2, 0),
                new Item(2,"Elixir of the Mongoose", 5, 7),
                new Item(3,"Sulfuras, Hand of Ragnaros", 0, 80),
                new Item(4,"Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item(5,"Conjured Mana Cake", 3, 6)
        });
        setID(5);
    }

    public void printInventory() {
        System.out.println("***************");
        for (Item item : getItems()) {
            System.out.println(item);
        }
        System.out.println("***************");
        System.out.println("\n");
    }

    public void updateQuality() {
        for (int i = 0; i < getItems().length; i++) {
            if (getItems()[i].getName() != "Aged Brie"
                    && getItems()[i].getName() != "Backstage passes to a TAFKAL80ETC concert") {
                if (getItems()[i].getQuality() > 0) {
                    if (getItems()[i].getName() != "Sulfuras, Hand of Ragnaros") {
                        getItems()[i].setQuality(getItems()[i].getQuality() - 1);
                    }
                }
            } else {
                if (getItems()[i].getQuality() < 50) {
                    getItems()[i].setQuality(getItems()[i].getQuality() + 1);

                    if (getItems()[i].getName() == "Backstage passes to a TAFKAL80ETC concert") {
                        if (getItems()[i].getSellIn() < 11) {
                            if (getItems()[i].getQuality() < 50) {
                                getItems()[i].setQuality(getItems()[i].getQuality() + 1);
                            }
                        }

                        if (getItems()[i].getSellIn() < 6) {
                            if (getItems()[i].getQuality() < 50) {
                                getItems()[i].setQuality(getItems()[i].getQuality() + 1);
                            }
                        }
                    }
                }
            }

            if (getItems()[i].getName() != "Sulfuras, Hand of Ragnaros") {
                getItems()[i].setSellIn(getItems()[i].getSellIn() - 1);
            }

            if (getItems()[i].getSellIn() < 0) {
                if (getItems()[i].getName() != "Aged Brie") {
                    if (getItems()[i].getName() != "Backstage passes to a TAFKAL80ETC concert") {
                        if (getItems()[i].getQuality() > 0) {
                            if (getItems()[i].getName() != "Sulfuras, Hand of Ragnaros") {
                                getItems()[i].setQuality(getItems()[i].getQuality() - 1);
                            }
                        }
                    } else {
                        getItems()[i].setQuality(getItems()[i].getQuality() - getItems()[i].getQuality());
                    }
                } else {
                    if (getItems()[i].getQuality() < 50) {
                        getItems()[i].setQuality(getItems()[i].getQuality() + 1);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        for (int i = 0; i < 10; i++) {
            inventory.updateQuality();
            inventory.printInventory();
        }
    }

    public Item[] getItems() {
        return items;
    }

    public List<PieChart.Data> GetItemsName()
    {
        List<PieChart.Data> PieChartData = new ArrayList<>();

        for(int i =0; i<items.length;i++)
        {

                PieChartData.add(new PieChart.Data(items[0].getName(),items[0].getQuality()));


        }
        return PieChartData;
    }

    public int IndexType(String name,int p)
    {
        for (int i=p;i<items.length;i++)
        {
            if(name == items[i].getName())
            {
                return i;
            }
            else
            {
                return -1;
            }
        }
        return -1;
    }

    public void InventorySetItems(Item[] items) {
        this.items = items;
    }

    public Item[] add(List<Item> iList) {
        Item[] returnTab = new Item[items.length + iList.size()];

        for (int i = 0; i < items.length; i++) {
            returnTab[i] = items[i];
        }

        for (int i = items.length; i < items.length + iList.size(); i++) {
            returnTab[i] = iList.get(i - items.length);
            returnTab[i].setId(getID()+1);
            setID(getID()+1);

        }

        items=returnTab;

        return returnTab;
    }

    public Item[] add_item(Item i) {
        Item[] returnTab = new Item[items.length + 1];

        for (int j = 0; j < items.length; j++) {
            returnTab[j] = items[j];

        }

        returnTab[items.length] = i;


        items = returnTab;

        return returnTab;
    }

    public void DeclareSerieBarChart(BarChart barchart)
    {
        for(int i=0;i<items.length;i++)
        {
            XYChart.Series series1 = new XYChart.Series();
            series1.getData().add(new XYChart.Data( String.valueOf( items[i].getSellIn()), String.valueOf( items[i].getQuality())));
            barchart.getData().addAll(series1);
        }
    }
}