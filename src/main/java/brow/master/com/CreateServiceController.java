package brow.master.com;

import brow.master.com.entity.Code;
import brow.master.com.entity.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@EnableAutoConfiguration
public class CreateServiceController {
    private SmsSender smsSender;
    private UserService user;
    private String verifyCode = "1234";

    public static void main(String[] args) {
        SpringApplication.run(CreateServiceController.class, args);

    }


    @CrossOrigin
    @RequestMapping(value = "/service", method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<String> create(@RequestBody UserService userService) {

        try {
            System.out.println(userService);
            userService.setId(UUID.randomUUID().toString());
            smsSender = new SmsSender();
            smsSender.sendSms(userService, verifyCode);
            user = userService;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @CrossOrigin
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
    String index() {
        return "/WEB-INF/index.jsp";
    }

}