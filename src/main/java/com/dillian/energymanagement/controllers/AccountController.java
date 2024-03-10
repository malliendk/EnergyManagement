package com.dillian.energymanagement.controllers;

import com.dillian.energymanagement.dtos.AccountGenerateRequestDto;
import com.dillian.energymanagement.entities.Account;
import com.dillian.energymanagement.services.account.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/accounts")
public class AccountController {

    private final AccountService accountService;

    @PostMapping()
    public List<Account> generateAccounts(@RequestBody AccountGenerateRequestDto request) {
        return accountService.generateAccounts(request.getNumberOfAccounts());
    }

    @GetMapping()
    public List<Account> getAll() {
        return accountService.getAll();
    }

    @GetMapping("shortage")
    public List<Account> getShortageAccounts() {
        return accountService.getShortageAccounts();
    }

    @GetMapping("optimal")
    public List<Account> getOptimalAccounts() {
        return accountService.getOptimalAccounts();
    }

    @GetMapping("surplus")
    public List<Account> getSurplusAccounts() {
        return accountService.getSurplusAccounts();
    }

    @GetMapping("reset")
    public List<Account> resetAccounts() {
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
