package com.endava.practica2023.Service;

import com.endava.practica2023.Domain.Orders;
import com.endava.practica2023.Domain.TicketCategory;
import com.endava.practica2023.Domain.Venue;
import com.endava.practica2023.Domain.dto.OrdersDTO;
import com.endava.practica2023.Repository.OrdersRepository;
import com.endava.practica2023.Repository.TicketCategoryRepository;
import com.endava.practica2023.Repository.VenueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdersService {
    private final OrdersRepository ordersRepository;
    private final TicketCategoryRepository ticketCategoryRepository;
    private final VenueRepository venueRepository;

    public OrdersService (OrdersRepository ordersRepository, TicketCategoryRepository ticketCategoryRepository,VenueRepository venueRepository) {

        this.ordersRepository = ordersRepository;
        this.ticketCategoryRepository = ticketCategoryRepository;
        this.venueRepository = venueRepository;

    }

    public List<OrdersDTO> getOrders(Integer id){
       TicketCategory ticketCategory = ticketCategoryRepository.findById(id).get();

        return ordersRepository.findOrdersByTicketCategory(ticketCategory)
                .stream()
                .map(orders -> new OrdersDTO(
                        orders.getTicketCategory().getEventss().getEventId(),
                        orders.getOrderedAt(),
                        orders.getTicketCategory().getTicket_category_id(),
                        orders.getNumber_of_tickets(),
                        orders.getOrder_total_price()
                )).collect(Collectors.toList());
    }

    public String postOrders(Orders order, OrdersDTO ordersDto){
       if(order != null){

           Integer venueId = order.getTicketCategory().getEventss().getVenue().getVenueId();
           Venue venue = venueRepository.findById(venueId).get();
           if(venue != null){
               Integer ticketsLeft = venue.getCapacity() - order.getNumber_of_tickets();
               if(ticketsLeft >= 0){
                   venue.setCapacity(ticketsLeft);
                   venueRepository.save(venue);
                   ordersRepository.save(order);
                   return "order: " + ordersDto.toString();
               }
               else return "There are not enough available tickets for sale!";
           }

       }
       return "Cannot create order!";
    }

}
