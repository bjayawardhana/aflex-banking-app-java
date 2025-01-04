package com.aflexbanking;

import com.aflexbanking.models.BillType;
import com.aflexbanking.repositories.BillTypeRepository;
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

class BillTypeServiceTest {

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
        // Given
        BillType billType1 = new BillType();
        billType1.setId(1L);
        billType1.setName("Electricity");

        BillType billType2 = new BillType();
        billType2.setId(2L);
        billType2.setName("Water");

        when(billTypeRepository.findAll()).thenReturn(Arrays.asList(billType1, billType2));

        // When
        List<BillType> billTypes = billTypeService.getAllBillTypes();

        // Then
        assertNotNull(billTypes);
        assertEquals(2, billTypes.size());
        assertEquals("Electricity", billTypes.get(0).getName());
        assertEquals("Water", billTypes.get(1).getName());
        verify(billTypeRepository, times(1)).findAll();
    }

    @Test
    void testGetBillTypeById() {
        // Given
        BillType billType = new BillType();
        billType.setId(1L);
        billType.setName("Internet");

        when(billTypeRepository.findById(1L)).thenReturn(Optional.of(billType));

        // When
        BillType foundBillType = billTypeService.getBillTypeById(1L);

        // Then
        assertNotNull(foundBillType);
        assertEquals("Internet", foundBillType.getName());
        verify(billTypeRepository, times(1)).findById(1L);
    }

    @Test
    void testGetBillTypeById_NotFound() {
        // Given
        when(billTypeRepository.findById(1L)).thenReturn(Optional.empty());

        // When
        BillType foundBillType = billTypeService.getBillTypeById(1L);

        // Then
        assertNull(foundBillType);
        verify(billTypeRepository, times(1)).findById(1L);
    }
}
