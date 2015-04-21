package com.potapczuk.core.entity;

import com.potapczuk.events.entity.User;

public interface Accountable {

	User getCreatedBy();

	User getUpdatedBy();

	void setCreatedBy(User createdBy);

	void setUpdatedBy(User updatedBy);
}
