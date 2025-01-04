package com.aflexbanking.services;

import com.aflexbanking.models.BillType;
import com.aflexbanking.repositories.BillTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillTypeService {
    @Autowired
    private BillTypeRepository billTypeRepository;

    public List<BillType> getAllBillTypes() {
        return billTypeRepository.findAll();
    }

    public BillType getBillTypeById(Long id) {
        return billTypeRepository.findById(id).orElse(null);
    }
}
