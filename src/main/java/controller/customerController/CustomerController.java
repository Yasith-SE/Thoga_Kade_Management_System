package controller.customerController;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.CustomerModel;

import java.sql.*;

public class CustomerController implements CustomerControllerService {
        ObservableList <CustomerModel> customerModels = FXCollections.observableArrayList();

        public void addCustomerDetails(CustomerModel customerModel){
            String SQL = "INSERT INTO customer Values( ?,?,?,?,?,?,?,?,?)";

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

        public ObservableList<CustomerModel>getAllCustomerDetails(){
            ObservableList<CustomerModel>custModelConnect=FXCollections.observableArrayList();
            String SQL = "SELECT * from customer";
            Connection con = null;
            try {
                con = DBConnection.getInstance().getConnection();
                PreparedStatement preStat = con.prepareStatement(SQL);
                ResultSet reSet = preStat.executeQuery();
                while (reSet.next()){
                    customerModels.add(new CustomerModel(
                            reSet.getString("CustID"),
                            reSet.getString("CustTitle"),
                            reSet.getString("CustName"),
                            reSet.getString("DOB"),
                            reSet.getDouble("salary"),
                            reSet.getString("CustAddress"),
                            reSet.getString("City"),
                            reSet.getString("Province"),
                            reSet.getString("PostalCode")

                            ));

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return customerModels;
        }



    }


