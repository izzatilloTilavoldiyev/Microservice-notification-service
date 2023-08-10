package uz.pdp.notificationservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import uz.pdp.notificationservice.dto.MailDTO;

@Service
@RequiredArgsConstructor
public class MailSendingService {

    private final JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String sender;

    public void sendMessage(MailDTO mailDTO) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(sender);
        simpleMailMessage.setTo(mailDTO.getEmail());
        simpleMailMessage.setText(mailDTO.getMessage());
        mailSender.send(simpleMailMessage);
    }
}
