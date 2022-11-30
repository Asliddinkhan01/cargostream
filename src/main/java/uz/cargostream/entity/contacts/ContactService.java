package uz.cargostream.entity.contacts;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.cargostream.common.ApiResponse;
import uz.cargostream.entity.contacts.dto.AddContactDto;
import uz.cargostream.entity.contacts.dto.EditContactDto;
import uz.cargostream.entity.contacts.projection.ContactProjection;
import uz.cargostream.entity.photo.PhotoService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;
    private final PhotoService photoService;

    public HttpEntity<?> getAllContacts() {
        List<ContactProjection> allContacts = contactRepository.getAllContacts();
        return new ResponseEntity<>(new ApiResponse("Success", true, allContacts), HttpStatus.OK);
    }

    public HttpEntity<?> addContact(AddContactDto contactDto, MultipartFile photo) {
        Contact contact = new Contact();

        contact.setEmail(contactDto.getEmail());
        contact.setLocation(contactDto.getLocation());
        contact.setNumbers(contactDto.getPhoneNumbers());

        contact.setPhoto(photoService.savePhoto(photo));

        try {
            contactRepository.save(contact);
            return new ResponseEntity<>(new ApiResponse("Success", true), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ApiResponse("Something went wrong", false), HttpStatus.CONFLICT);
        }
    }

    public HttpEntity<?> editContact(EditContactDto contactDto, MultipartFile photo) {
        Optional<Contact> optionalContact = contactRepository.findById(contactDto.getContactId());

        if (optionalContact.isEmpty())
            return new ResponseEntity<>(new ApiResponse("Not found", false), HttpStatus.NOT_FOUND);

        Contact contact = optionalContact.get();

        contact.setLocation(contactDto.getLocation());
        contact.setNumbers(contactDto.getPhoneNumbers());
        contact.setEmail(contactDto.getEmail());

        photoService.deletePhoto(contact.getPhoto().getId());

        contact.setPhoto(photoService.savePhoto(photo));
        try {
            contactRepository.save(contact);
            return new ResponseEntity<>(new ApiResponse("Success", true), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ApiResponse("Something went wrong", false), HttpStatus.CONFLICT);
        }
    }

    public HttpEntity<?> deleteContact(UUID contactId) {
        Optional<Contact> optionalContact = contactRepository.findById(contactId);

        if (optionalContact.isEmpty())
            return new ResponseEntity<>(new ApiResponse("Not found", false), HttpStatus.NOT_FOUND);

        Contact contact = optionalContact.get();
        photoService.deletePhoto(contact.getPhoto().getId());
        contactRepository.deleteById(contactId);
        return new ResponseEntity<>(new ApiResponse("Success", true), HttpStatus.NO_CONTENT);
    }
}
