package com.aflexbanking;

import com.aflexbanking.models.Transaction;
import com.aflexbanking.repositories.TransactionRepository;
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

class TransactionServiceTest {

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private TransactionService transactionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllTransactions() {
        // Given
        Transaction transaction1 = new Transaction();
        transaction1.setId(1L);
        transaction1.setAmount(150.0);

        Transaction transaction2 = new Transaction();
        transaction2.setId(2L);
        transaction2.setAmount(250.0);

        when(transactionRepository.findAll()).thenReturn(Arrays.asList(transaction1, transaction2));

        // When
        List<Transaction> transactions = transactionService.getAllTransactions();

        // Then
        assertNotNull(transactions);
        assertEquals(2, transactions.size());
        assertEquals(150.0, transactions.get(0).getAmount());
        assertEquals(250.0, transactions.get(1).getAmount());
        verify(transactionRepository, times(1)).findAll();
    }

    @Test
    void testGetTransactionById() {
        // Given
        Transaction transaction = new Transaction();
        transaction.setId(1L);
        transaction.setAmount(150.0);

        when(transactionRepository.findById(1L)).thenReturn(Optional.of(transaction));

        // When
        Transaction foundTransaction = transactionService.getTransactionById(1L);

        // Then
        assertNotNull(foundTransaction);
        assertEquals(150.0, foundTransaction.getAmount());
        verify(transactionRepository, times(1)).findById(1L);
    }

    @Test
    void testGetTransactionById_NotFound() {
        // Given
        when(transactionRepository.findById(1L)).thenReturn(Optional.empty());

        // When
        Transaction foundTransaction = transactionService.getTransactionById(1L);

        // Then
        assertNull(foundTransaction);
        verify(transactionRepository, times(1)).findById(1L);
    }
}
