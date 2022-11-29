package uz.cargostream.entity.aboutCompany;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AboutCompanyService {

    private final AboutCompanyRepository aboutCompanyRepository;
}
