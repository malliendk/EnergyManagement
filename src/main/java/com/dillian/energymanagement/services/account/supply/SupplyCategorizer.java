package com.dillian.energymanagement.services.account.supply;

import com.dillian.energymanagement.SupplyType;
import com.dillian.energymanagement.entities.Account;
import com.dillian.energymanagement.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SupplyCategorizer {

    private final AccountRepository accountRepository;
    public void categorize(Account account){
        double supplyAmount = account.getSupplyAmount();
        if (supplyAmount >= 0.0 && supplyAmount < 0.9) {
            account.setSupplyType(SupplyType.SHORTAGE.toString());
        } else if (supplyAmount > 0.9 && supplyAmount <= 1.1) {
            account.setSupplyType(SupplyType.OPTIMAL.toString());
        } else if (supplyAmount > 1.1) {
            account.setSupplyType(SupplyType.SURPLUS.toString());
        } else {
            throw new IllegalArgumentException("Supply amount cannot be negative");
        }
        accountRepository.save(account);
    }
}
