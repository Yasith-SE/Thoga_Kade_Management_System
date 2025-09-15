package controller;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerController {
    public void addCustomerDetails(String id, String gender, String name,String date, double salary, String address, String city,String province, String postalCode){
            String SQL = "INSERT INTO customer (CustID,CustTitle,CustName,DOB,salary,CustAddress,City,Province,PostalCode)VALUES(?,?,?,?,?,?,?,?,?);";

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setObject(1,id);
            preparedStatement.setObject(2,gender);
            preparedStatement.setObject(3,name);
            preparedStatement.setObject(4,date);
            preparedStatement.setObject(5,salary);
            preparedStatement.setObject(6,address);
            preparedStatement.setObject(7,city);
            preparedStatement.setObject(8,province);
            preparedStatement.setObject(9,postalCode);



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
