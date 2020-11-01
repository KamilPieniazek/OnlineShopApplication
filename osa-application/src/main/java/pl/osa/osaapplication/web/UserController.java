package pl.osa.osaapplication.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.osa.osaapplication.domain.User;
import pl.osa.osaapplication.model.UserForm;
import pl.osa.osaapplication.services.UserService;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/sign-up")
    public String createUser(UserForm userForm){
         userService.createUser(userForm);
         return "sign-in";
    }
}
