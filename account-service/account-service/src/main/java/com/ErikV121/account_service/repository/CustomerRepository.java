package com.ErikV121.account_service.repository;

import com.ErikV121.account_service.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findBySsn(String ssn);
}
