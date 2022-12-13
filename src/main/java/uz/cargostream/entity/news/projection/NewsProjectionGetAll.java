package uz.cargostream.entity.news.projection;

import java.util.UUID;

public interface NewsProjectionGetAll {

    UUID getNewsId();

    String getTitle();

    String getOriginalName();

    String getUrlName();

//    PhotoProjection getPhoto();
}
