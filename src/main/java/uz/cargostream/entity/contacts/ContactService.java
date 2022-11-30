package uz.cargostream.entity.contacts;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.cargostream.common.ApiResponse;
import uz.cargostream.entity.contacts.projection.ContactProjection;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

    public HttpEntity<?> getAllContacts() {
        List<ContactProjection> allContacts = contactRepository.getAllContacts();
        return new ResponseEntity<>(new ApiResponse("Success", true, allContacts), HttpStatus.OK);
    }
}
