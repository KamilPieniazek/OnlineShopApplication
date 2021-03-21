package pl.osa.osaapplication.services.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import pl.osa.osaapplication.config.CustomOAuth2User;


@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    @Autowired
    private Oauth2UsersService oauthUserService;


    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User auth2User = super.loadUser(userRequest);
        String providerId = userRequest.getClientRegistration().getRegistrationId();
        CustomOAuth2User customOAuth2User = oauthUserService.handleUserLogin(auth2User, providerId);

        return customOAuth2User;
    }
}
