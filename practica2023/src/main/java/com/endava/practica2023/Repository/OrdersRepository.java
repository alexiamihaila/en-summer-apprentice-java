package com.endava.practica2023.Repository;

import com.endava.practica2023.Domain.Orders;
import com.endava.practica2023.Domain.TicketCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    List<Orders> findOrdersByTicketCategory(TicketCategory ticket_category_id);

}
