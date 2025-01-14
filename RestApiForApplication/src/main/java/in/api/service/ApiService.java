package in.api.service;


import org.springframework.stereotype.Service;

import in.api.entity.Person;
import in.api.entity.Ticket;

@Service
public interface ApiService {
	
     public Ticket saveTicket(Person p);
     
     public Ticket getTicket(String ticketNumber);
     
     public String  getNumber(Integer aadhar);
     
     public String cancelTicket(String ticketNumber);
     
}
