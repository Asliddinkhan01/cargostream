package uz.cargostream.entity.aboutCompany;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.cargostream.common.ApiResponse;
import uz.cargostream.entity.aboutCompany.dto.AddAboutCompanyDto;
import uz.cargostream.entity.aboutCompany.dto.EditAboutCompanyDto;
import uz.cargostream.entity.photo.PhotoService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AboutCompanyService {

    private final AboutCompanyRepository aboutCompanyRepository;
    private final PhotoService photoService;

    public HttpEntity<?> getAllAboutCompany() {
        List<AboutCompany> allAboutCompany = aboutCompanyRepository.findAll();
        return new ResponseEntity<>(new ApiResponse("Success", true, allAboutCompany), HttpStatus.OK);
    }

    public HttpEntity<?> addAboutCompany(AddAboutCompanyDto dto, MultipartFile photo) {
        try {
            AboutCompany aboutCompany = new AboutCompany();
            aboutCompany.setText_ru(dto.getText_ru());
            aboutCompany.setText_en(dto.getText_en());
            aboutCompany.setPhoto(photoService.savePhoto(photo));
            aboutCompanyRepository.save(aboutCompany);
            return new ResponseEntity<>(new ApiResponse("Success", true), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ApiResponse("Something went wrong", false), HttpStatus.CONFLICT);
        }
    }

    public HttpEntity<?> editAboutCompany(EditAboutCompanyDto dto, MultipartFile photo) {
        Optional<AboutCompany> optionalAboutCompany = aboutCompanyRepository.findById(dto.getAboutCompanyId());

        if (optionalAboutCompany.isEmpty())
            return new ResponseEntity<>(new ApiResponse("Not found", false), HttpStatus.NOT_FOUND);

        AboutCompany aboutCompany = optionalAboutCompany.get();
        aboutCompany.setText_en(dto.getText_en());
        aboutCompany.setText_ru(dto.getText_ru());

        if (photo != null) {
            photoService.deletePhoto(aboutCompany.getId());

            aboutCompany.setPhoto(photoService.savePhoto(photo));
        }

        try {
            aboutCompanyRepository.save(aboutCompany);
            return new ResponseEntity<>(new ApiResponse("Success", true), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ApiResponse("Something went wrong", false), HttpStatus.CONFLICT);
        }
    }


    public HttpEntity<?> deleteById(UUID aboutCompanyId) {
        Optional<AboutCompany> optionalAboutCompany = aboutCompanyRepository.findById(aboutCompanyId);

        if (optionalAboutCompany.isEmpty())
            return new ResponseEntity<>(new ApiResponse("Not found", false), HttpStatus.NOT_FOUND);

        AboutCompany aboutCompany = optionalAboutCompany.get();
        photoService.deletePhoto(aboutCompany.getPhoto().getId());
        aboutCompanyRepository.deleteById(aboutCompanyId);
        return new ResponseEntity<>(new ApiResponse("Success", true), HttpStatus.NO_CONTENT);
    }
}
