package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.CustomerModel;

import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerManagementController implements Initializable {

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
        String customerTitle = checkGender();
        String customerName = txtCustomerName.getText();
        String dob = dobField.getAccessibleHelp();
        double salary = Double.parseDouble(txtSalary.getText());
        String customerAddress = txtCustomerAddress.getText();
        String city = txtCustomerCity.getText();
        String province = txtCustomerProvince.getText();
        String postalCode = txtCustomerPostalCode.getText();

        CustomerController customerController = new CustomerController();
        customerController.addCustomerDetails(customerId,customerTitle,customerName,dob,salary,customerAddress,city,province,postalCode);

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    private String checkGender(){
        if(rdbMaleTitle.isSelected()){
            return "Male";
        } else if (rdbFemaleTitle.isSelected()) {
            return "Female";
        }
        else {
            return "";
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tblCustId.setCellValueFactory(new PropertyValueFactory<>("CustID"));
        tblCustTitle.setCellValueFactory(new PropertyValueFactory<>("CustTitle"));
        tblCustName.setCellValueFactory(new PropertyValueFactory<>("CustName"));
        tblCustDOB.setCellValueFactory(new PropertyValueFactory<>("DOB"));
        tblCustSalary.setCellValueFactory(new PropertyValueFactory<>("CustAddress"));
        tblCustCity.setCellValueFactory(new PropertyValueFactory<>("City"));
        tblCustProvince.setCellValueFactory(new PropertyValueFactory<>("PostalCode"));
    }
}
