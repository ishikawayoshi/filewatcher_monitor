package com.ishikawa.fwm.fwmcore.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
public abstract class BaseEntity<K extends Serializable> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected K id;

	public K getId() {
		return id;
	}

	@Column(name = "creation_time", nullable = false)
	private Date creationTime;

	@Column(name = "modification_time", nullable = false)
	private Date modificationTime;

	@PrePersist
	public void prePersist() {
		Date now = new Date();
		this.creationTime = now;
		this.modificationTime = now;
	}

	@PreUpdate
	public void preUpdate() {
		this.modificationTime = new Date();
	}


}
