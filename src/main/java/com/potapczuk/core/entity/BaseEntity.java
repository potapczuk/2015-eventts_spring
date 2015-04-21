package com.potapczuk.core.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.potapczuk.events.entity.User;

@MappedSuperclass
public abstract class BaseEntity implements Serializable, Identifiable, Timestampable, Accountable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
	
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createdAt;
    
    @Temporal(TemporalType.TIMESTAMP)
    protected Date updatedAt;
    
    protected User createdBy;
    
    protected User updatedBy;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public User getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(User updatedBy) {
		this.updatedBy = updatedBy;
	}

	@PrePersist
	protected void onCreate() {
		createdAt = new Date();
		// TODO inject logged user
		createdBy = null;
	}

	@PreUpdate
	protected void onUpdate() {
		updatedAt = new Date();
		// TODO inject logged user
		updatedBy = null;
	}
}
