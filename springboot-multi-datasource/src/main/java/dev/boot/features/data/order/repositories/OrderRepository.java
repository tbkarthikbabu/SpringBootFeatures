package dev.boot.features.data.order.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.boot.features.data.order.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
