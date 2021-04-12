package main.Service;

import main.Api.Request.RegisterRequest;
import main.Api.Response.RegisterResponse;
import main.Model.Group;
import main.Model.User;
import main.Repo.UserRepository;
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
        user.setPassword(registerRequest.getPassword());

        Group group = new Group();
        group.setId(0);
        user.setGroup(group);

        userRepository.save(user);

        return registerResponse;
    }

}
