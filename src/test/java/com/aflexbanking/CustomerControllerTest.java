package com.aflexbanking.controllers;

import com.aflexbanking.models.Customer;
import com.aflexbanking.services.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    private Customer testCustomer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        testCustomer = new Customer();
        testCustomer.setName("John Doe");
        testCustomer.setEmail("john.doe@example.com");
        testCustomer.setPhoneNumber("1234567890");
        testCustomer.setEmploymentDetails("Software Engineer");
        testCustomer.setBankAccount("123456789");
    }

    @Test
    void testRegisterCustomerSuccess() {
        when(customerService.registerCustomer(any(Customer.class))).thenReturn(testCustomer);

        ResponseEntity<String> response = customerController.registerCustomer(testCustomer);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Customer successfully registered.", response.getBody());
        verify(customerService, times(1)).registerCustomer(any(Customer.class));
    }

    @Test
    void testRegisterCustomerMissingField() {
        testCustomer.setEmail(null);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            customerController.registerCustomer(testCustomer);
        });

        assertEquals("Email is required.", exception.getMessage());
        verify(customerService, times(0)).registerCustomer(any(Customer.class));
    }

    @Test
    void testRegisterCustomerInvalidEmail() {
        testCustomer.setEmail("invalid-email");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            customerController.registerCustomer(testCustomer);
        });

        assertEquals("Invalid email format.", exception.getMessage());
        verify(customerService, times(0)).registerCustomer(any(Customer.class));
    }

    @Test
    void testRegisterCustomerDuplicate() {
        when(customerService.registerCustomer(any(Customer.class)))
                .thenThrow(new IllegalArgumentException("Customer with this email/account already exists."));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            customerController.registerCustomer(testCustomer);
        });

        assertEquals("Customer with this email/account already exists.", exception.getMessage());
        verify(customerService, times(1)).registerCustomer(any(Customer.class));
    }

    @Test
    void testRegisterCustomerGeneratesUniqueId() {
        when(customerService.registerCustomer(any(Customer.class))).thenAnswer(invocation -> {
            Customer customer = invocation.getArgument(0);
            customer.setId(1L); // Simulate ID generation
            return customer;
        });

        ResponseEntity<String> response = customerController.registerCustomer(testCustomer);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Customer successfully registered.", response.getBody());
        assertNotNull(testCustomer.getId());
        assertEquals(1L, testCustomer.getId());
    }
}
