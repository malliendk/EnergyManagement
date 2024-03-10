package com.dillian.energymanagement.services.supply;

import com.dillian.energymanagement.dtos.AccountDto;
import com.dillian.energymanagement.entities.Account;
import com.dillian.energymanagement.mappers.DtoMapper;
import com.dillian.energymanagement.repositories.AccountRepository;
import com.dillian.energymanagement.utils.Constants;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class SupplyOptimizer {

    private final AccountRepository accountRepository;
    private final DtoMapper<Account, AccountDto> mapper;
    private static final Random random = new Random();

    public List<AccountDto> updateSupplyAmount(List<AccountDto> accounts) {
        accounts.forEach(accountDto -> {
            double supplyAmount = accountDto.getSupplyAmount();
            double newSupplyAmount = 0;
            switch (accountDto.getSupplyType()) {
                case Constants.SHORTAGE -> newSupplyAmount = supplyAmount + supplyAmount * 0.25;
                case Constants.OPTIMAL -> newSupplyAmount = randomForOptimal(accountDto);
                case Constants.SURPLUS -> newSupplyAmount = supplyAmount - supplyAmount * 0.25;
                default -> throw new RuntimeException("supplyType did not match a valid String");
            }
            accountDto.setSupplyAmount(newSupplyAmount);
            Account account = mapper.toEntity(accountDto);
            accountRepository.save(account);
        });
        return accounts;
    }

    private double randomForOptimal(AccountDto account) {
        double supplyAmount = account.getSupplyAmount();
        if (supplyAmount < 1) {
            return supplyAmount + selectRandomValue(new double[] {0, 0.05, 0.1, 0.25, 0.5});
        } else {
            return supplyAmount + selectRandomValue(new double[] {-0.5, -0.25, -0.1, -0.05, 0});
        }
    }

    private double selectRandomValue(double[] addOrSubtractValues) {
        int randomIndex = random.nextInt(addOrSubtractValues.length);
        return addOrSubtractValues[randomIndex];
    }
}
