package nl.jajaro.auth.auth.repository;

import nl.jajaro.auth.auth.model.Role;
import org.hibernate.annotations.Proxy;
import org.springframework.data.repository.CrudRepository;


public interface RoleRepository  extends CrudRepository<Role,Long> {

    Role findByName(String name);
}
