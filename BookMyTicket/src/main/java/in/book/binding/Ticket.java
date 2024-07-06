package in.book.binding;

import lombok.Data;

@Data
public class Ticket {
    
	Integer aadhaarCard;
	String ticketNumber;
    String name;
    String phoneNumber;
    String start;
    String end;
    String status;
    Integer price;
    
}
