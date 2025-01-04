package com.aflexbanking;

import com.aflexbanking.models.Branch;
import com.aflexbanking.repositories.BranchRepository;
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

class BranchServiceTest {

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
        verify(branchRepository, times(1)).
