package no.ntnu.IDATT2105.oving_5_backend.service;

import no.ntnu.IDATT2105.oving_5_backend.controller.LoginController;
import no.ntnu.IDATT2105.oving_5_backend.models.LoginRequest;
import no.ntnu.IDATT2105.oving_5_backend.models.LoginResponse;
import no.ntnu.IDATT2105.oving_5_backend.repo.LoginRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class LoginService {
    @Autowired
    LoginRepo loginRepo;

    LoginService(LoginRepo loginRepo) {
        this.loginRepo = loginRepo;
    }

    private static final Logger LOGGER = LogManager.getLogger(LoginController.class);

    public LoginResponse doLogin(LoginRequest loginRequest) {
        LOGGER.info("Logging in..." + loginRequest.getUsername());

        if(loginRequest.equals(findUser(loginRequest.getUsername(), loginRequest.getPassword()))) {
            return new LoginResponse("Success");
        }
        return new LoginResponse("Fail");
    }

    public Optional<LoginRequest> findUser(String username, String password) {
        return loginRepo.findAll().stream()
                .filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password)).findFirst();
    }

    public LoginResponse doLogin2(LoginRequest loginRequest) {
        LOGGER.info("Logging in..." + loginRequest.getUsername());
        if(loginRequest.equals(loginRepo.findAll())) {
            return new LoginResponse("Success");
        }
        return new LoginResponse("Fail");
    }
}
