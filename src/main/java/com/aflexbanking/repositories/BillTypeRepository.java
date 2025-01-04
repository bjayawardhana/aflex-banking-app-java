package com.aflexbanking.repositories;

import com.aflexbanking.models.BillType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillTypeRepository extends JpaRepository<BillType, Long> {
}
