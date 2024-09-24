package com.dillian.energymanagement.controllers;

import com.dillian.energymanagement.dtos.AccountDto;
import com.dillian.energymanagement.dtos.AccountRequestDto;
import com.dillian.energymanagement.services.AccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/account")
@Slf4j
public class AccountController {

    private final AccountService accountService;


    @GetMapping("all")
    public ResponseEntity<List<AccountDto>> findAll() {
        return ResponseEntity
                .ok(accountService.getAll());
    }

    @GetMapping("multiple")
    public ResponseEntity<List<AccountDto>> findMultiple(@RequestBody AccountRequestDto requestDto) {
        return ResponseEntity
                .ok(accountService.getForDto(requestDto.getOffset(), requestDto.getLimit()));
    }
}
