package com.endava.practica2023.Repository;

import com.endava.practica2023.Domain.TicketCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketCategoryRepository extends JpaRepository<TicketCategory,Integer > {

}
