package com.sdorilas.tracer.tracerapp.components;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.sdorilas.tracer.tracerapp.dto.Authority;
import com.sdorilas.tracer.tracerapp.dto.User;
import com.sdorilas.tracer.tracerapp.repositories.AuthorityRepository;

@Component
public class MyUserDetails implements UserDetails {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	@Autowired
	private AuthorityRepository authorityRepository;

    public void setUser(User user) {
    	this.user = user;
    }
    
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();
		List<Authority> authorities = authorityRepository.findAll();
		for (Authority role: authorities) {
			if(role.getUsername().equals(user.getUsername())) {
				grantedAuthorityList.add(new SimpleGrantedAuthority(role.getAuthority()));
			}
		}
		return grantedAuthorityList;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}
	
	@Override
	public String getUsername() {
		
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return user.isAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return user.isAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return user.isCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() {
		return user.isEnabled();
	}
}
