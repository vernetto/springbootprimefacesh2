package org.pierre.pvjoinfacestest;
import java.util.List;

import org.pierre.pvjoinfacestest.entities.Rule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RuleRepository extends JpaRepository<Rule, Long> {
	List<Rule> findByRule(String rule);
}
