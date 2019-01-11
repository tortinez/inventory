package com.mcia.inventory.backend.config;

import com.mcia.inventory.backend.config.ldap.LdapSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;
import java.util.Collections;

@Configuration
@EnableConfigurationProperties(LdapSettings.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LdapSettings ldapSettings;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers(HttpMethod.GET, "/js/**", "/css/**", "/img/**").permitAll()
                    .antMatchers(HttpMethod.GET, "/api/**").hasRole("USER")
                    .antMatchers("/api/**").hasRole("MANAGER")
                .and()
                .httpBasic();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .ldapAuthentication()
                    .userDnPatterns("uid={0},ou=people")
                    .userSearchBase("ou=people")
                    .userSearchFilter("uid={0}")
                    .groupSearchBase("ou=groups")
                    .groupSearchFilter("uniqueMember={0}")
                .contextSource(contextSource())
                .passwordCompare()
                    .passwordEncoder(new LdapShaPasswordEncoder())
                    .passwordAttribute("userPassword");
    }

    @Bean
    public DefaultSpringSecurityContextSource contextSource() {
        return new DefaultSpringSecurityContextSource(
                Collections.singletonList(ldapSettings.getUrl()), ldapSettings.getBasedn());
    }
}
