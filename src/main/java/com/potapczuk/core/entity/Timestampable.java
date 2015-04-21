package com.potapczuk.core.entity;

import java.util.Date;

public interface Timestampable {
	
	Date getCreatedAt();
	
	Date getUpdatedAt();
	
	void setCreatedAt(Date createdAt);
	
	void setUpdatedAt(Date updatedAt);
	
}
