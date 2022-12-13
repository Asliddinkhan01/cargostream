package uz.cargostream.entity.contacts.projection;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.UUID;

public interface ContactProjection {

    UUID getContactId();

    @Value("#{@contactRepository.getNumbersByContactId(target.contactId)}")
    List<String> getNumbers();

    String getEmail();

    String getLocation();

    String getOriginalName();

    String getUrlName();
}
