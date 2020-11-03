package pl.osa.osaapplication.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "sda.user")
@Component
//@EnableConfigurationProperties(UserProperties.class)
public class UserProperties {

    @NotNull
    @Email
    private String email;

    private String password;

    private String city;

    private String address;

    private String preferredWayOfComunication;

}
