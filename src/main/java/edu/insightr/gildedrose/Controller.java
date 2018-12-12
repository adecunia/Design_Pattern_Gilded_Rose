package edu.insightr.gildedrose;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    private Inventory inventory;

    @FXML
    private TableView<Item> table_items;

    @FXML
    private TextField Name;

    @FXML
    private TextField SellIn;

    @FXML
    private TextField Quality;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        inventory = new Inventory();
        ObservableList<Item> Items = FXCollections.observableArrayList(inventory.getItems());
        table_items.setItems(Items);
    }


    public void updateItems()
    {
        inventory.updateQuality();
        table_items.refresh();

    }

    public void addItem(javafx.event.ActionEvent actionEvent) {

        String name = Name.getText();
        int sellIn = Integer.parseInt(SellIn.getText());
        int quality =Integer.parseInt(Quality.getText());


        Item new_items = new Item(name,sellIn,quality);

        Item[] newInventory = inventory.add_item(new_items);

        table_items.getItems().setAll(newInventory);

    }

    public void loadItems() {
        Stage stage = new Stage();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Json File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Json", "*.json"));
        File json = fileChooser.showOpenDialog(stage);

        ObjectMapper mapper = new ObjectMapper();
        List<Item> Load_items = null;
        try {
            Load_items = mapper.readValue(json, new TypeReference<List<Item>>() { });
        } catch (IOException e) {
            e.printStackTrace();
        }


        Item[] newInventory = inventory.add(Load_items);

        table_items.getItems().setAll(newInventory);

    }
}
