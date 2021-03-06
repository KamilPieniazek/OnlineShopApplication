package pl.osa.osaapplication.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import pl.osa.osaapplication.domain.User;
import pl.osa.osaapplication.model.Role;
import pl.osa.osaapplication.model.UserForm;
import pl.osa.osaapplication.services.EmailService;
import pl.osa.osaapplication.services.users.UserInfoService;
import pl.osa.osaapplication.services.users.UserService;
import pl.osa.osaapplication.services.validation.UserValidator;

import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;


@RequiredArgsConstructor
@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserValidator userValidator;
    private final UserInfoService userInfoService;
    private final EmailService emailService;

    @GetMapping
    public String showUsersView(final ModelMap modelMap) {
        Optional<User> currentUser = userInfoService.getCurrentUser();

        if (currentUser.isEmpty()) {
            return "/redirect:/logout";
        }

        modelMap.addAttribute("userForm", new UserForm());
      //  modelMap.addAttribute("u", currentUser);
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
        userValidator.validateEmail(userForm, errors);
        if (errors.hasErrors()) {

            return "/users";
        }
        userService.createUser(userForm);
        emailService.sendNewAccountConfirmation(userForm);
        return "redirect:/users";
    }

    @RequestMapping(value = "/update")
    @PostMapping
    public String updateUser(@Valid @ModelAttribute(name = "userForm") final UserForm userForm) {
        userService.updateUser(userForm);

        if (userForm.isShouldProceedWithCart()) {
            return "redirect:/cart";
        } else {
            return "redirect:/user-profile";
        }
    }
}
