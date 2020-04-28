package com.ramesha.ecommerce.service;

import com.ramesha.ecommerce.model.CustomerOrder;

import java.util.List;
import java.util.Optional;

public interface CustomerOrderService {
    CustomerOrder addOrder(CustomerOrder customerOrder);
    List<CustomerOrder> getAllOrders();
    Optional<CustomerOrder> getOrderById(Integer id);
}
