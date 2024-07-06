package in.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class Ticket 
{
	Integer aadhaarCard;
	
	@Id
	String ticketNumber;
    String name;
    String phoneNumber;
    String start;
    String end;
    String status;
    Integer price;
}
