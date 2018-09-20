package com.solstice.cloud.domain;

import javax.persistence.*;

@Entity
@Table(name="Address")
public class Address {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long addressId;

    private String streetName;
    private int unit;
    private String city;
    private String state;
    private int zip;
    private String country;
    @JoinColumn(name = "ACCOUNT_ID", nullable = false)
    private Long account;

    public Address() { super(); }

    public Address(Long addressId, String streetName, int unit, String city, String state, int zip, String country, Long account) {
        this.addressId = addressId;
        this.streetName = streetName;
        this.unit = unit;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
        this.account = account;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getAccount() {
        return account;
    }

    public void setAccount(Long account) {
        this.account = account;
    }
}
