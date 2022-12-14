package uz.cargostream.entity.partners;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.cargostream.entity.partners.dto.PartnerDto;
import uz.cargostream.entity.partners.dto.PartnerUuidDto;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("${app.domain}/partner")
@RequiredArgsConstructor
public class PartnerController {
    private final PartnerService partnerService;

    @PostMapping
    public HttpEntity<?> addPartner(@RequestPart("partnerDto")@Valid PartnerDto partnerDto,
                                    @RequestPart("photo") MultipartFile photo) {
        return partnerService.addPartner(photo, partnerDto);
    }


    @DeleteMapping
    public HttpEntity<?> deletePartner( @Valid @RequestBody PartnerUuidDto partnerUuidDto) {
        return partnerService.deletePartner(partnerUuidDto.getPartnerId());
    }

    @GetMapping
    public HttpEntity<?> getAllPartner(){
        return partnerService.getAllPartner();
    }
}
