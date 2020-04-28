package com.ramesha.ecommerce.repository;

import com.ramesha.ecommerce.model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Integer> {
}
