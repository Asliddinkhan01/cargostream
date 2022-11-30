package uz.cargostream.entity.aboutCompany;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.cargostream.entity.aboutCompany.dto.AddAboutCompanyDto;
import uz.cargostream.entity.aboutCompany.dto.EditAboutCompanyDto;

import java.util.UUID;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class AboutCompanyController {

    private final AboutCompanyService aboutCompanyService;

    @GetMapping
    public HttpEntity<?> getAllAboutCompany() {
        return aboutCompanyService.getAllAboutCompany();
    }

    @PostMapping()
    public HttpEntity<?> addAboutCompany(
            @RequestPart("dto") AddAboutCompanyDto dto,
            @RequestPart("photo") MultipartFile photo
    ) {
        return aboutCompanyService.addAboutCompany(dto, photo);
    }

    @PutMapping
    public HttpEntity<?> editAboutCompany(
            @RequestPart("dto") EditAboutCompanyDto dto,
            @RequestPart("photo") MultipartFile photo
    ) {
        return aboutCompanyService.editAboutCompany(dto, photo);
    }

    @DeleteMapping
    public HttpEntity<?> deleteAboutCompany(@RequestParam UUID aboutCompanyId) {
        return aboutCompanyService.deleteById(aboutCompanyId);
    }
}
