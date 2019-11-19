package com.appsdeveloperblog.app.ws.security;

import com.appsdeveloperblog.app.ws.SpringApplicationContext;

// authentication filter
public class SecurityConstants {
    public static final long EXPIRATION_TIME = 864000000; // token is valid for 10 days (value in milliseconds)
    public static final long PASSWORD_RESET_EXPIRATION_TIME = 3600000; // 1 hour
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users";
    //public static final String TOKEN_SECRET = "jf9i4jgu83nfl0";
    
    
    public static String getTokenSecret() {
    
    	AppProperties appProperties = (AppProperties) SpringApplicationContext.getBean("AppProperties");
    	return appProperties.getTokenSecret();
    }

}