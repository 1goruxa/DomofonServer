package main.Controllers;

import main.Api.Request.EpdRequest;
import main.Api.Response.EpdUpdateResponse;
import main.Api.Response.UserListResponse;
import main.Service.AdminService;
import main.Service.EndPointDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @Autowired
    EndPointDeviceService epdService;

    @Autowired
    AdminService adminService;

    @GetMapping("/update")
    public EpdUpdateResponse updateDevice(@RequestParam int id){
        //Запрос отдельным объектом для возможности расширить тело запроса позднее
        EpdRequest epdRequest = new EpdRequest();
        epdRequest.setId(id);
        return epdService.updateDevice(epdRequest);
    }

    @GetMapping("/userlist")
    public UserListResponse userList(@RequestParam String userName, @RequestParam String userPassword){


        return adminService.getUserList(userName,userPassword);
    }


}
