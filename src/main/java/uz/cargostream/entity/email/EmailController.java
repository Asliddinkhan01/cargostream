package uz.cargostream.entity.email;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.cargostream.entity.email.dto.OrderDto;

import javax.validation.Valid;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/send")
    public HttpEntity<?> sendEmail(@RequestBody @Valid OrderDto orderDto) {
        return emailService.sendEmail(orderDto);
    }

}
