package no.ntnu.IDATT2105.oving_5_backend.controller;

import no.ntnu.IDATT2105.oving_5_backend.models.User.User;
import no.ntnu.IDATT2105.oving_5_backend.repo.UserRepo;
import org.slf4j.LoggerFactory;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@EnableAutoConfiguration
@CrossOrigin
public class TokenController {
    public static String keyStr = "testsecrettestsecrettestsecrettestsecrettestsecret";


    Logger logger = LoggerFactory.getLogger(Controller.class);
    @Autowired
    UserRepo userRepository;

    @PostMapping(value = "/register")
    @ResponseStatus(value = HttpStatus.CREATED)
    @CrossOrigin
    public String registerUser(@RequestParam("username") final String username, @RequestParam("password") final String password){
        // check username and password are valid to access token
        // note that subsequent request to the API need this token
        User foundUser = userRepository.findByUsername(username);

        if(foundUser == null){
            userRepository.save(new User(username, password));
            logger.info("USER REGISTERED - " + username);
            return "User registered";
        }else {
            return "Username is taken";
        }

    }


    @PostMapping(value = "/fetch")
    @ResponseStatus(value = HttpStatus.CREATED)
    @CrossOrigin
    public String generateToken(@RequestParam("username") final String username, @RequestParam("password") final String password){
        // check username and password are valid to access token
        // note that subsequent request to the API need this token
        User foundUser = userRepository.findByUsername(username);

        if(foundUser != null) {
            if (Objects.equals(foundUser.getPassword(), password)) {
                logger.info("USER LOGGED IN - " + username);
                return generateToken(username);
            } else {
                return "Wrong password";
            }

        }
        return "User not found";
    }

    public String generateToken(String userId){
        Key key = Keys.hmacShaKeyFor(keyStr.getBytes(StandardCharsets.UTF_8));
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

        Claims claims = Jwts.claims().setSubject(userId);
        claims.put("userId", userId);
        claims.put("authorities", grantedAuthorities
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList()));

        return Jwts.builder()
                .setId(UUID.randomUUID().toString())
                .setSubject(userId)
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000000))
                .signWith(key)
                .compact();
    }
}
