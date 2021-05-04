package com.spring.backend_mariadb.web.common.security;

import com.spring.backend_mariadb.web.dto.MembersDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private MemberService memberService;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		

		logger.warn("Load User By UserName : " + userName);
		try {
			/*
			 SELECT login_status
			 FROM member
			 WHERE id = #{id}
			 */
			String state = memberService.readStatus(userName);
			System.out.println("로그인 스테이트 : " + state);
			
			if(state.equals("1")) {
				/*
				 SELECT mem.idx,
					mem.id,
					pw,
					real_name,
					login_status,
					reg_date,
					upd_date,
					auth
				FROM member mem LEFT OUTER JOIN member_auth auth ON mem.idx = auth.idx
				WHERE mem.id = #{id}
				 */
				MembersDto member = memberMapper.readByUserId(userName);
				
				logger.warn("queried by member mapper: " + member);

				return member == null ? null : new CustomUser(member);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	} 

}
