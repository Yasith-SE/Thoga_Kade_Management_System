package controller;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.CustomerModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerController implements CustomerControllerService {
        ObservableList <CustomerModel> customerModels = FXCollections.observableArrayList();

        public void addCustomerDetails(CustomerModel customerModel){
            String SQL = "INSERT INTO customer(CustID,CustTitle,CustName,DOB,salary,CustAddress,City,Province,PostalCode)VALUES( ?,?,?,?,?,?,?,?,?))";

            try {
                Connection connection = DBConnection.getInstance().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SQL);
                preparedStatement.setObject(1,customerModel.getIdCustomer());
                preparedStatement.setObject(2,customerModel.getGenderCustomer());
                preparedStatement.setObject(3,customerModel.getNameCustomer());
                preparedStatement.setObject(4,customerModel.getDateChooser());
                preparedStatement.setObject(5,customerModel.getSalary());
                preparedStatement.setObject(6,customerModel.getCustomerAddress());
                preparedStatement.setObject(7,customerModel.getCity());
                preparedStatement.setObject(8,customerModel.getProvince());
                preparedStatement.setObject(9,customerModel.getPostalCode());

                preparedStatement.executeUpdate();


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

}
