package com.example.springbootwithjpa.api.dto;

import com.example.springbootwithjpa.domain.Address;
import com.example.springbootwithjpa.domain.Order;
import com.example.springbootwithjpa.domain.OrderStatus;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long orderId;
    private String name;
    private LocalDateTime orderDate;
    private OrderStatus orderStatus;
    private Address address;
    private List<OrderItemDto> orderItems;

    public static OrderDto of(Order order) {
        return new OrderDto(
            order.getId(),
            order.getMemberName(),
            order.getOrderDate(),
            order.getStatus(),
            order.getDeliveryAddress(),
            order.getOrderItems().stream()
                .map(OrderItemDto::of)
                .collect(Collectors.toList())
        );
    }
}
