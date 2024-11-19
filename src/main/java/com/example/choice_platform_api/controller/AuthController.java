package com.example.choice_platform_api.controller;
import com.example.choice_platform_api.dto.RegisterDto;
import com.example.choice_platform_api.entity.User;
import com.example.choice_platform_api.service.AuthService;
import com.example.choice_platform_api.service.UserService;
import com.example.choice_platform_api.utils.GenericResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/")
public class AuthController {

   // private final JwtServiceProvider jwtServiceProvider;
    private final AuthService authService;
    private final UserService userService;

    AuthController(AuthService authService,
                   //JwtServiceProvider jwtServiceProvider,
                   UserService userService) {
        this.authService = authService;
       // this.jwtServiceProvider = jwtServiceProvider;
        this.userService = userService;
    }


    @PostMapping("register")
    public ResponseEntity<GenericResponse<User>> register(@Valid @RequestBody RegisterDto registerUserDto) {
        GenericResponse<User> response = new GenericResponse<>();

        if(userService.checkIfEmailExists(registerUserDto.getEmail()) || userService.checkIfLoginExists(registerUserDto.getLogin())) {
            response.setMessage("L'email ou le login existe déjà");
            response.setStatus(HttpStatus.CONFLICT);
            response.setSuccess(Boolean.FALSE);
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }
        if(registerUserDto.getLogin().isEmpty()||registerUserDto.getEmail().isEmpty()||registerUserDto.getMdp().isEmpty()) {
            response.setMessage("Les données envoyées sont invalides");
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setSuccess(Boolean.FALSE);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        User registeredUser = this.authService.register(registerUserDto);
        response.setMessage("User registered successfully");
        response.setStatus(HttpStatus.CREATED);
        response.setSuccess(Boolean.TRUE);
        response.setData(registeredUser);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


}
