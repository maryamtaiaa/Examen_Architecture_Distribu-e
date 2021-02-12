package ma.enset.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import ma.enset.client.entities.Client;
import ma.enset.client.repository.ClientRepository;

@SpringBootApplication
public class ClientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientServiceApplication.class, args);
	}
	  @Bean
		CommandLineRunner start(ClientRepository customerrepository, RepositoryRestConfiguration restconfg) {
	    	restconfg.exposeIdsFor(Client.class); 
			return args ->{
				customerrepository.save(new Client(null,"client1", "client1@gmail.com")); 
				customerrepository.save(new Client(null,"client2", "client2@gmail.com")); 
				customerrepository.save(new Client(null,"client3", "client3@gmail.com")); 
				customerrepository.findAll().forEach(c->{
					System.out.println(c.getNom()+" -> "+c.getMail());
				});
			}; 
		}

}
