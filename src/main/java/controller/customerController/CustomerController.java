package controller.customerController;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.CustomerModel;

import java.sql.*;

public class CustomerController implements CustomerControllerService {
        ObservableList <CustomerModel> customerModels = FXCollections.observableArrayList();

        @Override
        public void addCustomerDetails(CustomerModel customerModel){
            String SQL = "INSERT INTO customer Values( ?,?,?,?,?,?,?,?,?);";

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
        @Override
        public void updateCustomer(CustomerModel customerUpdate) {
            String SQL ="UPDATE customer SET CustTitle = ?, CustName = ?, DOB = ?, salary = ?, CustAddress = ?, City = ?, Province = ?, PostalCode = ? WHERE CustID = ?";

            try {
                Connection connection = DBConnection.getInstance().getConnection();
                PreparedStatement preUpdateSte = connection.prepareStatement(SQL);

                preUpdateSte.setObject(1,customerUpdate.getGenderCustomer());
                preUpdateSte.setObject(2,customerUpdate.getNameCustomer());
                preUpdateSte.setObject(3,customerUpdate.getDateChooser());
                preUpdateSte.setObject(4,customerUpdate.getSalary());
                preUpdateSte.setObject(5,customerUpdate.getCustomerAddress());
                preUpdateSte.setObject(6,customerUpdate.getCity());
                preUpdateSte.setObject(7,customerUpdate.getProvince());
                preUpdateSte.setObject(8,customerUpdate.getPostalCode());
                preUpdateSte.setObject(9,customerUpdate.getIdCustomer());

                preUpdateSte.executeUpdate();



            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        @Override
        public void deleteCustomer(String customerDelete){
            String SQL ="DELETE FROM customer WHERE CustID = ?;";
            try {
                Connection conDelete = DBConnection.getInstance().getConnection();
                PreparedStatement preDeleteSte = conDelete.prepareStatement(SQL);
                preDeleteSte.setObject(1,customerDelete);

                preDeleteSte.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        public ObservableList<CustomerModel>getAllCustomerDetails(){
            ObservableList<CustomerModel>custModelConnect=FXCollections.observableArrayList();
            String SQL = "SELECT * from customer;";
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


