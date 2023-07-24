package com.endava.practica2023.Service;

import com.endava.practica2023.Domain.TicketCategory;
import com.endava.practica2023.Repository.TicketCategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class TicketCategoryService {
    private final TicketCategoryRepository ticketCategoryRepository;

    public TicketCategoryService(TicketCategoryRepository ticketCategoryRepository){
        this.ticketCategoryRepository = ticketCategoryRepository;
    }

    public TicketCategory findById(Integer id){
        return ticketCategoryRepository.findById(id).get();
    }
}
