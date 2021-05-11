//package com.spring.backend_mariadb.web.config;
//
//import javax.sql.DataSource;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.access.AccessDeniedHandler;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
//import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
//import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
//
//import com.spring.backend_mariadb.web.common.security.CustomAccessDeniedHandler;
//import com.spring.backend_mariadb.web.common.security.CustomLoginSuccessHandler;
//import com.spring.backend_mariadb.web.common.security.CustomUserDetailsService;
//
//
//@EnableWeb
//public class SecurityConfig extends WebSecurityConfigurerAdapt {
//
//	private static final Logger log = LoggerFactory.getLogger(SecurityConfig.class);
//
//	@Autowired
//	DataSource dataSource;
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		log.info("security config......");
//
//		// 로그인 리다이렉트 설정
//		http.formLogin()
//		.loginPage("/auth/login")
//		.loginProcessingUrl("/login")
//		.successHandler(createAuthenticationSuccessHandler());
//
//		// 로그아웃 리다이렉트 설정
//		http.logout()
//		.logoutUrl("/auth/logout")
//		.invalidateHttpSession(true);
//
//		http.exceptionHandling()
//		.accessDeniedHandler(createAccessDeniedHandler());
//
//		http.rememberMe()
//		.key("com.spring.backend_mariadb")
//		.tokenRepository(createJDBCRepository())
//		.tokenValiditySeconds(60*60*24);
//
//		// 접근 제한 설정
//		// 여기 메뉴별 접근권한 설정해줄것.
//		http.authorizeRequests()
//		.antMatchers("/")
//		.authenticated()
//		.antMatchers("/admin/**").hasRole("Role_Admin")
//		.antMatchers("/ebook/**").authenticated()
//		.antMatchers("/board/**").authenticated();
//	}
//
//	@Bean
//	public PersistentTokenRepository createJDBCRepository() {
//		JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
//		repo.setDataSource(dataSource);
//		return repo;
//	}
//
//	@Bean
//	public AccessDeniedHandler createAccessDeniedHandler() {
//		return new CustomAccessDeniedHandler();
//	}
//
//	@Bean
//	public AuthenticationSuccessHandler createAuthenticationSuccessHandler() {
//		return new CustomLoginSuccessHandler();
//	}
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(createUserDetailsService())
//		.passwordEncoder(createPasswordEncoder());
//	}
//
//	@Bean
//	protected PasswordEncoder createPasswordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//	@Bean
//	public UserDetailsService createUserDetailsService() {
//		return new CustomUserDetailsService();
//	}
//
//	@Bean
//	MappingJackson2JsonView jsonView(){
//		return new MappingJackson2JsonView();
//	}
//
//}
