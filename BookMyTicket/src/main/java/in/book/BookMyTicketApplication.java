package in.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BookMyTicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMyTicketApplication.class, args);
	}

}
