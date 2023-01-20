package com.safarsathi.backend.dao;


import com.safarsathi.backend.entity.OrderDetail;
import org.springframework.data.repository.CrudRepository;

public interface OrderDetailDao extends CrudRepository<OrderDetail, Integer> {
}
