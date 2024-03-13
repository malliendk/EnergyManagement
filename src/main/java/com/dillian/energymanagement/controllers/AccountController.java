package com.dillian.energymanagement.controllers;

import com.dillian.energymanagement.bootstrap.SampleRecordSaver;
import com.dillian.energymanagement.dtos.AccountDto;
import com.dillian.energymanagement.dtos.AccountGenerateRequestDto;
import com.dillian.energymanagement.entities.Account;
import com.dillian.energymanagement.services.account.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/accounts")
public class AccountController {

    private final AccountService accountService;
    private final SampleRecordSaver recordSaver;


    @PostMapping()
    public List<Account> generateAccounts(@RequestBody AccountGenerateRequestDto request) {
        return recordSaver.saveAccounts(request.getNumberOfAccounts());
    }

    @GetMapping()
    public List<AccountDto> getAll() {
        return accountService.getAll();
    }

    @GetMapping("shortage")
    public List<AccountDto> getShortageAccounts() {
        return accountService.getShortageAccounts();
    }

    @GetMapping("optimal")
    public List<AccountDto> getOptimalAccounts() {
        return accountService.getOptimalAccounts();
    }

    @GetMapping("surplus")
    public List<AccountDto> getSurplusAccounts() {
        return accountService.getSurplusAccounts();
    }

    @GetMapping("reset")
    public List<AccountDto> resetAccounts() {
        return accountService.resetAccounts();
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
