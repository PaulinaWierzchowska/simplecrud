package pl.sda.simplecrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public static final String ROLE_USER = "ROLE_USER";
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception { //konfiguracja dostępów w aplikacji - URL
        http.csrf().disable()
                .cors().disable()
                .authorizeRequests()
                .antMatchers("/api/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { //konfiguracja odpytywania o użytkowników
        auth.inMemoryAuthentication()
                .withUser("user")
                .password(passwordEncoder.encode("password"))
                .roles("USER");
        auth.jdbcAuthentication()
                .usersByUsernameQuery("SELECT u.login, u.password, 1 FROM User u WHERE u.login=?")
                .authoritiesByUsernameQuery("SELECT u.login, u.role, 1 FROM User u WHERE u.login=?")
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder);
    }

}
