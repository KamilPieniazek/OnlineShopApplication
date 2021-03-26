package pl.osa.osaapplication.services.users;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import pl.osa.osaapplication.config.CustomOAuth2User;
import pl.osa.osaapplication.domain.User;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserInfoService {

    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    private final UserService userService;

    public Optional<User> getCurrentUser() {
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        }
        else if (principal instanceof OAuth2User) {
            username = ((CustomOAuth2User) principal).getName();
        }
        else {
            username = principal.toString();
        }
        return userService.getByEmail(username);
    }
}
