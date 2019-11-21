package nl.jajaro.auth.auth.repository;

import nl.jajaro.auth.auth.model.Privilege;
import org.springframework.data.repository.CrudRepository;

public interface PrivilegeRepository extends CrudRepository<Privilege,Long> {
    Privilege findByName(String name);
}
