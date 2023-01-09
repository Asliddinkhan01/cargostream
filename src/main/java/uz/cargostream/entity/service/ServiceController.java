package uz.cargostream.entity.service;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.cargostream.entity.service.dto.ServiceDto;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("${app.domain}/service")
@RequiredArgsConstructor
public class ServiceController {

    private final ServiceService serviceService;

    @PostMapping
    public HttpEntity<?> addServices(
            @RequestPart("serviceDto") @Valid ServiceDto serviceDto,
            @RequestPart("photo") MultipartFile photo) {
        return serviceService.addService(serviceDto, photo);
    }

    @GetMapping
    public HttpEntity<?> getAllServices() {
        return serviceService.getAllService();
    }

    @DeleteMapping
    public HttpEntity<?> deleteServices(@RequestParam UUID uuid) {
        return serviceService.deleteService(uuid);
    }

    @PutMapping
    public HttpEntity<?> editServices(
            @RequestPart("serviceDto") @Valid ServiceDto serviceDto,
            @RequestPart("photo") MultipartFile photo) {
        return serviceService.editContact(serviceDto, photo);
    }
}
