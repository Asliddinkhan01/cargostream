package uz.cargostream.entity.contacts.projection;

import uz.cargostream.entity.photo.projection.PhotoProjection;

import java.util.List;

public interface ContactProjection {

    List<String> getNumbers();

    String getEmail();

    String getLocation();

    PhotoProjection getPhoto();
}
