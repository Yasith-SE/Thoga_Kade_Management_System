package model;

import javafx.beans.property.ObjectProperty;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.util.Callback;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerModel {
    private String idCustomer;
    private String genderCustomer;
    private String nameCustomer;
    private String dateChooser;
    private double salary;
    private String customerAddress;
    private String city;
    private String province;
    private String postalCode;



}




