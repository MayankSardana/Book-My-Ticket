package in.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import in.book.binding.CancelTicket;
import in.book.binding.Person;
import in.book.binding.Ticket;
import in.book.binding.TicketView;
import in.book.service.BookService;

@Controller
public class BookController 
{ 
	@Autowired
	private BookService service;
	
     public String load() {
    	 return "index";
     }
     
     @GetMapping("/book")
     public String BookTicket(Model model) {
    	 model.addAttribute("person", new Person());
    	 return "Book";
     }
     
     @PostMapping("/saveTicket")
     public String bookTicket(@ModelAttribute("person") Person p , Model model) {
    	 Ticket tt = service.saveTicket(p);
    	 model.addAttribute("ticket","your Ticket Number is : " + tt.getTicketNumber());
    	 model.addAttribute("msg", "Ticket Booked");
    	 model.addAttribute("person", new Person());
    	 return "Book";
     }
     
     @GetMapping("/cancel")
     public String Cancel(Model model) {
    	 model.addAttribute("cancel" ,new CancelTicket());
    	 return "Cancel";
     }
     
     @PostMapping("/cancelticket")
     public String CancelTicket(@ModelAttribute("cancel") CancelTicket cancel , Model model) {
    	 String sd = service.cancelTicket(cancel.getTicketnumber());
    	 if(!sd.equals("Sorry your Ticket is not avaliable !!")) {
    		 model.addAttribute("m", "m");
    		 model.addAttribute("er",sd);
    	 }else {
    		 model.addAttribute("m", null);
    		 model.addAttribute("er",sd);
    	 }
    	  return "Cancel";
     }
     
    
     @GetMapping("/view")
     public String ViewTicket(Model model) {
    	 model.addAttribute("view", new TicketView());
    	 return "Ticket";
     }
     
     @PostMapping("/viewticket")
     public String ViewSaveTicket(@ModelAttribute("view") TicketView v , Model model) {
    	 Ticket t = service.getTicket(v.getTicketnumber());
    	 if(t!=null) {
    	 model.addAttribute("name" , t.getName());
    	 model.addAttribute("phone" , t.getPhoneNumber());
    	 model.addAttribute("aadhar" , t.getAadhaarCard());
    	 model.addAttribute("start" , t.getStart());
    	 model.addAttribute("end" , t.getEnd());
    	 model.addAttribute("status" , t.getStatus());
    	 model.addAttribute("number" , t.getTicketNumber());
    	 model.addAttribute("price" ,  "  Rs " + t.getPrice());
    	 }
    	 return "Ticket";
     } 
     
     @GetMapping("/ticket")
     public String TicketNumber(Model model) {
    	 model.addAttribute("number", new in.book.binding.TicketNumber());
    	 return "Number";
     }
     
     @PostMapping("/getticket")
     public String GetTicketNumber(@ModelAttribute("number") in.book.binding.TicketNumber number , Model model) {
         String str = service.getNumber(number.getAadhar());
         if(str!=null) {
        	 model.addAttribute("m", "m");
         model.addAttribute("str", "Your Ticket Number is " + str);
         }else {
        	 model.addAttribute("m", null);
        	 model.addAttribute("str", "Your Ticket Number is not available"); 
         }
    	 return "Number";
     }
     
    
}
