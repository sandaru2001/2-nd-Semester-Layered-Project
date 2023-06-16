package lk.ijse.Fusion.lk.ijse.Fusion.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.Fusion.lk.ijse.Fusion.Util.CRUDutil;
import lk.ijse.Fusion.lk.ijse.Fusion.bo.BOFactory;
import lk.ijse.Fusion.lk.ijse.Fusion.bo.custom.ItemBO;
import lk.ijse.Fusion.lk.ijse.Fusion.model.ItemModel;
import lk.ijse.Fusion.lk.ijse.Fusion.dto.Item;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemForm {
    public AnchorPane ItemContext;
    public TextField item_ccodeTxt;
    public TextField item_nameTxt;
    public TextField item_priceTxt;
    public TextField descriptionTxt;
    public TextField QTYTxt;

    public TextField itemtypeTxt;
    public TableView <Item>tblItemAll;
    public TableColumn ColItemCode;
    public TableColumn ColItemType;
    public TableColumn ColItemName;
    public TableColumn ColItemPrice;
    public TableColumn ColDescription;
    public TableColumn ColQty;


    ItemBO itemBO = (ItemBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ITEM);

    public void SuppliersDetails(ActionEvent actionEvent) {
    }


    @FXML
    public void addOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String ItemCode =item_ccodeTxt.getText();
        String ItemName = item_nameTxt.getText();
        String ItemDescription =  descriptionTxt.getText();
        double ItemPrice = Double.parseDouble(item_priceTxt.getText());
        int  QtyOnHand = Integer.parseInt( QTYTxt.getText());
        String  ItemType =   itemtypeTxt.getText();


        //Item item = new Item(ItemCode,ItemName,ItemDescription,ItemPrice,QtyOnHand,ItemType);
        boolean addItem = itemBO.addItem(new Item(ItemCode,ItemName,ItemDescription,ItemPrice,QtyOnHand,ItemType));


        if (addItem) {
            new Alert(Alert.AlertType.CONFIRMATION, "Item Added!").show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Something happened!").show();
        }
    }

    public void updateOnAction(ActionEvent actionEvent) {
        String ItemCode =item_ccodeTxt.getText();
        String  ItemName = item_nameTxt.getText();
        String ItemDescription = descriptionTxt.getText();
        double ItemPrice = Double.parseDouble(item_priceTxt.getText());
        int  QtyOnHand = Integer.parseInt(QTYTxt.getText());
        String ItemType =itemtypeTxt.getText();


        //Item item = new Item(ItemCode,ItemName,ItemDescription,ItemPrice,QtyOnHand,ItemType);

        try {
            boolean updateItem = itemBO.updateItem(new Item(ItemCode,ItemName,ItemDescription,ItemPrice,QtyOnHand,ItemType));

            if (updateItem) {
                new Alert(Alert.AlertType.CONFIRMATION, "Item Update!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteOnAction(ActionEvent actionEvent) {
        String ItemCode =item_ccodeTxt.getText();


        //Item item = new Item(ItemCode,ItemName,ItemDescription,ItemPrice,QtyOnHand,ItemType);
        try {
            boolean deleteItem = itemBO.removeItem(ItemCode);

            if (deleteItem) {
                new Alert(Alert.AlertType.CONFIRMATION, "Item Delete!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void searchOnAction(ActionEvent actionEvent) {
        String  ItemCode = item_ccodeTxt.getText();
        try {
            boolean searchItem = itemBO.searchItem(ItemCode);
            if (searchItem) {
                new Alert(Alert.AlertType.CONFIRMATION, "Search Ok!!!!").show();
            }else{
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private void fillData(Item item) {
        item_ccodeTxt.setText(item.getItemCode());
        item_nameTxt.setText(item.getItemName());
        descriptionTxt.setText(item.getItemDescription());
        item_priceTxt.setText(String.valueOf(item.getItemPrice()));
        QTYTxt.setText(String.valueOf(item.getQtyOnHand()));
        itemtypeTxt.setText(item.getItemType());
    }

    public void initialize() {
        ColItemCode .setCellValueFactory(new PropertyValueFactory("ItemCode"));
        ColItemType .setCellValueFactory(new PropertyValueFactory("ItemType"));
         ColItemName.setCellValueFactory(new PropertyValueFactory("ItemName"));
        ColDescription .setCellValueFactory(new PropertyValueFactory("Description"));
         ColItemPrice.setCellValueFactory(new PropertyValueFactory("ItemPrice"));
        ColQty .setCellValueFactory(new PropertyValueFactory("QTY"));
        try {
            loadAllItem();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }
    }

    private void loadAllItem() throws SQLException, ClassNotFoundException {
//        ResultSet resultSet = CRUDutil.execute("SELECT * FROM  Item");
//        ObservableList<Item> observableList = FXCollections.observableArrayList();
//        while(resultSet.next()){
//            observableList.add(
//                    new Item(
//                            resultSet.getString("ItemCode"),
//                            resultSet.getString("ItemName"),
//                            resultSet.getString("ItemDescription"),
//                            resultSet.getDouble("ItemPrice"),
//                            resultSet.getInt("QtyOnHand"),
//                            resultSet.getString("ItemType")
//                    )
//            );
//        }
//        tblItemAll.setItems(observableList);
        ArrayList<Item> allItems = itemBO.loadItemIds();
        for (Item i:allItems) {
            tblItemAll.getItems().add(new Item(i.getItemCode(),i.getItemName(),i.getItemDescription(),i.getItemPrice(),i.getQtyOnHand(),i.getItemType()));
        }
    }


    public void ReloadOnAction(ActionEvent actionEvent) {
        initialize();
    }
}
