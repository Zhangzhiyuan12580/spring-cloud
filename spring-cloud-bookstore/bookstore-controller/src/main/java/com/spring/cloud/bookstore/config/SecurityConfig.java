package com.spring.cloud.bookstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author zzy
 * @Date 2019-04-16-20:31
 * @Description
 **/
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("zzy").password(passwordEncoder().encode("password")).roles("USER")
                .and()
                .withUser("superAdmin")
                .password(passwordEncoder().encode("superPwd"))
                .roles("USER", "ADMIN");
    }

    /**
     * 只有超级用户才可以做删除操作
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //金庸csrf 否则会报不能跨域访问的错误
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers(HttpMethod.DELETE, "/spring/cloud/bookstore/books/**")
                .hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                //需要支持httpBasic验证，postman才可以提交认证
                .httpBasic();
    }
}
