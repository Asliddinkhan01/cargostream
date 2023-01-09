package uz.cargostream.entity.email;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import uz.cargostream.common.ApiResponse;
import uz.cargostream.entity.email.dto.OrderDto;

import static uz.cargostream.util.AppConstants.RECEIVER_EMAIl;
import static uz.cargostream.util.AppConstants.SENDER_EMAIl;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;

    public HttpEntity<?> sendEmail(OrderDto orderDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(SENDER_EMAIl);
        message.setTo(RECEIVER_EMAIl);
        message.setSubject("New Order");

        String text = "Customer name: " + orderDto.getName() + "\n\n" +
                "Phone number: " + orderDto.getPhoneNumber() + "\n\n" +
                "Message: " + orderDto.getMessage();
        message.setText(text);
        javaMailSender.send(message);
        return new ResponseEntity<>(new ApiResponse("Success", true), HttpStatus.OK);
    }
}
