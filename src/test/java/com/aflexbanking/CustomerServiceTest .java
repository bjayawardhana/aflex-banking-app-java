package com.aflexbanking;

import com.aflexbanking.models.Customer;
import com.aflexbanking.repositories.CustomerRepository;
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

class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllCustomers() {
        // Given
        Customer customer1 = new Customer();
        customer1.setId(1L);
        customer1.setName("John Doe");

        Customer customer2 = new Customer();
        customer2.setId(2L);
        customer2.setName("Jane Smith");

        when(customerRepository.findAll()).thenReturn(Arrays.asList(customer1, customer2));

        // When
        List<Customer> customers = customerService.getAllCustomers();

        // Then
        assertNotNull(customers);
        assertEquals(2, customers.size());
        assertEquals("John Doe", customers.get(0).getName());
        assertEquals("Jane Smith", customers.get(1).getName());
        verify(customerRepository, times(1)).findAll();
    }

    @Test
    void testGetCustomerById() {
        // Given
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("John Doe");

        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));

        // When
        Customer foundCustomer = customerService.getCustomerById(1L);

        // Then
        assertNotNull(foundCustomer);
        assertEquals("John Doe", foundCustomer.getName());
        verify(customerRepository, times(1)).findById(1L);
    }

    @Test
    void testGetCustomerById_NotFound() {
        // Given
        when(customerRepository.findById(1L)).thenReturn(Optional.empty());

        // When
        Customer foundCustomer = customerService.getCustomerById(1L);

        // Then
        assertNull(foundCustomer);
        verify(customerRepository, times(1)).findById(1L);
    }

    @Test
    void testCreateCustomer() {
        // Given
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("John Doe");

        // When
        customerService.createCustomer(customer);

        // Then
        verify(customerRepository, times(1)).save(customer);
    }
}
