package pl.osa.osaapplication.services.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import pl.osa.osaapplication.config.CustomOAuth2User;
import pl.osa.osaapplication.domain.User;
import pl.osa.osaapplication.model.AuthenticationProvider;
import pl.osa.osaapplication.model.Role;

import java.util.Optional;

@Service
public class Oauth2UsersService {

    @Autowired
    private UserService userService;

    public CustomOAuth2User handleUserLogin(OAuth2User oAuth2User, String clientId) {
        CustomOAuth2User customOAuth2User = new CustomOAuth2User(oAuth2User);

        String email = customOAuth2User.getName();
        Optional<User> existingUser = userService.getByEmail(email);

        existingUser.ifPresentOrElse(
                user -> userService.updateUserAfterOAuthLoginSuccess(user, getAuthenticationProvider(clientId)),
                () -> userService.createUser(getDomainUser(customOAuth2User, clientId))
        );

        return customOAuth2User;
    }

    private User getDomainUser(CustomOAuth2User oauthUser, String clientId) {
        User user =  new User();

        user.setEmail(oauthUser.getName());
        user.setAuth_provider(getAuthenticationProvider(clientId));
        user.setAddress("default");
        user.setCity("default");
        user.setPassword("default");
        user.setRole(Role.ROLE_USER);

        return user;
    }

    private AuthenticationProvider getAuthenticationProvider(String clientId) {
        switch(clientId) {
            case "google":
                return AuthenticationProvider.GOOGLE;
            case "facebook":
                return AuthenticationProvider.FACEBOOK;
            default:
                // TODO: handling unrecognized value
                return  AuthenticationProvider.LOCAL;
        }
    }
}
