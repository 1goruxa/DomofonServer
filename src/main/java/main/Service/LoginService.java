package main.Service;

import main.Api.Response.DeviceResponse;
import main.Api.Response.LoginResponse;
import main.Api.Response.LoginUserResponse;
import main.Model.Device;
import main.Model.User;
import main.Repo.DeviceRepository;
import main.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DeviceRepository deviceRepository;

    public LoginResponse login(String userName, String userPassword){
        LoginResponse loginResponse = new LoginResponse();

        loginResponse.setResult(false);
        User user = new User();

        //!Передаем, храним и обрабатываем нехэшированный пароль

        Optional<User> optionalUser = userRepository.findByName(userName);

        if (optionalUser.isPresent()){
            user = optionalUser.get();
            if (userPassword.equals(user.getPassword())){
                loginResponse.setResult(true);
                LoginUserResponse loginUserResponse = new LoginUserResponse();
                ArrayList<DeviceResponse> deviceResponseSet = new ArrayList<>();

                loginUserResponse.setId(user.getId());
                loginUserResponse.setName(user.getName());
                loginUserResponse.setGroupId(user.getGroup().getId());
                loginUserResponse.setBalance(user.getBalance());
                loginUserResponse.setIsAdmin(user.getIsAdmin());


                for (Device d : user.getDeviceSet()){
                    DeviceResponse deviceResponse = new DeviceResponse();
                    deviceResponse.setId(d.getId());
                    deviceResponse.setName(d.getName());
                    deviceResponse.setMac(d.getMac());
                    deviceResponseSet.add(deviceResponse);
                }

                loginUserResponse.setDeviceSet(deviceResponseSet);
                loginResponse.setUser(loginUserResponse);
            }
            else{
                loginResponse.setError("Пароль указан неверно");
            }
        }
        else{
            loginResponse.setError("Пользователь не найден");
        }

        return loginResponse;
    }
}
