package com.transportation.AutoTransportation.repository;

import com.transportation.AutoTransportation.models.AcceptOrder;
import com.transportation.AutoTransportation.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcceptOrderRepository extends JpaRepository<AcceptOrder, Long> {
    AcceptOrder findByUserId(Long id);
}
