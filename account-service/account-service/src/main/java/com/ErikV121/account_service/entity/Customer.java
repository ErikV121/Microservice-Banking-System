package com.ErikV121.account_service.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table
public class Customer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "customer_id", updatable = false)
    private UUID customerId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "social_security_number")
    private String ssn;

    public Customer() {}

    public Customer(String name, String email, String mobileNumber, String ssn) {
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.ssn = ssn;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
