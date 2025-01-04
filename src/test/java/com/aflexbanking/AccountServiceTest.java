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
        // Given
        Account account1 = new Account();
        account1.setId(1L);
        account1.setName("Account1");

        Account account2 = new Account();
        account2.setId(2L);
        account2.setName("Account2");

        when(accountRepository.findAll()).thenReturn(Arrays.asList(account1, account2));

        // When
        List<Account> accounts = accountService.getAllAccounts();

        // Then
        assertNotNull(accounts);
        assertEquals(2, accounts.size());
        assertEquals("Account1", accounts.get(0).getName());
        assertEquals("Account2", accounts.get(1).getName());
        verify(accountRepository, times(1)).findAll();
    }

    @Test
    void testGetAccountById() {
        // Given
        Account account = new Account();
        account.setId(1L);
        account.setName("Test Account");

        when(accountRepository.findById(1L)).thenReturn(Optional.of(account));

        // When
        Account foundAccount = accountService.getAccountById(1L);

        // Then
        assertNotNull(foundAccount);
        assertEquals("Test Account", foundAccount.getName());
        verify(accountRepository, times(1)).findById(1L);
    }

    @Test
    void testCreateAccount() {
        // Given
        Account account = new Account();
        account.setName("New Account");

        // When
        accountService.createAccount(account);

        // Then
        verify(accountRepository, times(1)).save(account);
    }

    @Test
    void testDeleteAccount() {
        // Given
        Long accountId = 1L;

        // When
        accountService.deleteAccount(accountId);

        // Then
        verify(accountRepository, times(1)).deleteById(accountId);
    }
}
