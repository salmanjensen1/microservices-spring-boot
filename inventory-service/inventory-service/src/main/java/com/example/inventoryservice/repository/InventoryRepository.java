package com.example.inventoryservice.repository;

import com.example.inventoryservice.model.InventoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<InventoryModel, Long> {
    Optional<InventoryModel> findBySkuCodeIn(List<String> skuCode);
}
