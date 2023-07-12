package com.example.orderservice.service;

import com.example.orderservice.dto.OrderItemsDto;
import com.example.orderservice.dto.OrderRequest;
import com.example.orderservice.model.OrderItems;
import com.example.orderservice.model.OrderModel;
import com.example.orderservice.repository.OrderRepository;
import io.micrometer.observation.Observation;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    public void createOrder(OrderRequest orderRequest) {
        OrderModel order = new OrderModel();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderItems> orderLineItems = orderRequest.getOrderItems()
                .stream()
                .map(this::mapToDto)
                .toList();

        System.out.println("orderLineItems" + orderLineItems);
        order.setOrderItems(orderLineItems);

        log.info("Order created: {}", order.getOrderNumber());
        orderRepository.save(order);

    }

    private OrderItems mapToDto(OrderItemsDto orderLineItemsDto) {
        System.out.println("orderLineItemsDto" + orderLineItemsDto);
        OrderItems orderLineItems = new OrderItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
}
