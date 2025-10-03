package controller.customerController;

import javafx.collections.ObservableList;
import model.CustomerModel;

public interface CustomerControllerService {

    void addCustomerDetails(CustomerModel customerModel);

    void updateCustomer(CustomerModel customerUpdate);

    void deleteCustomer(String customerDelete);

    ObservableList<CustomerModel> getAllCustomerDetails();



}
