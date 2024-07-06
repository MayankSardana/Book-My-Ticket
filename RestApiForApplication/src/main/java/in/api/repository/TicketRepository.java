package in.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.api.entity.Ticket;
import java.util.List;


public interface TicketRepository extends JpaRepository<Ticket, String> 
{
     public List<Ticket> findByAadhaarCard(Integer aadhaarCard); 
}
