package com.solstice.cloud.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Account")
public class Account {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long accountId;
    private String firstName;
    private String lastName;
    private String emailAddress;
//    private Long addressId;
//    @OneToMany
//    @JoinColumn(name = "accountId" )
//    List<Address> address;

    public Account() {}

    public Account(Long accountId, String firstName, String lastName, String emailAddress) {
        this.accountId = accountId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;

    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

}
