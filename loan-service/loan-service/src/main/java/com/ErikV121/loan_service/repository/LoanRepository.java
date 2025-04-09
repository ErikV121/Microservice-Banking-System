package com.ErikV121.loan_service.repository;

import com.ErikV121.loan_service.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
