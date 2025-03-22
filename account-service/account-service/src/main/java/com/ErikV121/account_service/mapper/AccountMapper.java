package com.ErikV121.account_service.mapper;

import com.ErikV121.account_service.dto.accountDto.AccountRequestDto;
import com.ErikV121.account_service.dto.accountDto.AccountResponseDto;
import com.ErikV121.account_service.entity.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountResponseDto toAccountResponseDto(Account account);

    Account toAccount(AccountRequestDto accountRequestDto);
}
