package com.dillian.energymanagement.controllers;

import com.dillian.energymanagement.dtos.AccountDto;
import com.dillian.energymanagement.services.account.AccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/account")
@Slf4j
public class AccountController {

    private final AccountService accountService;
    private final AccountManagerFacade accountManagerFacade;


    @PostMapping()
    public AccountDto create(AccountDto dto) {
        return accountManagerFacade.mapAndCreate(dto);
    }

//    @PostMapping("generate")
//    public List<Account> generateAccounts(@RequestBody AccountGenerateRequestDto request) {
//        return recordSaver.saveAccounts(request.getNumberOfAccounts());
//    }

    @GetMapping()
    public List<AccountDto> findAll() {
        return accountService.findAll();
    }

    @GetMapping("/locality/{localityName}")
    public List<AccountDto> findAllByLocality(@PathVariable String localityName) {
        return accountService.findAllByLocality(localityName);
    }

//    @GetMapping("reset")
//    public List<AccountDto> resetAccounts() {
//        return accountServiceImpl.resetAccounts();
//    }

    @PutMapping("{id}")
    public AccountDto update(@PathVariable Long id, @RequestBody AccountDto dto) {
        return accountManagerFacade.mapAndUpdate(id, dto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        accountService.delete(id);
    }

    @PutMapping("optimize/start")
    public void startOptimizeSupply() {
        accountService.startOptimizeSupply();
    }

    @PutMapping("optimize/stop")
    public void stopOptimizeSupply() {
        accountService.stopOptimizeSupply();
    }
}