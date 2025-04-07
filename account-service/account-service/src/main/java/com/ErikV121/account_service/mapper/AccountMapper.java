package com.ErikV121.account_service.mapper;

import com.ErikV121.account_service.dto.accountDto.AccountRequestDto;
import com.ErikV121.account_service.dto.accountDto.AccountResponseDto;
import com.ErikV121.account_service.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    @Mapping(target = "customerId", source = "customer.customerId")
    AccountResponseDto toAccountResponseDto(Account account);

    Account toAccount(AccountRequestDto accountRequestDto);
}
