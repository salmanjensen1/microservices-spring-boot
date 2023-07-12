package com.example.inventoryservice;

import com.example.inventoryservice.model.InventoryModel;
import com.example.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
		return args -> {
			InventoryModel inventory = new InventoryModel();
			inventory.setSkuCode("ABC123");
			inventory.setQuantity(10);

			InventoryModel inventory1 = new InventoryModel();
			inventory1.setSkuCode("pringles");
			inventory1.setQuantity(3);

			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory1);
		};
	}
}
