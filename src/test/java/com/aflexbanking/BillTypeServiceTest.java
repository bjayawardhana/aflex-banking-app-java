package com.aflexbanking;

import com.aflexbanking.models.BillType;
import com.aflexbanking.repositories.BillTypeRepository;
import com.aflexbanking.services.BillTypeService;
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

public class BillTypeServiceTest {

    @Mock
    private BillTypeRepository billTypeRepository;

    @InjectMocks
    private BillTypeService billTypeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllBillTypes() {
        // Setup mock bill types
        BillType billType1 = new BillType();
        billType1.setId(1L);
        billType1.setName("Electricity");

        BillType billType2 = new BillType();
        billType2.setId(2L);
        billType2.setName("Water");

        when(billTypeRepository.findAll()).thenReturn(Arrays.asList(billType1, billType2));

        // Execute
        List<BillType> billTypes = billTypeService.getAllBillTypes();

        // Verify
        assertNotNull(billTypes);
        assertEquals(2, billTypes.size());
        verify(billTypeRepository, times(1)).findAll();
    }

    @Test
    void testGetBillTypeById() {
        // Setup mock bill type
        BillType billType = new BillType();
        billType.setId(1L);
        billType.setName("Electricity");
        when(billTypeRepository.findById(1L)).thenReturn(Optional.of(billType));

        // Execute
        BillType foundBillType = billTypeService.getBillTypeById(1L);

        // Verify
        assertNotNull(foundBillType);
        assertEquals("Electricity", foundBillType.getName());
        verify(billTypeRepository, times(1)).findById(1L);
    }

    @Test
    void testGetBillTypeById_NotFound() {
        // Setup mock for non-existing bill type
        when(billTypeRepository.findById(1L)).thenReturn(Optional.empty());

        // Execute
        BillType foundBillType = billTypeService.getBillTypeById(1L);

        // Verify
        assertNull(foundBillType);
        verify(billTypeRepository, times(1)).findById(1L);
    }
}
