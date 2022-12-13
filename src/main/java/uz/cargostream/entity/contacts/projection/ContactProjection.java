package uz.cargostream.entity.contacts.projection;

import java.util.List;
import java.util.UUID;

public interface ContactProjection {

    UUID getContactId();

    List<String> getNumbers();

    String getEmail();

    String getLocation();

    String getOriginalName();

    String getUrlName();
//    PhotoProjection getPhoto();
}
