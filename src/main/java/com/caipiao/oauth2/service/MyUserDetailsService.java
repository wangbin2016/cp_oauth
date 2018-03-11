package com.caipiao.oauth2.service;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.caipiao.member.entity.Member;
import com.caipiao.member.service.MemberService;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private MemberService memberService;
	
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		User user = null;
		if(name!=null && name.trim().length()>0) {
			user = mockUser(name);			
		}
		return user;
	}

	private User mockUser(String account) {
		Member member = memberService.getMember(account, null);
		Collection<GrantedAuthority> authorities = new HashSet<>();
		authorities.add(new SimpleGrantedAuthority("test"));
		User user = new User(member.getAccount(),member.getPassword(),authorities);
		return user;
	}
	
	private User mockUser() {
		Collection<GrantedAuthority> authorities = new HashSet<>();
		authorities.add(new SimpleGrantedAuthority("admin"));
		User user = new User("admin","123456",authorities);
		return user;
	}
}
