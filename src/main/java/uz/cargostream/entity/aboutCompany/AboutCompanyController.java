package uz.cargostream.entity.aboutCompany;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class AboutCompanyController {

    private final AboutCompanyService aboutCompanyService;
}
