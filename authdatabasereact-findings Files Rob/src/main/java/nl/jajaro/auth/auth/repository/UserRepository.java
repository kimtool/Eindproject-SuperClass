package nl.jajaro.auth.auth.repository;

import nl.jajaro.auth.auth.model.User;
import org.hibernate.annotations.Proxy;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<User,Long> {
    User findByEmail(String email);
}
