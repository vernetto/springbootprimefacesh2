package org.pierre.pvjoinfacestest;
import java.util.List;

import org.pierre.pvjoinfacestest.entities.Quarantine;
import org.springframework.data.repository.CrudRepository;

public interface QuarantineRepository extends CrudRepository<Quarantine, Long> {
	List<Quarantine> findBygav(String gav);

}
