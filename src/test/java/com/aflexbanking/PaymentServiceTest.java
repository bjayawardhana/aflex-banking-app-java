package com.aflexbanking;

import com.aflexbanking.models.Payment;
import com.aflexbanking.repositories.PaymentRepository;
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

class PaymentServiceTest {

    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private PaymentService paymentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllPayments() {
        // Given
        Payment payment1 = new Payment();
        payment1.setId(1L);
        payment1.setAmount(100.0);

        Payment payment2 = new Payment();
        payment2.setId(2L);
        payment2.setAmount(200.0);

        when(paymentRepository.findAll()).thenReturn(Arrays.asList(payment1, payment2));

        // When
        List<Payment> payments = paymentService.getAllPayments();

        // Then
        assertNotNull(payments);
        assertEquals(2, payments.size());
        assertEquals(100.0, payments.get(0).getAmount());
        assertEquals(200.0, payments.get(1).getAmount());
        verify(paymentRepository, times(1)).findAll();
    }

    @Test
    void testGetPaymentById() {
        // Given
        Payment payment = new Payment();
        payment.setId(1L);
        payment.setAmount(100.0);

        when(paymentRepository.findById(1L)).thenReturn(Optional.of(payment));

        // When
        Payment foundPayment = paymentService.getPaymentById(1L);

        // Then
        assertNotNull(foundPayment);
        assertEquals(100.0, foundPayment.getAmount());
        verify(paymentRepository, times(1)).findById(1L);
    }

    @Test
    void testGetPaymentById_NotFound() {
        // Given
        when(paymentRepository.findById(1L)).thenReturn(Optional.empty());

        // When
        Payment foundPayment = paymentService.getPaymentById(1L);

        // Then
        assertNull(foundPayment);
        verify(paymentRepository, times(1)).findById(1L);
    }
}
