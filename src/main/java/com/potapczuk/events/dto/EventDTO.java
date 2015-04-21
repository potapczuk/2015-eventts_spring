package com.potapczuk.events.dto;

import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.potapczuk.events.entity.User;

public class EventDTO {

	private static final long serialVersionUID = 1L;

    @NotNull
    @Size(min = 1, max = 100)
    private String name;
    
    private String description;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date eventDate;
    
    private Double price;
    
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
