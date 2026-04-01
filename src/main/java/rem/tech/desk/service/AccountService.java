package rem.tech.desk.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import rem.tech.desk.dto.AccountResponse;
import rem.tech.desk.dto.RegistrationRequest;
import rem.tech.desk.model.Account;
import rem.tech.desk.repository.AccountRepository;

import java.time.LocalDateTime;

@Slf4j
@ApplicationScoped
public class AccountService {

    @Inject
    private AccountRepository accountRepository;

    public AccountResponse crateAccount(RegistrationRequest registrationRequest){
        Account account = accountRepository.save(regRequestToAccount(registrationRequest));
        return accountToResponse(account);
    }

    private Account regRequestToAccount(RegistrationRequest registrationRequest){
        Account account = new Account();
        account.setEmail(registrationRequest.email());
        account.setPassword(registrationRequest.password());
        account.setUsername(registrationRequest.username());
        account.setCreatedAt(LocalDateTime.now());
        return account;
    }

    private AccountResponse accountToResponse(Account account){
        return new AccountResponse(account.getUsername(), account.getConnectionId());
    }
}
