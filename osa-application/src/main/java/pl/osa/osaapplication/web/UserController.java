package pl.osa.osaapplication.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import pl.osa.osaapplication.domain.User;
import pl.osa.osaapplication.model.UserForm;
import pl.osa.osaapplication.services.UserService;
import javax.validation.Valid;


@RequiredArgsConstructor
@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public String showUsersView(final ModelMap modelMap) {
        modelMap.addAttribute("users", userService.getAllUsers());
        modelMap.addAttribute("userForm", new UserForm());
        return "users";
    }

    @RequestMapping(value = "/sign-up", method = {RequestMethod.GET, RequestMethod.POST})
    public String createUser(@Valid @ModelAttribute(name = "userForm") final UserForm userForm,
                             final Errors errors) {
        if (errors.hasErrors()) {
            return "/users";
        }
        userService.createUser(userForm);
        return "redirect:/users";
    }
}
