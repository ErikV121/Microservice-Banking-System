package com.ErikV121.loan_service.mapper;

import com.ErikV121.loan_service.dto.loanDto.LoanRequestDto;
import com.ErikV121.loan_service.dto.loanDto.LoanResponseDto;
import com.ErikV121.loan_service.entity.Loan;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoanMapper {
    LoanResponseDto toLoanResponseDto(Loan loan);

    Loan toLoan(LoanRequestDto loanRequestDto);
}
