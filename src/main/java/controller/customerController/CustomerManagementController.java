package controller.customerController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
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
    private TableView<CustomerModel> tblCustomerDetails;

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
                dobField.getAccessibleHelp(),
                Double.parseDouble(txtSalary.getText()),
                txtCustomerAddress.getText(),
                txtCustomerCity.getText(),
                txtCustomerProvince.getText(),
                txtCustomerPostalCode.getText()

        );
//        if(custModel == customerModels){
//
//        }
        controllerService.addCustomerDetails(custModel);
        loadDetails();


        txtCustomerId.setText(null);
        rdbMaleTitle.setSelected(false);
        rdbFemaleTitle.setSelected(false);
        txtCustomerName.setText(null);
        dobField.getAccessibleHelp();
        txtSalary.setText(null);
        txtCustomerAddress.setText(null);
        txtCustomerCity.setText(null);
        txtCustomerProvince.setText(null);
        txtCustomerPostalCode.setText(null);
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        controllerService.deleteCustomer(txtCustomerId.getText());
        loadDetails();

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        CustomerModel customerModel = new CustomerModel(
                txtCustomerId.getText(),
                checkGender(),
                txtCustomerName.getText(),
                dobField.getAccessibleHelp(),
                Double.parseDouble(txtSalary.getText()),
                txtCustomerAddress.getText(),
                txtCustomerCity.getText(),
                txtCustomerProvince.getText(),
                txtCustomerPostalCode.getText()
        );


        controllerService.updateCustomer(customerModel);
        loadDetails();

    }

    private String checkGender(){
        if(rdbFemaleTitle.isSelected()){
            return "Mrs";
        }else{return "Mr";}
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ToggleGroup titleToggleGroup = new ToggleGroup();
        rdbMaleTitle.setToggleGroup(titleToggleGroup);
        rdbFemaleTitle.setToggleGroup(titleToggleGroup);

        tblCustId.setCellValueFactory(new PropertyValueFactory<>("idCustomer"));
        tblCustTitle.setCellValueFactory(new PropertyValueFactory<>("genderCustomer"));
        tblCustName.setCellValueFactory(new PropertyValueFactory<>("nameCustomer"));
        tblCustDOB.setCellValueFactory(new PropertyValueFactory<>("dateChooser"));
        tblCustSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        tblCustAdress.setCellValueFactory(new PropertyValueFactory<>("customerAddress"));
        tblCustCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        tblCustProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        tblCustPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));

        loadDetails();

//        tblCustomerDetails.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue) -> {
//            if(newValue != null){
//                newValue;
//            }
//        });
    }

    private void loadDetails(){
        customerModels.clear();

        customerModels = controllerService.getAllCustomerDetails();
        tblCustomerDetails.setItems(customerModels);

    }
}
