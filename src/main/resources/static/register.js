$(function(){
    $("#send").click(function() {
        var textForm = {"name":$("#name").val(),"mac":$("#mac").val()};
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
    });
});