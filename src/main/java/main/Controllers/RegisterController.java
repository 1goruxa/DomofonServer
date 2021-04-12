package main.Controllers;

import main.Api.Request.RegisterRequest;
import main.Api.Response.LoginResponse;
import main.Api.Response.RegisterResponse;
import main.Service.LoginService;
import main.Service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController {
    @Autowired
    RegisterService registerService;

    @Autowired
    LoginService loginService;

    @PostMapping("/register")
    public RegisterResponse register(@RequestBody RegisterRequest registerRequest){
        System.out.println(registerRequest.getName() + " " + registerRequest.getPassword());


        return registerService.register(registerRequest);
    }

    @GetMapping("/login")
    public LoginResponse login(@RequestParam(required = false, defaultValue = "") String userName,
                               @RequestParam(required = false, defaultValue = "") String userPassword){

        return loginService.login(userName,userPassword);
    }
}
