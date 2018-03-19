package brow.master.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import brow.master.com.entity.Code;
import brow.master.com.entity.UserService;
import java.util.UUID;

@Controller
@EnableAutoConfiguration
public class CreateServiceController {
    private SmsSender smsSender;
    private UserService user;
    private String verifyCode;

    public static void main(String[] args) {
        SpringApplication.run(CreateServiceController.class, args);

    }

    @RequestMapping(value = "/service", method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<UserService> create(@RequestBody UserService userService) {
        verifyCode = UUID.randomUUID().toString();
        userService.setId(verifyCode);
        smsSender = new SmsSender();
        smsSender.sendSms(userService, "12345");
        user = userService;
        return new ResponseEntity<>(userService, HttpStatus.OK);
    }

    @RequestMapping(value = "/confirm", method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity confirm(@RequestBody Code code) {
        if (code.getVerifyCode().equals(verifyCode)) {
            smsSender = new SmsSender();
            smsSender.sendSms(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else
            return new ResponseEntity("Your verify code is unavailable! Try again", HttpStatus.OK);
    }

    @RequestMapping("/")
    @ResponseBody
    String index() {
        return "Hello World!";
    }
}