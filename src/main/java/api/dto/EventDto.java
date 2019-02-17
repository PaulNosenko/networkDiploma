package api.dto;

import java.io.Serializable;
import java.util.Date;



import com.fasterxml.jackson.annotation.JsonFormat;

public class EventDto implements Serializable{

	private String status;
	
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date date;

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public EventDto(String status, Date date) {
		super();
		this.status = status;
		this.date = date;
	}
	
	public EventDto() {}
	
}
