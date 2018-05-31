package org.pierre.pvjoinfacestest.entities;

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
	
	public Long getId() {
		return id;
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


	@Override
	public String toString() {
		return "Quarantine [id=" + id + ", gav=" + gav + "]";
	}



}
