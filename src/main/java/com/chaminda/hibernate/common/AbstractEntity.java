package com.chaminda.hibernate.common;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;


@MappedSuperclass
public class AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Timestamp dateCreated;

	@Version
	private Timestamp lastUpdated;


	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(final Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(final Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}


	@PreUpdate
	public void setUpdateTimestamp() {
		setLastUpdated(new Timestamp(System.currentTimeMillis()));
	}

	@PrePersist
	public void setCreatedDate() {
		final Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		setDateCreated(timestamp);
		setLastUpdated(timestamp);
	}

}
