package com.dillian.energymanagement.services.account.supply;

import com.dillian.energymanagement.entities.Account;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SupplyMeanCalculator {

    public double calculateMean(List<Account> accounts) {
        return accounts.stream()
                .mapToDouble(Account::getSupplyAmount)
                .average()
                .orElse(Double.NaN);
    }
}
