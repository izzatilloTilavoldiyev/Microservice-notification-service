package uz.pdp.notificationservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.notificationservice.dto.MailDTO;
import uz.pdp.notificationservice.service.MailSendingService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notification")
public class MailSendingController {

    private final MailSendingService mailSendingService;

    @PostMapping("/send-single")
    public String sendMessage(@RequestBody MailDTO mailDTO) {
        mailSendingService.sendMessage(mailDTO);
        return "Successfully sent";
    }

}
