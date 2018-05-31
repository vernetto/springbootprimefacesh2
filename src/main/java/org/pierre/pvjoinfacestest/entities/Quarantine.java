package org.pierre.pvjoinfacestest.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Quarantine {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String gav;
	
	private Date requestdate;
	
	public Long getId() {
		return id;
	}

	public Date getRequestdate() {
		return requestdate;
	}

	public void setRequestdate(Date requestdate) {
		this.requestdate = requestdate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGav() {
		return gav;
	}

	public void setGav(String gav) {
		this.gav = gav;
	}

	public Quarantine(Long id, String gav, Date requestdate) {
		super();
		this.id = id;
		this.gav = gav;
		this.requestdate = requestdate;
	}




}
