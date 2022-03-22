package no.ntnu.IDATT2105.oving_5_backend.controller;

import no.ntnu.IDATT2105.oving_5_backend.models.User.LoginRequest;
import no.ntnu.IDATT2105.oving_5_backend.models.User.LoginResponse;
import no.ntnu.IDATT2105.oving_5_backend.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;



@RestController
@RequestMapping(value = "/login")
@EnableAutoConfiguration
@CrossOrigin
public class LoginController {

    @Autowired
    LoginService loginService;


    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public LoginResponse login(final @RequestBody LoginRequest loginRequest, HttpSession session, ModelMap modelMap) {

        var x = loginService.login_user(loginRequest,session,modelMap);

        return x;
    }
}
