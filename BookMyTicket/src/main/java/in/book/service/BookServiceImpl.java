package in.book.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import in.book.binding.Person;
import in.book.binding.Ticket;
import reactor.core.publisher.Mono;

@Service
public class BookServiceImpl implements BookService {

	private String urlget = "http://localhost:5000/ticket/{ticketnum}";
	private String urlsave = "http://localhost:5000/save";
	private String urlnumber = "http://localhost:5000/ticketnumber/{aadhar}";
	private String cancelurl = "http://localhost:5000/cancel/{ticketnum}";
	@Override
	public Ticket saveTicket(Person p) {
		WebClient webclient = WebClient.create();
		Ticket t = webclient.post().uri(urlsave).bodyValue(p).retrieve().bodyToMono(Ticket.class).block();
		return t;
	}

	@Override
	public Ticket getTicket(String ticketNumber) {
		WebClient webclient = WebClient.create();
		Ticket t = webclient.get().uri(urlget, ticketNumber).retrieve().bodyToMono(Ticket.class).block();
		return t;
	}

	@Override
	public String getNumber(Integer aadhar) {
		WebClient webclient = WebClient.create();
		return webclient.get().uri(urlnumber, aadhar).retrieve().bodyToMono(String.class).block();
	}

	@Override
	public String cancelTicket(String ticketNumber) {
		WebClient webclient = WebClient.create();
		return webclient.get().uri(cancelurl, ticketNumber).retrieve().bodyToMono(String.class).block();
	}

}
