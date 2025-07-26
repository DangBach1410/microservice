package vti.dtn.account_service.service.impl;

import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;
import org.springframework.stereotype.Service;
import vti.dtn.account_service.dto.AccountDTO;
import vti.dtn.account_service.entity.AccountEntity;
import vti.dtn.account_service.repository.AccountRepository;
import vti.dtn.account_service.service.AccountService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    @Override
    public List<AccountDTO> getListAccounts() {

        List<AccountEntity> accountEntities = accountRepository.findAll();
        return accountEntities.stream().map(account -> new AccountDTO(
                        account.getId(),
                        account.getUsername(),
                        account.getFirstName(),
                        account.getLastName())).toList();
    }
}
