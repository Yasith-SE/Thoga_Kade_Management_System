package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import model.CustomerModel;

import javafx.event.ActionEvent;

public class CustomerManagementController {

    ObservableList<CustomerModel> customerModels = FXCollections.observableArrayList();

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
        String customerId = txtCustomerId.getText();
        String

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    private String checkGender(){
        if(rdbFemaleTitle.isSelected()){
            return "Male";
        }
        return "Female";
    }
}
