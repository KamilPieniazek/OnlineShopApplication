package pl.osa.osaapplication.services.users;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.osa.osaapplication.domain.User;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userService.getByEmail(username);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User with this email does not exist");
        }

        return new UserAdapter(user.get());
    }
}
