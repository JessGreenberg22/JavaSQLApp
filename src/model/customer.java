package model;
/** customer Model
 * @Author Jessica Greenberg Student ID 001462404
 */

import java.sql.Timestamp;

/**customer Object class*/
public class customer
{
    private int customerId;
    private String customerName;
    private String address;
    private String postalCode;
    private String phone;
    private int divisionId;


/** class Constructor for customer */

public customer (int customerId, String customerName, String address, String postalCode, String phone, int divisionId)
{
    this.customerId = customerId;
    this.customerName = customerName;
    this.address = address;
    this.postalCode = postalCode;
    this.phone = phone;
    this.divisionId = divisionId;
}

    /**Getters*/
    public int getCustomerId()
    {return customerId;}

    public String getCustomerName()
    {return customerName;}

    public String getAddress()
    {return address;}

    public String getPostalCode()
    {return postalCode;}

    public String getPhone()
    {return phone;}

    public int getDivisionId()
    {return divisionId;}

    /**Setters*/
    public void setCustomerId(int customerId)
    {this.customerId = customerId;}

    public void setCustomerName(String customerName)
    {this.customerName = customerName;}

    public void setAddress(String address)
    {this.address = address;}

    public void setPostalCode(String postalCode)
    {this.postalCode = postalCode;}

    public void setPhone(String phone)
    {this.phone = phone;}

    public void setDivisionId(int divisionId)
    {this.divisionId = divisionId;}
}