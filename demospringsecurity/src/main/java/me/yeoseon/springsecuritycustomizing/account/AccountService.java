package me.yeoseon.springsecuritycustomizing.account;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

@Service
public class AccountService implements UserDetailsService {

    @Autowired
    AccountRepository accountRepository;

    public Account createAccount(String username, String password) {
        Account account = new Account();

        account.setUsername(username);
        account.setPassword(password);

        return accountRepository.save(account);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> byUsername = accountRepository.findByUsername(username);
        Account account = byUsername.orElseThrow(() -> new UsernameNotFoundException(username));        // User 정보가 앖으면 Exception을 발생시키고, 있으면 account에 담는다.

        return new User(account.getUsername(), account.getPassword(), authorites());
    }

    private Collection<? extends GrantedAuthority> authorites() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }
}
