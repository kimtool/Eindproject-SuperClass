package com.appsdeveloperblog.app.ws.io.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appsdeveloperblog.app.ws.io.entity.UserEntity;

// the CrudRepository enables us to call ready to use methods
// Then we pass these methods to the an entity object to save It
// CRUD: create, read, update, delete.
// CrudRepository is generic and therefore we need to provide It with the details:
// userEntity: is the class of the object that needs to be persisted
// and
// Long: the datatype of the Id field 
// CrudRepository provides methods, but we can also define our own methods that will be able to query database
// This is Persistence layer(Data Access Layer) of application which used to 
// get data from the database. i.e. all the Database related operations are done by the repository.
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    // this is the method to find the email record in an entity(here UserEntity) the variable 'email' has to match
    // 'email' attribuut inside UserEntity. Could also be 'firstName' for instance
    UserEntity findByEmail(String email);
}
