//package com.spring.backend_mariadb.web.common.security.domain;
//
//import java.util.Collection;
//import java.util.stream.Collectors;
//
//import com.spring.backend_mariadb.web.domain.member.Members;
//import com.spring.backend_mariadb.web.dto.MembersDto;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//
//public class CustomUser extends User {
//
//	private static final long serialVersionUID = 1L;
//
//	private MembersDto member;
//
//	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
//		super(username, password, authorities);
//	}
//
//	public CustomUser(MembersDto member) {
//		super(member.getId(), member.getPw(), member.getAuthList().stream()
//				.map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));
//
//		this.member = member;
//	}
//
//	public MembersDto getMember() {
//		return member;
//	}
//
//}
