package com.appsdeveloperblog.app.ws.shared;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;

// this is the utility class (or helper class), for helpful functions that our program needs
// this class is a component because it's autowired into the UserServiceImplementation Class
@Component
public class Utils {

    private final Random RANDOM = new SecureRandom();
    private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";


    // this method accepts a integer value method argument of how long the public user public id must be.
    // and than calls the generateRandomString() function below
    public String generateUserId(int length) {
        return generateRandomString(length);
    }

    // this function generates a string of random characters of a given length
    private String generateRandomString(int length) {
        StringBuilder returnValue = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }

        return new String(returnValue);
    }
}