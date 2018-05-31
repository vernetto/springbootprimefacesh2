package org.pierre.pvjoinfacestest.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rule {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String rule;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	@Override
	public String toString() {
		return "Rule [id=" + id + ", rule=" + rule + "]";
	}
	
	
}
