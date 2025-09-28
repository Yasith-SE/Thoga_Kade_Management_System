package controller.customerController;

import javafx.collections.ObservableList;
import model.CustomerModel;

public interface CustomerControllerService {

    void addCustomerDetails(CustomerModel customerModel);

    ObservableList<CustomerModel> getAllCustomerDetails();



}
