package controller;

import javafx.collections.ObservableList;
import model.CustomerModel;

public interface CustomerControllerService {

    ObservableList<CustomerModel> getAllCustomerDetails();
    void addCustomerDetails(CustomerModel customerModel);


}
