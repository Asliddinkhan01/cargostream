package uz.cargostream.entity.contacts;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.cargostream.entity.contacts.dto.AddContactDto;
import uz.cargostream.entity.contacts.dto.EditContactDto;

import java.util.UUID;

@RestController
@RequestMapping("${app.domain}/contact")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @GetMapping
    public HttpEntity<?> getAllContacts() {
        return contactService.getAllContacts();
    }

    @PostMapping
    public HttpEntity<?> addContact(
            @RequestPart("contactDto") AddContactDto contactDto,
            @RequestPart("photo") MultipartFile photo
    ) {
        return contactService.addContact(contactDto, photo);
    }

    @PutMapping
    public HttpEntity<?> editContact(
            @RequestPart("contactDto") EditContactDto contactDto,
            @RequestPart("photo") MultipartFile photo
    ) {
        return contactService.editContact(contactDto, photo);
    }

    @DeleteMapping
    public HttpEntity<?> deleteContact(@RequestParam UUID contactId) {
        return contactService.deleteContact(contactId);
    }
}
