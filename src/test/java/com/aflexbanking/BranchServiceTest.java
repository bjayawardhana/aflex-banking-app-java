package com.aflexbanking;

import com.aflexbanking.models.Branch;
import com.aflexbanking.repositories.BranchRepository;
import com.aflexbanking.services.BranchService;
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

public class BranchServiceTest {

    @Mock
    private BranchRepository branchRepository;

    @InjectMocks
    private BranchService branchService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllBranches() {
        // Setup mock branches
        Branch branch1 = new Branch();
        branch1.setId(1L);
        branch1.setName("Main Branch");

        Branch branch2 = new Branch();
        branch2.setId(2L);
        branch2.setName("Secondary Branch");

        when(branchRepository.findAll()).thenReturn(Arrays.asList(branch1, branch2));

        // Execute
        List<Branch> branches = branchService.getAllBranches();

        // Verify
        assertNotNull(branches);
        assertEquals(2, branches.size());
        assertEquals("Main Branch", branches.get(0).getName());
        assertEquals("Secondary Branch", branches.get(1).getName());
        verify(branchRepository, times(1)).findAll();
    }

    @Test
    void testGetBranchById() {
        // Given
        Branch branch = new Branch();
        branch.setId(1L);
        branch.setName("Main Branch");

        when(branchRepository.findById(1L)).thenReturn(Optional.of(branch));

        // When
        Branch foundBranch = branchService.getBranchById(1L);

        // Then
        assertNotNull(foundBranch);
        assertEquals("Main Branch", foundBranch.getName());
        verify(branchRepository, times(1)).findById(1L);
    }

    @Test
    void testGetBranchById_NotFound() {
        // Given
        when(branchRepository.findById(1L)).thenReturn(Optional.empty());

        // When
        Branch foundBranch = branchService.getBranchById(1L);

        // Then
        assertNull(foundBranch);
        verify(branchRepository, times(1)).findById(1L);
    }
}
