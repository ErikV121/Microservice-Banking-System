package com.ErikV121.loan_service.service;

import com.ErikV121.loan_service.dto.loanDto.LoanRequestDto;
import com.ErikV121.loan_service.dto.loanDto.LoanResponseDto;
import com.ErikV121.loan_service.entity.Loan;
import com.ErikV121.loan_service.mapper.LoanMapper;
import com.ErikV121.loan_service.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {
    private final LoanRepository loanRepository;
    private final LoanMapper loanMapper;

    public LoanService(LoanRepository loanRepository, LoanMapper loanMapper) {
        this.loanRepository = loanRepository;
        this.loanMapper = loanMapper;
    }

    //TODO implement CRUD

    public LoanResponseDto createLoan(LoanRequestDto loanRequestDto) {
        return null;
    }

    public LoanResponseDto getLoanById(Long id) {
        return null;
    }

    public List<LoanResponseDto> getAllLoans() {
        return null;
    }

    public LoanResponseDto updateLoan(Long id, LoanRequestDto loanRequestDto) {
        return null;
    }

    public void deleteLoan(Long id) {
    }

}
