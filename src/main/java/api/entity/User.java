package api.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String email;
	private String name;
	
	@OneToMany(mappedBy = "whoInvites")
	@JsonIgnore
	private List<Event> iInvited = new ArrayList<>();

	@OneToMany(mappedBy = "beeingInvited")
	@JsonIgnore
	private List<Event> iWasInvited = new ArrayList<>();
	
	private String pasword;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Event> getiInvited() {
		return iInvited;
	}
	public void setiInvited(List<Event> iInvited) {
		this.iInvited = iInvited;
	}
	public List<Event> getiWasInvited() {
		return iWasInvited;
	}
	public void setiWasInvited(List<Event> iWasInvited) {
		this.iWasInvited = iWasInvited;
	}
	
	public String getPasword() {
		return pasword;
	}
	public void setPasword(String pasword) {
		this.pasword = pasword;
	}
	public User(String email, String name) {
		super();
		this.email = email;
		this.name = name;
		this.pasword = "pas123";
	}
	
	public User() {}
	
}
