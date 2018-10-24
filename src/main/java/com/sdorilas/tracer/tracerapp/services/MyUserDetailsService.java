package com.sdorilas.tracer.tracerapp.services;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sdorilas.tracer.tracerapp.components.MyUserDetails;
import com.sdorilas.tracer.tracerapp.dto.User;
import com.sdorilas.tracer.tracerapp.repositories.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
 
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MyUserDetails userDetails;
    @Autowired
    private LoginAttemptService loginAttemptService;
    @Autowired
    private HttpServletRequest request;
    public static boolean blocked = false;
 
    @Override
    public UserDetails loadUserByUsername(String username) {
    	String ip = getClientIP();
    	if (loginAttemptService.isBlocked(ip)) {
    		blocked = true;
            throw new RuntimeException("blocked");
        }else {
        	blocked = false;
        }
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        userDetails.setUser(user);
        return userDetails;
    }
    
    private String getClientIP() {
        String header = request.getHeader("X-Forwarded-For");
        if (header == null){
        	//for those not behind a proxy server or load balancer
            return request.getRemoteAddr();
        }
        return header.split(",")[0];
    }
}
