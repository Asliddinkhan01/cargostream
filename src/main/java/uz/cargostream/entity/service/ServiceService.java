package uz.cargostream.entity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.server.Http2;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.cargostream.common.ApiResponse;
import uz.cargostream.entity.contacts.Contact;
import uz.cargostream.entity.contacts.dto.EditContactDto;
import uz.cargostream.entity.photo.PhotoService;
import uz.cargostream.entity.service.dto.AddServiceDto;
import uz.cargostream.entity.service.dto.EditServiceDto;
import uz.cargostream.entity.service.projection.ServiceProjection;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ServiceService {

    private final ServiceRepository serviceRepository;

    private final PhotoService photoService;

    public HttpEntity<?> getAllService() {
        List<ServiceProjection> allServices = serviceRepository.getAllServices();
        return new ResponseEntity<>(new ApiResponse("Success", true, allServices), HttpStatus.OK);
    }

    public HttpEntity<?> addService(AddServiceDto addServiceDto, MultipartFile photo) {
        Services service = new Services();
        service.setServices(addServiceDto.getServices());
        service.setPhoto(photoService.savePhoto(photo));
        try {
            serviceRepository.save(service);
            return new ResponseEntity<>(new ApiResponse("Success", true), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse("Something went wrong", false), HttpStatus.CONFLICT);
        }
    }

    public HttpEntity<?> editContact(EditServiceDto serviceDto, MultipartFile photo) {
        Optional<Services> optionalServices = serviceRepository.findById(serviceDto.getServicesId());

        if (optionalServices.isEmpty())
            return new ResponseEntity<>(new ApiResponse("Not found", false), HttpStatus.NOT_FOUND);

        Services services = optionalServices.get();
        services.setServices(serviceDto.getServices());
        photoService.deletePhoto(services.getPhoto().getId());

        services.setPhoto(photoService.savePhoto(photo));
        try {
            serviceRepository.save(services);
            return new ResponseEntity<>(new ApiResponse("Success", true), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ApiResponse("Something went wrong", false), HttpStatus.CONFLICT);
        }
    }

    public HttpEntity<?> deleteService(UUID serviceId) {
        Optional<Services> byId = serviceRepository.findById(serviceId);
        if (byId.isEmpty()) {
            return new ResponseEntity<>(new ApiResponse("Not found", false), HttpStatus.NOT_FOUND);
        }
        Services services = byId.get();
        photoService.deletePhoto(services.getPhoto().getId());
        serviceRepository.deleteById(serviceId);
        return new ResponseEntity<>(new ApiResponse("Success", true), HttpStatus.NO_CONTENT);
    }
}
