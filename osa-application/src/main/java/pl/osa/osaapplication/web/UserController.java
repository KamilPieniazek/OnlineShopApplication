package pl.osa.osaapplication.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import pl.osa.osaapplication.domain.User;
import pl.osa.osaapplication.model.Role;
import pl.osa.osaapplication.model.UserForm;
import pl.osa.osaapplication.services.UserInfoService;
import pl.osa.osaapplication.services.UserService;
import pl.osa.osaapplication.services.validation.UserValidator;

import javax.validation.Valid;
import java.util.Map;


@RequiredArgsConstructor
@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserValidator userValidator;
    private final UserInfoService userInfoService;

    @GetMapping
    public String showUsersView(final ModelMap modelMap) {
        String currentUser = userInfoService.getCurrentUser();
        User byId = userService.getById(currentUser);
        modelMap.addAttribute("userForm", new UserForm());
        modelMap.addAttribute("u", currentUser);
       // modelMap.addAttribute("user",userService.getCurrentUser());
        modelMap.addAllAttributes(Map.of(
                "users", userService.getAllUsers(),
                "roles", Role.allTypes()));
        return "users";
    }
//
//    @GetMapping
//    public List<User> getUserByEmail(String email) {
//        return userService.getByEmail(email);
//    }

    @RequestMapping(value = "/sign-up", method = {RequestMethod.GET, RequestMethod.POST})
    public String createUser(@Valid @ModelAttribute(name = "userForm") final UserForm userForm,
                             final Errors errors) {
        userValidator.validateEmail(userForm,errors);
      if (errors.hasErrors()) {

            return "/users";
        }
        userService.createUser(userForm);
        return "redirect:/users";
    }
}
