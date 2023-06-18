package lk.ijse.Fusion.lk.ijse.Fusion.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.Fusion.lk.ijse.Fusion.bo.BOFactory;
import lk.ijse.Fusion.lk.ijse.Fusion.bo.SuperBO;
import lk.ijse.Fusion.lk.ijse.Fusion.bo.custom.SupplierBO;
import lk.ijse.Fusion.lk.ijse.Fusion.model.SupplierModel;
import lk.ijse.Fusion.lk.ijse.Fusion.dto.Suppliers;

import java.sql.SQLException;

public class SupplierFormController {

    public TextField priceTxt;
    public TextField emailTxt;
    public TextField amountTxt;
    public TextField phoneNoTxt;
    public TextField supplierNamTxt;
    public TextField supplierIdTxt;
    public TextField itemTxt;

    SupplierBO supplierBO = (SupplierBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.SUPPLIER);

    public void addOnAction(ActionEvent actionEvent) {
        String SupplierID = supplierIdTxt.getText();
        String SupplierName = supplierNamTxt.getText();
        String SupplierEmail = emailTxt.getText();
        String SupplierContact = phoneNoTxt.getText();
        double Price = Double.parseDouble(priceTxt.getText());
        String ItemCode = itemTxt.getText();
        String Amount=amountTxt.getText();

        //Suppliers suppliers = new Suppliers(SupplierID, SupplierName,SupplierEmail,SupplierContact,Price,ItemCode,Amount);
        try {
            boolean addSupplier = supplierBO.addSuppliers(new Suppliers(SupplierID,SupplierName,SupplierEmail,SupplierContact,Price,ItemCode,Amount));

            if (addSupplier) {
                new Alert(Alert.AlertType.CONFIRMATION, "Customer Added!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        supplierIdTxt.clear();supplierNamTxt.clear();emailTxt.clear();phoneNoTxt.clear();priceTxt.clear();itemTxt.clear();amountTxt.clear();

    }

    public void updateOnAction(ActionEvent actionEvent) {
        String SupplierID = supplierIdTxt.getText();
        String SupplierName = supplierNamTxt.getText();
        String SupplierEmail = emailTxt.getText();
        String SupplierContact = phoneNoTxt.getText();
        double Price = Double.parseDouble(priceTxt.getText());
        String ItemCode = itemTxt.getText();
        String Amount=amountTxt.getText();

        //Suppliers suppliers = new Suppliers(SupplierID, SupplierName,SupplierEmail,SupplierContact,Price,ItemCode,Amount);

        try {
            boolean updateSupplier = supplierBO.updateSuppliers(new Suppliers(SupplierID,SupplierName,SupplierEmail,SupplierContact,Price,ItemCode,Amount));

            if (updateSupplier) {
                new Alert(Alert.AlertType.CONFIRMATION, "Supplier Update!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        supplierIdTxt.clear();supplierNamTxt.clear();emailTxt.clear();phoneNoTxt.clear();priceTxt.clear();itemTxt.clear();amountTxt.clear();

    }

    public void deleteOnAction(ActionEvent actionEvent) {

        String SupplierID = supplierIdTxt.getText();
        String SupplierName = supplierNamTxt.getText();
        String SupplierEmail = emailTxt.getText();
        String SupplierContact = phoneNoTxt.getText();
        double Price = Double.parseDouble(priceTxt.getText());
        String ItemCode = itemTxt.getText();
        String Amount=amountTxt.getText();

        //Suppliers suppliers = new Suppliers(SupplierID, SupplierName,SupplierEmail,SupplierContact,Price,ItemCode,Amount);

        try {
            boolean deleteSupplier = supplierBO.removeSuppliers(SupplierID);

            if (deleteSupplier) {
                new Alert(Alert.AlertType.CONFIRMATION, "Supplier Delete!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        supplierIdTxt.clear();supplierNamTxt.clear();emailTxt.clear();phoneNoTxt.clear();priceTxt.clear();itemTxt.clear();amountTxt.clear();


    }

    public void SearchOnAction(ActionEvent actionEvent) {
        String SupplierID = supplierIdTxt.getText();
        try {
            //Suppliers suppliers = SupplierModel.search(SupplierID);
            boolean searchSupplier = supplierBO.searchSuppliers(SupplierID);
            if (searchSupplier) {
                new Alert(Alert.AlertType.CONFIRMATION, "Search Ok!!!!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void fillData(Suppliers suppliers) {
        supplierIdTxt.setText(suppliers.getSupplierID());
        supplierNamTxt.setText(suppliers.getSupplierName());
        emailTxt.setText(suppliers.getSupplierEmail());
        phoneNoTxt.setText(suppliers.getSupplierContact());
        priceTxt.setText(String.valueOf(suppliers.getPrice()));
        itemTxt.setText(suppliers.getItemCode());
        amountTxt.setText(suppliers.getAmount());
    }

}
