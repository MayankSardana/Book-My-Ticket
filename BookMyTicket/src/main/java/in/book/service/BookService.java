package in.book.service;

import in.book.binding.Person;
import in.book.binding.Ticket;

public interface BookService {
	public Ticket saveTicket(Person p);
    
    public Ticket getTicket(String ticketNumber);
    
    public String  getNumber(Integer aadhar);
    
    public String cancelTicket(String ticketNumber);
    
}
