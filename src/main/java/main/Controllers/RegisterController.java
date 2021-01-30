package main.Controllers;

import main.Api.Request.RegisterRequest;
import main.Api.Response.RegisterResponse;
import main.Service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    @Autowired
    RegisterService registerService;

    @PostMapping("/register")
    public RegisterResponse register(@RequestBody RegisterRequest registerRequest){
        System.out.println(registerRequest.getName() + " " + registerRequest.getMac());


        return registerService.register(registerRequest);
    }
}
