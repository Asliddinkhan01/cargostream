package uz.cargostream.entity.partners;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.cargostream.common.ApiResponse;
import uz.cargostream.entity.partners.dto.PartnerDto;
import uz.cargostream.entity.photo.PhotoService;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PartnerService {
    private final PartnerRepository partnerRepository;
    private final PhotoService photoService;

    public HttpEntity<?> addPartner(MultipartFile photo, PartnerDto partnerDto) {
        Partner partner = new Partner();
        partner.setSiteLink(partnerDto.getSiteLink());
        partner.setPhoto(photoService.savePhoto(photo));
        partnerRepository.save(partner);
        return new ResponseEntity<>(new ApiResponse("Successfully added", true), HttpStatus.CREATED);
    }

    public HttpEntity<?> getPartner(UUID uuid) {
        Optional<Partner> byId = partnerRepository.findById(uuid);
        if (byId.isPresent()) {
            return new ResponseEntity<>(new ApiResponse("Success", true, byId), HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(new ApiResponse("Partner not found", false), HttpStatus.OK);
    }

    public HttpEntity<?> deletePartner(UUID uuid) {
        Optional<Partner> byId = partnerRepository.findById(uuid);
        if (byId.isPresent()) {
            partnerRepository.deleteById(uuid);
            return new ResponseEntity<>(new ApiResponse("Successfully deleted", true), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse("Error maybe partner not found", false), HttpStatus.OK);
    }
}
