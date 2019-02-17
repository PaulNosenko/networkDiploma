package api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import api.entity.Event;
import api.entity.User;
import api.repo.EventRepo;
import api.repo.UserRepo;

@SpringBootApplication
public class NetworkApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(NetworkApplication.class, args);
	}

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private EventRepo eventRepo;
	
	@Override
	public void run(String... strings) throws Exception {

		/*userRepo.save(new User("first@gmail.com", "First"));
		userRepo.save(new User("second@gmail.com", "Second"));
		userRepo.save(new User("third@gmail.com", "Third"));
		
		eventRepo.save(new Event("from 1 to 2", null, userRepo.findById(1), userRepo.findById(2)));
		eventRepo.save(new Event("from 1 to 3", null, userRepo.findById(1), userRepo.findById(3)));

		eventRepo.save(new Event("from 2 to 3", null, userRepo.findById(2), userRepo.findById(3)));*/
		
	}

}

