package com.dillian.energymanagement.controllers;

import com.dillian.energymanagement.dtos.AccountDto;
import com.dillian.energymanagement.services.account.AccountManagerFacade;
import com.dillian.energymanagement.services.account.AccountServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/account")
public class AccountController {

    private final AccountServiceImpl accountServiceImpl;
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
    public List<AccountDto> getAll() {
        return accountServiceImpl.findAll();
    }

    @GetMapping("shortage")
    public List<AccountDto> getShortageAccounts() {
        return accountServiceImpl.getShortageAccounts();
    }

    @GetMapping("optimal")
    public List<AccountDto> getOptimalAccounts() {
        return accountServiceImpl.getOptimalAccounts();
    }

    @GetMapping("surplus")
    public List<AccountDto> getSurplusAccounts() {
        return accountServiceImpl.getSurplusAccounts();
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
        accountServiceImpl.delete(id);
    }

    @PutMapping("optimize/start")
    public void startOptimizeSupply() {
        accountServiceImpl.startOptimizeSupply();
    }

    @PutMapping("optimize/stop")
    public void stopOptimizeSupply() {
        accountServiceImpl.stopOptimizeSupply();
    }
}
