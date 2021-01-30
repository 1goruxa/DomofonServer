package main.Service;

import main.Api.Request.RegisterRequest;
import main.Api.Response.RegisterResponse;
import main.Model.User;
import main.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    @Autowired
    private UserRepository userRepository;

    public RegisterResponse register(RegisterRequest registerRequest){
        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setResult(true);

        User user = new User();
        user.setName(registerRequest.getName());
        user.setMac(registerRequest.getMac());

        userRepository.save(user);

        return registerResponse;
    }

}
