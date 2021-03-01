package com.houseFire.demo.config;

/**
 *
 * @author admin
 */
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
   @Override
   protected void configure(HttpSecurity http) throws Exception {
      http
         .authorizeRequests()
            .antMatchers("/register").permitAll()
            //.antMatchers("/home").permitAll()
            .anyRequest().authenticated()//.permitAll()
            .and()
            .oauth2Login();
//         .formLogin();
//            .loginPage("/login")
//            .permitAll()
//            .and()
//            .logout()
//            .permitAll();
   }
//private static final String ENCODED_PASSWORD = "$2a$10$AIUufK8g6EFhBcumRRV2L.AQNz3Bjp7oDQVFiO5JJMBFZQ6x2/R/2";

   @Override
   public void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth
         .inMemoryAuthentication()
         .withUser("userg").password("{noop}cat").roles("USER");
//         .withUser("userg").password(passwordEncoder().encode("{bcrypt}cat")).roles("USER")
//         .and()
//         .withUser("user2").password(passwordEncoder().encode("{noop}user2Pass")).roles("USER")
//         .and()
//         .withUser("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN");
   }
//	@Bean
//	@Override
//	public UserDetailsService userDetailsService() {
//		UserDetails user =
//			 User.withDefaultPasswordEncoder()
//				.username("userg")
//				.password("cat")
//				.roles("USER")
//				.build();
//
//		return new InMemoryUserDetailsManager(user);
//	}

//    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//
//        User.UserBuilder users = User.withDefaultPasswordEncoder();
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(users.username("user").password("{noop}password").roles("USER").build());
//        manager.createUser(users.username("admin").password("{noop}password").roles("USER", "ADMIN").build());
//        return manager;
//
//    }
//   @Autowired
//   public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//      auth
//         .inMemoryAuthentication()
//        // .withUser("user1").password("{noop}cat").roles("USER");
//         .withUser("userg").password(passwordEncoder().encode("{bcrypt}cat")).roles("USER")
//         .and()
//         .withUser("user2").password(passwordEncoder().encode("{noop}user2Pass")).roles("USER")
//         .and()
//         .withUser("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN");
//   }
//   @Bean 
//    public PasswordEncoder passwordEncoder() { 
//        return new BCryptPasswordEncoder(); 
//    }
}
