package org.pierre.pvjoinfacestest;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.pierre.pvjoinfacestest.entities.Rule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Named
@ViewScoped
public class WelcomeMBean implements Serializable {
	private static final Logger logger = LoggerFactory.getLogger(WelcomeMBean.class);

	private static final long serialVersionUID = 1L;

	private String text = "Ciao Bella Gioia";
	private List<Rule> all;
	
	@Inject
	RuleRepository ruleRepository;
	
	@PostConstruct
	public void postConstruct() {
		logger.debug("PV loading all rules from DB");
		all = ruleRepository.findAll();
		logger.debug(String.format("PV found %d rules", all.size()));
	}
	
}