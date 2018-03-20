$(document).ready(function () {
    $("#create_order").click(function () {

        var name = $("#name").val();
        var phone = $("#phone").val();
        var email = $("#email").val();
        var service = $("#service").val();
        var time = $("#time").text();
        $.ajax({
            type: "POST",
            url: "/service",
            crossDomain: true,
            contentType: "application/json",
            accept: "application/json",
            data: JSON.stringify({
                name: name,
                phone: phone,
                email: email,
                service: service,
                time: time}),
            dataType: 'json'
        });


    });
});

$(document).ready(function () {
    $("#confirm_order").click(function () {

        var code = $("#code").val();

        $.ajax({
            type: "POST",
            url: "/confirm",
            crossDomain: true,
            contentType: "application/json",
            accept: "application/json",
            data: JSON.stringify({
                verifyCode: code}),
            dataType: 'json'
        });


    });
});