package com.endava.practica2023.Controller;

import com.endava.practica2023.Domain.Orders;
import com.endava.practica2023.Domain.TicketCategory;
import com.endava.practica2023.Domain.dto.OrdersDTO;
import com.endava.practica2023.Service.OrdersService;
import com.endava.practica2023.Service.TicketCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class OrdersController {
    private final OrdersService ordersService;

    private final TicketCategoryService ticketCategoryService;

    public OrdersController(OrdersService ordersService,TicketCategoryService ticketCategoryService){

        this.ordersService = ordersService;
        this.ticketCategoryService = ticketCategoryService;
    }

    public Orders toOrders(OrdersDTO ordersDTO){
        Orders order = null;
        Integer ticketCategoryId = ordersDTO.ticketCategoryId();
        TicketCategory ticketCategory = ticketCategoryService.findById(ticketCategoryId);
        if(ticketCategory != null) {
            LocalDateTime dateTime = LocalDateTime.now();
            Integer numberOfTickets = ordersDTO.number_of_tickets();
            Float categoryPrice = ticketCategory.getTicket_category_price();
            Float totalPrice = numberOfTickets * categoryPrice;
            Integer userId = 1;
            order = new Orders(dateTime, 1, ticketCategory,numberOfTickets,totalPrice);
        }
        return order;
    }

    public OrdersDTO toDto(Orders order){
        Integer eventId = order.getTicketCategory().getEventss().getEventId();
        return new OrdersDTO(eventId, order.getOrderedAt(),
                order.getTicketCategory().getTicket_category_id(),
                order.getNumber_of_tickets(),order.getOrder_total_price());
    }

    @GetMapping("/api/getOrders")
    public List<OrdersDTO> getOrders(){
        return ordersService.getOrders(1);
    }

    @PostMapping("/api/postOrders")
    @ResponseStatus(code = HttpStatus.CREATED)
    @ResponseBody
    public String postEvents(@RequestBody OrdersDTO orderDto)
    {
        Orders order = toOrders(orderDto);
        return ordersService.postOrders(order, toDto(order));
    }
}
