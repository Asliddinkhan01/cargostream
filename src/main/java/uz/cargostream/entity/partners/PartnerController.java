package uz.cargostream.entity.partners;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.cargostream.entity.partners.dto.PartnerDto;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/partner")
@RequiredArgsConstructor
public class PartnerController {
    private final PartnerService partnerService;

    @PostMapping
    public HttpEntity<?> addPartner(@RequestPart("partnerDto") PartnerDto partnerDto,
                                    @RequestPart("photo") MultipartFile photo) {
        return partnerService.addPartner(photo, partnerDto);
    }

    @GetMapping("/{uuid}")
    private HttpEntity<?> getPartner(@PathVariable UUID uuid) {
        return partnerService.getPartner(uuid);
    }

    @DeleteMapping("/{uuid}")
    public HttpEntity<?> deletePartner(@PathVariable UUID uuid) {
        return partnerService.deletePartner(uuid);
    }
}
