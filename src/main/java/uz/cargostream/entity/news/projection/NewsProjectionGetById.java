package uz.cargostream.entity.news.projection;

import uz.cargostream.entity.photo.projection.PhotoProjection;

import java.util.UUID;

public interface NewsProjectionGetById {
    UUID getNewsId();

    String getTitle();

    String getText();

    PhotoProjection getPhoto();
}
