$(function(){
    var user_name = ""
    var user_password = ""
    $("#button_login").click(function() {
            user_name = document.getElementById("name_login").value;
            user_password = document.getElementById("password_login").value;
            $.ajax
                ({
                    method: "GET",
                    url: "/login",
                    data: {
                        userName : user_name,
                        userPassword : user_password
                    },
                    contentType: "application/json; charset=utf-8",
                    success: function(response) {
                        if (response.result == true){
                            document.getElementById("register_form").hidden = true;
                            document.getElementById("login_form").hidden = true;
                            document.getElementById("profile_form").hidden = false;

                            var userInfo = document.getElementById("user_info")
                            userInfo.innerHTML = response.user.name

                            var userDevices = document.getElementById("user_devices")
                                var deviceList = ""
                                for (i in response.user.deviceSet){
                                    deviceList = deviceList + "<input name=\"device_set\" type=\"radio\" value= \"" +response.user.deviceSet[i].name + "\">"
                                        + response.user.deviceSet[i].name + " " + response.user.deviceSet[i].mac + "<br>"
                                }
                                userDevices.innerHTML = deviceList
                            //Отдельная функция на загрузку устройств пользователя

                            var money = document.getElementById("money")
                            money.innerHTML = response.user.balance

                            if (response.user.isAdmin == 1){
                                var adminPanel = document.getElementById("is_admin")
                                adminPanel.hidden = false

                            }
                        }
                        else{
                            alert(response.error)
                        }
                    }
                });
    });

    $("#send").click(function() {
        if($("#password").val() == $("#password_confirm").val()){
            var textForm = {"name":$("#name").val(), "password":$("#password").val()};
            $.ajax
                ({
                    method: "POST",
                    url: "/register",
                    data: JSON.stringify(textForm),
                    contentType: "application/json; charset=utf-8",
                    success: function(response) {
                        alert(response.result)

                    }
                });
        }
        else{
            alert("Пароли не совпадают!")
        }
    });

    $("#login_open_form").click(function() {
        document.getElementById("register_form").hidden = true;
        document.getElementById("login_form").hidden = false;
    });
    $("#open_register").click(function() {
        document.getElementById("register_form").hidden = false;
        document.getElementById("login_form").hidden = true;
    });

    //Работа личного кабинета
    //Управление устройствами
    $("#add_device").click(function() {
            document.getElementById("addDevice_form").hidden = false;
            document.getElementById("profile_form").hidden = true;
        });

    $("#backFromAddDevice").click(function() {
            document.getElementById("addDevice_form").hidden = true;
            document.getElementById("profile_form").hidden = false;
        });

    //Админская часть
    //Управление конечными устройствами
    $("#manage_epd").click(function() {
            document.getElementById("manage_epd_form").hidden = false;
            document.getElementById("profile_form").hidden = true;
        });

    $("#backFromManageEpd").click(function() {
            document.getElementById("manage_epd_form").hidden = true;
            document.getElementById("profile_form").hidden = false;
        });
    //Управление группами(семьями)
    $("#manage_group").click(function() {
            document.getElementById("manage_group_form").hidden = false;
            document.getElementById("profile_form").hidden = true;
        });

    $("#backFromManageGroup").click(function() {
            document.getElementById("manage_group_form").hidden = true;
            document.getElementById("profile_form").hidden = false;
        });
    //Управление пользователями
    $("#manage_user").click(function() {
            document.getElementById("manage_user_form").hidden = false;
            document.getElementById("profile_form").hidden = true;
            $.ajax
                ({
                    method: "GET",
                    url: "/userlist",
                    data: {
                        userName : user_name,
                        userPassword : user_password
                    },
                    contentType: "application/json; charset=utf-8",
                    success: function(response) {

                    }
                });
    });
    $("#backFromManageUser").click(function() {
            document.getElementById("manage_user_form").hidden = true;
            document.getElementById("profile_form").hidden = false;
        });




//Конец главной функции
});

function checkParams() {
    var name = $('#name_login').val();
    var email = $('#password_login').val();

    if(name.length != 0 && email.length != 0) {
        $('#button_login').removeAttr('disabled');
    } else {
        $('#button_login').attr('disabled', 'disabled');
    }
}

