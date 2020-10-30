package pl.osa.osaapplication.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.osa.osaapplication.domain.User;
import pl.osa.osaapplication.services.UserService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/sign-up")
    public String createUser(User user){
         userService.createUser(user);
         return "sign-in";
    }
}
