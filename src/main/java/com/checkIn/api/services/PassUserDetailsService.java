package com.checkIn.api.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.checkIn.api.model.UserEntity;
import com.checkIn.api.repository.UserRepository;

@Service
public class PassUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


		/*if(username.equals("pranita"))
		{
			return new User("pranita", "pranita123", new ArrayList<>());
		}
		else
		{
			throw new UsernameNotFoundException("User not found");
		}*/
		Optional<UserEntity> user = userRepository.findById(username);
		
		if(user.isPresent())
		{
			List<SimpleGrantedAuthority> authorities = new ArrayList<>();
			Arrays.asList(user.get().getRoles().split(",")).stream().forEach(authority->{
			authorities.add(new SimpleGrantedAuthority(authority));
			});
			
			return new User(user.get().getUsername(),user.get().getPassword(),authorities);
		}
		else
		{
			throw new UsernameNotFoundException("user"+username+"does not exist...");
		}
	}

}
