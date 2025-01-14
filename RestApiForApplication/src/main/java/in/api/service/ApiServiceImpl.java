package in.api.service;

import in.api.entity.Person;
import in.api.entity.Ticket;
import in.api.repository.TicketRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiServiceImpl implements ApiService 
{

	Integer tt = 2312;
	@Autowired
	private TicketRepository ticketRepo;
	
	@Override
	public Ticket saveTicket(Person p) {
		Ticket ticket = new Ticket();
		ticket.setAadhaarCard(p.getAadhaarCard());
		ticket.setName(p.getName());
		ticket.setStart(p.getStart());
		ticket.setEnd(p.getEnd());
		ticket.setStatus("CONFIRMED");
		ticket.setPhoneNumber(p.getPhoneNumber());
		ticket.setTicketNumber(p.getName().charAt(1) + "" + p.getStart().charAt(0) + tt + p.getEnd().substring(0 , 2));
		int min = 6000;
		int max = 10000;
		Integer randomNum = min + (int)(Math.random() * ((max-min) + 1));
        ticket.setPrice(randomNum);
		ticketRepo.save(ticket); 
		tt = tt + 1111;
		
		return ticket;
	}

	@Override
	public Ticket getTicket(String ticketNumber) {
		Optional<Ticket> op = ticketRepo.findById(ticketNumber);
		if(op.isPresent()) {
			 return op.get();
		}
		return null;
	}

	@Override
	public String getNumber(Integer aadhar) {
		List<Ticket> list = ticketRepo.findByAadhaarCard(aadhar);
		if(list.size()>0) {
			 return list.get(0).getTicketNumber();
		}
		return null;
	}

	@Override
	public String cancelTicket(String ticketNumber) {
		Optional<Ticket> op = ticketRepo.findById(ticketNumber);
		if(op.isPresent()) {
			ticketRepo.delete(op.get());
			return "Congratulations your Ticket is deleted !!";
		}
		return "Sorry your Ticket is not avaliable !!";
	}

}
