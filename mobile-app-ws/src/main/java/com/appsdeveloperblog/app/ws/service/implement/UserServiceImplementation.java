package com.appsdeveloperblog.app.ws.service.implement;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.appsdeveloperblog.app.ws.io.entity.UserEntity;
import com.appsdeveloperblog.app.ws.io.repositories.UserRepository;
import com.appsdeveloperblog.app.ws.service.UserService;
import com.appsdeveloperblog.app.ws.shared.Utils;
import com.appsdeveloperblog.app.ws.shared.dto.UserDto;

// Mark beans with @Service to indicate that it's holding the business logic. 
// @Service beans hold the business logic and call methods in the repository layer.
// So there's no any other specialty except using it in the service layer
@Service
public class UserServiceImplementation implements UserService {

    // now that UserRepository is autowired, we can use it here below.
    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDto createUser(UserDto user) {

        // query the database table for email and look if the record already exist.
        // if so, trow an error.
        if (userRepository.findByEmail(user.getEmail()) != null) throw new RuntimeException("Record already exists");

        // create an instance of useEntity
        UserEntity userEntity = new UserEntity();
        // copy information which is stored in UserDto into a UserEntity object
        // copy properties from user to entity. Here UserEntity is populated with information,
        // The program is now ready to save infomation into the database.
        // This only works because the fields from UserDto match the fields from UserEntity
        BeanUtils.copyProperties(user, userEntity);

        // calling the generateUserId() function inside the Utils class to generate an auto-generated userId
        String publicUserId = utils.generateUserId(8);


        // the auto generated userId will be set in the UserEntity class
        userEntity.setUserId(publicUserId);
        // after encrypting, the encrypted/encoded password will be set in the UserEntity class and stored
        // in the database. bcrypt is a password hashing function
        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));


        // UserRepository: this CRUD method saves an entity into the database
        // return value storedUserDetails is made
        UserEntity storedUserDetails = userRepository.save(userEntity);

        // create the returnvalue "returnValue" and copy the information back from UserEntity(storedUserDetails)
        // to UserDto(returnValue)
        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUserDetails, returnValue);

        return returnValue;
    }

    @Override
    public UserDto getUser(String email) {

        UserEntity userEntity = userRepository.findByEmail(email);

        if (userEntity == null) throw new UsernameNotFoundException(email);


        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(userEntity, returnValue);

        return returnValue;

    }

    // this method will be used in the process of user sign in
    // our http client will send a post request  with user details and password. And Spring Framework will use those to see
    // if it can find that user in our database
    // this method will help spring boot to load user details when It needs
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email);


        if (userEntity == null) throw new UsernameNotFoundException(email);

        return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());
    }

}
