package pl.osa.osaapplication.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.osa.osaapplication.model.UserForm;
import pl.osa.osaapplication.services.users.UserInfoService;

@Service
@RequiredArgsConstructor
@Transactional
public class EmailService {

    private JavaMailSender javaMailSender;
    private final UserInfoService userInfoService;
    private final OrderLineService orderLineService;

    @Autowired
    public EmailService(JavaMailSender javaMailSender, UserInfoService userInfoService, OrderLineService orderLineService) {
        this.javaMailSender = javaMailSender;
        this.userInfoService = userInfoService;
        this.orderLineService= orderLineService;
    }

    public void sendOrderConfirmationEmail() {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("hieronimDTest@gmail.com");
        mailMessage.setTo(userInfoService.getCurrentUser().get().getEmail());
        mailMessage.setSubject("Order Confirmation");
        mailMessage.setText("Thank you for purchasing our products!"+ orderLineService.toString());

        javaMailSender.send(mailMessage);
    }

    public void sendNewAccountConfirmation(final UserForm userForm){
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setFrom("hieronimDTest@gmail.com");
        mailMessage.setTo(userForm.getEmail());
        mailMessage.setSubject("Welcome to Kamil's Online Bookstore!");
        mailMessage.setText("Hello "+userForm.getEmail()+" ! "+"\n"+
                "Thank you for creating new account on our on-line store. You can now log in!");

        javaMailSender.send(mailMessage);
    }




}
