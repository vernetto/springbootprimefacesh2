package org.pierre.pvjoinfacestest;
import java.util.List;

import org.pierre.pvjoinfacestest.entities.Quarantine;
import org.pierre.pvjoinfacestest.entities.Rule;

public interface RuleRepository {
	List<Quarantine> findByRule(String rule);
}
