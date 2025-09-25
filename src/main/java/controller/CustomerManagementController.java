package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.CustomerModel;

import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerManagementController implements Initializable {

    ObservableList<CustomerModel> customerModels = FXCollections.observableArrayList();
    CustomerControllerService controllerService = new CustomerController();


    @FXML
    private Button btnCustomerAdd;

    @FXML
    private Button btnCustomerDelete;

    @FXML
    private Button btnCustomerUpdate;

    @FXML
    private DatePicker dobField;

    @FXML
    private RadioButton rdbFemaleTitle;

    @FXML
    private RadioButton rdbMaleTitle;

    @FXML
    private TableColumn<?, ?> tblCustAdress;

    @FXML
    private TableColumn<?, ?> tblCustCity;

    @FXML
    private TableColumn<?, ?> tblCustDOB;

    @FXML
    private TableColumn<?, ?> tblCustId;

    @FXML
    private TableColumn<?, ?> tblCustName;

    @FXML
    private TableColumn<?, ?> tblCustPostalCode;

    @FXML
    private TableColumn<?, ?> tblCustProvince;

    @FXML
    private TableColumn<?, ?> tblCustSalary;

    @FXML
    private TableColumn<?, ?> tblCustTitle;

    @FXML
    private TextField txtCustomerAddress;

    @FXML
    private TextField txtCustomerCity;

    @FXML
    private TextField txtCustomerId;

    @FXML
    private TextField txtCustomerName;

    @FXML
    private TextField txtCustomerPostalCode;

    @FXML
    private TextField txtCustomerProvince;

    @FXML
    private TextField txtSalary;

    @FXML
    void btnAddOnAction(ActionEvent event) {
        CustomerModel custModel = new CustomerModel(
                txtCustomerId.getText(),
                checkGender(),
                txtCustomerName.getText(),
                dobField.dayCellFactoryProperty(),
                Double.parseDouble(txtSalary.getText()),
                txtCustomerAddress.getText(),
                txtCustomerCity.getText(),
                txtCustomerProvince.getText(),
                txtCustomerPostalCode.getText()

        );

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    private String checkGender(){
        if(rdbFemaleTitle.isSelected()){
            return "Mr";
        }else{return "Mrs";}
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ToggleGroup titleToggleGroup = new ToggleGroup();
        rdbMaleTitle.setToggleGroup(titleToggleGroup);
        rdbFemaleTitle.setToggleGroup(titleToggleGroup);

        tblCustId.setCellValueFactory(new PropertyValueFactory<>("CustID"));
        tblCustTitle.setCellValueFactory(new PropertyValueFactory<>("CustTitle"));
        tblCustName.setCellValueFactory(new PropertyValueFactory<>("CustName"));
        tblCustDOB.setCellValueFactory(new PropertyValueFactory<>("DOB"));
        tblCustSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        tblCustAdress.setCellValueFactory(new PropertyValueFactory<>("CustAddress"));
        tblCustCity.setCellValueFactory(new PropertyValueFactory<>("City"));
        tblCustProvince.setCellValueFactory(new PropertyValueFactory<>("Province"));
        tblCustPostalCode.setCellValueFactory(new PropertyValueFactory<>("PostalCode"));

        loadDetails();
    }

    private void loadDetails(){
        customerModels = controllerService.getAllCustomerDetails();


    }
}
