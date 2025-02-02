package in.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import in.api.entity.Person;
import in.api.entity.Ticket;
import in.api.service.ApiService;

@RestController
public class ApiController 
{
	@Autowired
	private ApiService service;
	
	@GetMapping("/")
    public String start() {
    	return "start";
    }
	
	@GetMapping("/ticket/{ticket}")
	public Ticket getTicket(@PathVariable("ticket") String ticket) {
		
		 Ticket t =  service.getTicket(ticket);
		 return t;
	}
	
	@GetMapping("/ticketnumber/{aadhar}")
	public String getTicketNumber(@PathVariable("aadhar") Integer aadhar)
	{
		return service.getNumber(aadhar);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Ticket> saveTicket(@RequestBody Person p)
	{
		return new ResponseEntity<>(service.saveTicket(p) , HttpStatus.CREATED);
	}
	
	@GetMapping("/cancel/{id}")
	public String cancelTicket(@PathVariable("id") String id) {
		   return service.cancelTicket(id);
	} 
	
}

