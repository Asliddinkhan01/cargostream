package uz.cargostream.entity.contacts;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${app.domain}/contact")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;
}
