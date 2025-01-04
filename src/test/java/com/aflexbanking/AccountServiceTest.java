package com.aflexbanking;

import com.aflexbanking.models.Account;
import com.aflexbanking.repositories.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllAccounts() {
        // Setup mock accounts
        Account account1 = new Account();
        account1.setId(1L);
        account1.setBalance(1000.0);

        Account account2 = new Account();
        account2.setId(2L);
        account2.setBalance(2000.0);

        when(accountRepository.findAll()).thenReturn(Arrays.asList(account1, account2));

        // Execute
        List<Account> accounts = accountService.getAllAccounts();

        // Verify
        assertNotNull(accounts);
        assertEquals(2, accounts.size());
        verify(accountRepository, times(1)).findAll();
    }

    @Test
    void testGetAccountById() {
        // Setup mock account
        Account account = new Account();
        account.setId(1L);
        account.setBalance(1000.0);
        when(accountRepository.findById(1L)).thenReturn(Optional.of(account));

        // Execute
        Account foundAccount = accountService.getAccountById(1L);

        // Verify
        assertNotNull(foundAccount);
        assertEquals(1000.0, foundAccount.getBalance());
        verify(accountRepository, times(1)).findById(1L);
    }

    @Test
    void testGetAccountById_NotFound() {
        // Setup mock for non-existing account
        when(accountRepository.findById(1L)).thenReturn(Optional.empty());

        // Execute
        Account foundAccount = accountService.getAccountById(1L);

        // Verify
        assertNull(foundAccount);
        verify(accountRepository, times(1)).findById(1L);
    }

    @Test
    void testCreateAccount() {
        // Setup account
        Account account = new Account();
        account.setId(1L);
        account.setBalance(1000.0);

        // Execute
        accountService.createAccount(account);

        // Verify
        verify(accountRepository, times(1)).save(account);
    }

    @Test
    void testDeleteAccount() {
        // Execute
        accountService.deleteAccount(1L);

        // Verify
        verify(accountRepository, times(1)).deleteById(1L);
    }
}
