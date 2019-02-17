package api.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import api.entity.Event;
import api.entity.User;
import api.repo.EventRepo;
import api.repo.UserRepo;

@CrossOrigin
@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private EventRepo eventRepo;
	
	@GetMapping("/users")
	public List<User> users(){
		return userRepo.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User user(@PathVariable long id) {
		return userRepo.findById(id);
	}
	
	@GetMapping("/partners/{myId}")
	public List<User> partners(@PathVariable long myId){
		List<User> partners = new ArrayList<>();
		for(User user : userRepo.findAll()) {
			if(user.getId() != userRepo.findById(myId).getId()) {
				partners.add(user);
			}
		}
		
		return partners;
	}
	
	@GetMapping("/iWasInvited/{id}")
	public List<Event> iWasInvited(@PathVariable long id){
		return eventRepo.findByBeeingInvitedId(id);
	}

	@GetMapping("/iDidInvite/{id}")
	public List<Event> iDidInvite(@PathVariable long id){
		return eventRepo.findByWhoInvitesId(id);
	}

	@GetMapping("/setStatus/{userId}/{eventId}/{status}")
	public Event setStatus(@PathVariable long userId, @PathVariable long eventId, @PathVariable String status) {
		
		User user = userRepo.findById(userId);
		
		if(user.getiWasInvited().contains(eventRepo.findById(eventId))) {
			Event temp = eventRepo.findById(eventId);
			temp.setStatus(status);
			eventRepo.save(temp);
		}
		
		
		return eventRepo.findById(eventId);
	}
	
	@GetMapping("/events")
	public List<Event> eventsAll(){
		return eventRepo.findAll();
	}
	
	@PostMapping("/invite/{myId}/{partnerId}")
	public Event createEvent(@RequestBody Event dto, @PathVariable long myId, @PathVariable long partnerId) {
		if(dto.getDate() == null) { dto.setDate(new Date()); }
		Event temp = new Event(dto.getMessage(), null, userRepo.findById(myId), userRepo.findById(partnerId));
		temp.setDate(dto.getDate());
		eventRepo.save(temp);
		
		return temp;
	}
	
	@GetMapping("/login/{email}/{pas}")
	public Long login(@PathVariable String email, @PathVariable String pas) {
		
		for(User u : userRepo.findAll()) {
			if(u.getEmail().equals(email) && u.getPasword().equals(pas)){
				return u.getId();
			}
		}
		return null;
	}
	
	@GetMapping("/user/{email}/{name}")
	public User user(@PathVariable String email, @PathVariable String name) {
		return userRepo.save(new User(email, name));
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable long id) {
		userRepo.deleteById(id);
		return "deleted";
	}
	
	
}
