package com.example.javabarapp.Controller;

import com.example.javabarapp.Model.LoginDto;
import com.example.javabarapp.Model.RegisterDto;
import com.example.javabarapp.Model.User;
import com.example.javabarapp.Repository.UserRepository;
import com.example.javabarapp.Service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginDto loginDto) {
        if(userRepository.existsByMail(loginDto.getMail()) &&
                AuthenticationService.checkPassword(loginDto.getPassword(),AuthenticationService.EncodePassword(loginDto.getPassword()))){
            authenticationService.loginUser(loginDto.getMail(),userRepository.findByMail(loginDto.getMail()).get());
            return ResponseEntity.ok(userRepository.findByMail(loginDto.getMail()).orElse(null));
        }else{
            return new ResponseEntity<String>("You are not Authorize",HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> RegisterUser(@RequestBody RegisterDto registerDto) {
        if(userRepository.existsByMail(registerDto.getMail())){
            return new ResponseEntity<String>("Mail utilisé",HttpStatus.BAD_REQUEST);
        }else{
            User user = new User();
            user.setMail(registerDto.getMail());
            user.setPassword(AuthenticationService.EncodePassword(registerDto.getPassword()));
            user.setFirstName(registerDto.getFirst_name());
            user.setLastName(registerDto.getLast_name());
            user.setRole("Barman");
            userRepository.save(user);

            authenticationService.loginUser(user.getMail(),user);
            return ResponseEntity.ok(user);
        }
    }
}
