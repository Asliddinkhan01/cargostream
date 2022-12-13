package uz.cargostream.entity.service.projection;

import uz.cargostream.entity.photo.projection.PhotoProjection;

import java.util.List;
import java.util.UUID;

public interface ServiceProjection {
    UUID getServiceId();

    List<String> getServices();

    PhotoProjection getPhoto();
}
