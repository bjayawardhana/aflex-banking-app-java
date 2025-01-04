package com.aflexbanking;

import com.aflexbanking.models.Bank;
import com.aflexbanking.repositories.BankRepository;
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

class BankServiceTest {

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
        // Given
        Bank bank1 = new Bank();
        bank1.setId(1L);
        bank1.setName("Bank1");

        Bank bank2 = new Bank();
        bank2.setId(2L);
        bank2.setName("Bank2");

        when(bankRepository.findAll()).thenReturn(Arrays.asList(bank1, bank2));

        // When
        List<Bank> banks = bankService.getAllBanks();

        // Then
        assertNotNull(banks);
        assertEquals(2, banks.size());
        assertEquals("Bank1", banks.get(0).getName());
        assertEquals("Bank2", banks.get(1).getName());
        verify(bankRepository, times(1)).findAll();
    }

    @Test
    void testGetBankById() {
        // Given
        Bank bank = new Bank();
        bank.setId(1L);
        bank.setName("Test Bank");

        when(bankRepository.findById(1L)).thenReturn(Optional.of(bank));

        // When
        Bank foundBank = bankService.getBankById(1L);

        // Then
        assertNotNull(foundBank);
        assertEquals("Test Bank", foundBank.getName());
        verify(bankRepository, times(1)).findById(1L);
    }

    @Test
    void testGetBankById_NotFound() {
        // Given
        when(bankRepository.findById(1L)).thenReturn(Optional.empty());

        // When
        Bank foundBank = bankService.getBankById(1L);

        // Then
        assertNull(foundBank);
        verify(bankRepository, times(1)).findById(1L);
    }
}

