package main.Service;

import main.Api.Response.UserListResponse;
import main.Model.User;
import main.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    UserRepository userRepository;


    public UserListResponse getUserList(String userName, String userPassword){
        UserListResponse userListResponse = new UserListResponse();
        //Проверка есть ли права на просмотр списка, если есть
        Boolean adminAccessGranted = false;
        Optional<User> optionalUser = userRepository.findByName(userName);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            if (userPassword.equals(user.getPassword()) && user.getIsAdmin() == 1){
                adminAccessGranted = true;
            }
        }
        if(adminAccessGranted) {
            //Конец проверки (блок удалить после подключения Security)
            userListResponse.setResult(true);
            //тут получить список пользователей

        }
        else{
            userListResponse.setResult(false);
            userListResponse.setError("Недостаточно прав!");
        }
        return userListResponse;
    }
}
