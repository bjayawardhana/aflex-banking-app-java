package com.aflexbanking;

import com.aflexbanking.models.Bank;
import com.aflexbanking.repositories.BankRepository;
import com.aflexbanking.services.BankService;
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

public class BankServiceTest {

    @Mock
    private BankRepository bankRepository;

    @InjectMocks
    private BankService bankService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllBanks() {
        // Setup mock banks
        Bank bank1 = new Bank();
        bank1.setId(1L);
        bank1.setName("Bank A");

        Bank bank2 = new Bank();
        bank2.setId(2L);
        bank2.setName("Bank B");

        when(bankRepository.findAll()).thenReturn(Arrays.asList(bank1, bank2));

        // Execute
        List<Bank> banks = bankService.getAllBanks();

        // Verify
        assertNotNull(banks);
        assertEquals(2, banks.size());
        verify(bankRepository, times(1)).findAll();
    }

    @Test
    void testGetBankById() {
        // Setup mock bank
        Bank bank = new Bank();
        bank.setId(1L);
        bank.setName("Bank A");
        when(bankRepository.findById(1L)).thenReturn(Optional.of(bank));

        // Execute
        Bank foundBank = bankService.getBankById(1L);

        // Verify
        assertNotNull(foundBank);
        assertEquals("Bank A", foundBank.getName());
        verify(bankRepository, times(1)).findById(1L);
    }

    @Test
    void testGetBankById_NotFound() {
        // Setup mock for non-existing bank
        when(bankRepository.findById(1L)).thenReturn(Optional.empty());

        // Execute
        Bank foundBank = bankService.getBankById(1L);

        // Verify
        assertNull(foundBank);
        verify(bankRepository, times(1)).findById(1L);
    }
}
