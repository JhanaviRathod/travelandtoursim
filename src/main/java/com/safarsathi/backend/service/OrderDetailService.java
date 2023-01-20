package com.safarsathi.backend.service;

import com.safarsathi.backend.configuration.JwtRequestFilter;
import com.safarsathi.backend.dao.OrderDetailDao;
import com.safarsathi.backend.dao.PackageDao;
import com.safarsathi.backend.dao.UserDao;
import com.safarsathi.backend.entity.*;
import com.safarsathi.backend.entity.Package;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {

    private static String ORDER_PLACED = "Placed";

    @Autowired
    private OrderDetailDao orderDetailDao;
    @Autowired
    private PackageDao packageDao;
    @Autowired
    private UserDao userDao;
    public void placeOrder(OrderInput orderInput){
        List<OrderPackageQuantity> packageQuantityList = orderInput.getOrderPackageQuantityList();

        for(OrderPackageQuantity o : packageQuantityList){
           Package pack =  packageDao.findById(o.getPackageId()).get();

            String currentUser = JwtRequestFilter.CURRENT_USER;
            User user = userDao.findById(currentUser).get();
            OrderDetail orderDetail = new OrderDetail(
                    orderInput.getFullname(),
                    orderInput.getFullAddress(),
                    orderInput.getContactNumber(),
                    orderInput.getAlternatecontactNumber(),
                    ORDER_PLACED,
                    pack.getPackageDiscountedPrice() * o.getQuantity(),
                    pack,
                    user

            );

            orderDetailDao.save(orderDetail);
        }
    }

    public List<OrderDetail> getAllOrderDetails(){
        return (List<OrderDetail>)orderDetailDao.findAll();
    }
}
