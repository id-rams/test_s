package brow.master.com;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import brow.master.com.entity.UserService;

public class SmsSender {
    // Find your Account Sid and Auth Token at twilio.com/console
    public static final String ACCOUNT_SID =
            "ACb2115eda1603c02feec48cf9321ccfea";
    public static final String AUTH_TOKEN =
            "ab67e80d0fb1dd648f027225e9e958c4";

    public void sendSms(UserService userService) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        try {
            Message message = Message
                    .creator(new PhoneNumber(userService.getPhone()), // to
                            new PhoneNumber("+12564854095"), // from
                            "Success register: \n"+userService.toString())
                    .create();

            System.out.println(message.getStatus());
        } catch (Exception e) {
            System.err.print(e);
        }


    }    public void sendSms(UserService userService, String code) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        try {
            Message message = Message
                    .creator(new PhoneNumber(userService.getPhone()), // to
                            new PhoneNumber("+12564854095"), // from
                            "Verify code: "+code)
                    .create();

            System.out.println(message.getStatus());
        } catch (Exception e) {
            System.err.print(e);
        }


    }
}