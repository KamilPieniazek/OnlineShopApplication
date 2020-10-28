package pl.osa.osaapplication.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import pl.osa.osaapplication.services.UserService;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;
}
