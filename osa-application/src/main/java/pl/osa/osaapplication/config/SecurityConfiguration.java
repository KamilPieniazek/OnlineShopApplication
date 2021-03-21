package pl.osa.osaapplication.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import pl.osa.osaapplication.services.users.CustomOAuth2UserService;
import pl.osa.osaapplication.services.users.CustomUserDetailsService;
import pl.osa.osaapplication.services.users.OAuth2LoginSuccessHandler;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final CustomUserDetailsService customUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin().permitAll()
                    .loginPage("/login")
                .defaultSuccessUrl("/products", true)
                .and()
                .oauth2Login()
                    .loginPage("/login")
                    .userInfoEndpoint()
                        .userService(oAuth2UserService)
                    .and()
                    .successHandler(oAuth2LoginSuccessHandler)
                .defaultSuccessUrl("/products", true)
                // .failureUrl("/users")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/cart").clearAuthentication(true).deleteCookies().invalidateHttpSession(true)
                .and()
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/users/sign-up/**").permitAll()
                .antMatchers("/administration_panel/**").permitAll()
//                .antMatchers(HttpMethod.GET, "/products").hasAuthority("USER")
                .antMatchers("/h2/**").permitAll()
                .antMatchers("/products/**").permitAll()
                .antMatchers("/oauth2/**").permitAll()
                .anyRequest().authenticated()
                .and()

                .csrf().ignoringAntMatchers("/h2/**")
                .and()
                .headers().frameOptions().disable();

        http.headers().frameOptions().disable();
    }

    @Override
    protected UserDetailsService userDetailsService() {
        return customUserDetailsService;
    }


    @Autowired
    private CustomOAuth2UserService oAuth2UserService;

    @Autowired
    private OAuth2LoginSuccessHandler oAuth2LoginSuccessHandler;
}

