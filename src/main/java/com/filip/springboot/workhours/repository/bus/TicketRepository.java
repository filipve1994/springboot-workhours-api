package com.filip.springboot.workhours.repository.bus;

import com.filip.springboot.workhours.model.bus.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Arpit Khandelwal.
 */
public interface TicketRepository extends MongoRepository<Ticket, Long> {
}
