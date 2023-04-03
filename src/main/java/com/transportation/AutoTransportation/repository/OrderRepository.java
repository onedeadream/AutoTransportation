package com.transportation.AutoTransportation.repository;

import com.transportation.AutoTransportation.models.Order;
import com.transportation.AutoTransportation.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findUserById(Long id);
}
