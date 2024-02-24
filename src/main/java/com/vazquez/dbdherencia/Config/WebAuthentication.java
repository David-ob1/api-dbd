package com.vazquez.dbdherencia.Config;

import com.vazquez.dbdherencia.Models.Person;
import com.vazquez.dbdherencia.Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebAuthentication extends GlobalAuthenticationConfigurerAdapter {

    @Autowired
    private PersonRepository personRepository;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();

    }

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception{
       auth.userDetailsService(inputName -> {
           Person person = personRepository.findByEmail(inputName);

           if(person != null){
               return new org.springframework.security.core.userdetails
                       .User(person.getEmail(),person.getPassword(), AuthorityUtils.createAuthorityList("Person"));

           }else{
               throw new UsernameNotFoundException("No te encontramos en la db");
           }

       });

    }
}
