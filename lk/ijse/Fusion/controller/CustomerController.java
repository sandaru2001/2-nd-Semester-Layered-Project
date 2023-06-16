package lk.ijse.Fusion.lk.ijse.Fusion.controller;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.Fusion.lk.ijse.Fusion.bo.BOFactory;
import lk.ijse.Fusion.lk.ijse.Fusion.bo.custom.CustomerBO;
import lk.ijse.Fusion.lk.ijse.Fusion.dto.Customer;


import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerController {



    @FXML
    public TextField CustomerlDTxt;

    public AnchorPane pane;
    @FXML
    public TextField addressTxt;
    @FXML
    public TableView<Customer> tblCus;

    @FXML
    public TextField CustomerNameTxt;

    @FXML

    public TextField nicTxt;

    @FXML
    public TextField phoneTxt;

    @FXML
    public TextField emailTxt;
    public TableColumn ColName;
    public TableColumn ColAddress;
    public TableColumn ColPhone;
    public TableColumn ColCusID;
    public TableColumn ColNic;
    public TableColumn ColEmail;
    public AnchorPane CusPane;

    CustomerBO customerBO = (CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);

    @FXML
    void txtCustomerIdOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String id = CustomerlDTxt.getText();
        customerBO.searchCustomer(id);
        try {
            //Customer customer = CustomerModel.search(id);
            boolean customer = customerBO.searchCustomer(id);
            if (customer) {
                new Alert(Alert.AlertType.CONFIRMATION, "Search Ok!!!!").show();
            }else{
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
                }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void fillData(Customer customer) {
        CustomerlDTxt.setText(customer.getCustomerID());
        nicTxt.setText(customer.getCustomerNIC());
        CustomerNameTxt.setText(customer.getCustomerName());
        addressTxt.setText(customer.getAddress());
        phoneTxt.setText(customer.getPhoneNumber());
        emailTxt.setText(customer.getEmail());
    }

    public void UpdateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String CustomerID = CustomerlDTxt.getText();
        String CustomerNIC = nicTxt.getText();
        String CustomerName = CustomerNameTxt.getText();
        String Address = addressTxt.getText();
        String PhoneNumber = phoneTxt.getText();
        String Email = emailTxt.getText();

        customerBO.updateCustomer(new Customer(CustomerID,CustomerNIC,CustomerName,Address,PhoneNumber,Email));
        try {
            boolean updateCustomer = customerBO.updateCustomer(new Customer(CustomerID,CustomerNIC,CustomerName,Address,PhoneNumber,Email));

            if (updateCustomer) {
                new Alert(Alert.AlertType.CONFIRMATION, "Customer Update!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        CustomerlDTxt.clear();nicTxt.clear();CustomerNameTxt.clear();addressTxt.clear();phoneTxt.clear();emailTxt.clear();
    }


    public void DeleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String CustomerID = CustomerlDTxt.getText();

        customerBO.removeCustomer(CustomerID);
        try {
            boolean deleteCustomer = customerBO.removeCustomer(CustomerID);

            if (deleteCustomer) {
                new Alert(Alert.AlertType.CONFIRMATION, "Customer Delete!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        CustomerlDTxt.clear();nicTxt.clear();CustomerNameTxt.clear();addressTxt.clear();phoneTxt.clear();emailTxt.clear();
    }


    public void searchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String CustomerID = CustomerlDTxt.getText();

        customerBO.searchCustomer(CustomerID);
        try {
            boolean searchCustomer = customerBO.searchCustomer(CustomerID);
            if (searchCustomer) {
                new Alert(Alert.AlertType.CONFIRMATION, "Search Ok!!!!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void AddOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String CustomerID = CustomerlDTxt.getText();
        String CustomerNIC = nicTxt.getText();
        String CustomerName = CustomerNameTxt.getText();
        String Address = addressTxt.getText();
        String PhoneNumber = phoneTxt.getText();
        String Email = emailTxt.getText();

        customerBO.addCustomer(new Customer(CustomerID,CustomerNIC,CustomerName,Address,PhoneNumber,Email));
        try {
            boolean addCustomer = customerBO.addCustomer(new Customer(CustomerID,CustomerNIC,CustomerName,Address,PhoneNumber,Email));

            if (addCustomer) {
                new Alert(Alert.AlertType.CONFIRMATION, "Customer Added!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        CustomerlDTxt.clear();nicTxt.clear();CustomerNameTxt.clear();addressTxt.clear();phoneTxt.clear();emailTxt.clear();
    }




   public void initialize() {
        ColCusID.setCellValueFactory(new PropertyValueFactory("CustomerID"));
       ColNic.setCellValueFactory(new PropertyValueFactory("CustomerNIC"));
        ColName.setCellValueFactory(new PropertyValueFactory("CustomerName"));
        ColAddress.setCellValueFactory(new PropertyValueFactory("Address"));
        ColPhone.setCellValueFactory(new PropertyValueFactory("PhoneNumber"));
       ColEmail.setCellValueFactory(new PropertyValueFactory("Email"));
        try {
            loadAllCustomer();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }
    }

    private void loadAllCustomer() throws SQLException, ClassNotFoundException {
//        ResultSet resultSet = CRUDutil.execute("SELECT * FROM  Customer");
//        ObservableList<Customer> observableList = FXCollections.observableArrayList();
//        while(resultSet.next()){
//                observableList.add(
//                        new Customer(
//                                resultSet.getString("CustomerID"),
//                                resultSet.getString("CustomerNIC"),
//                                resultSet.getString("CustomerName"),
//                                resultSet.getString("Address"),
//                                resultSet.getString("PhoneNumber"),
//                                resultSet.getString("Email")
//                        )
//                    );
//        }
//        tblCus.setItems(observableList);
        ArrayList<Customer> allCustomer = customerBO.loadCustomerIds();

        for (Customer c:allCustomer) {
            tblCus.getItems().add(new Customer(c.getCustomerID(),c.getCustomerNIC(),c.getCustomerName(),c.getAddress(),c.getPhoneNumber(),c.getEmail()));
        }
    }

    public void ReloadOnAction(ActionEvent actionEvent) {
       initialize();
    }
}

