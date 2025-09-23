package model;

import lombok.*;

@ToString
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor

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
