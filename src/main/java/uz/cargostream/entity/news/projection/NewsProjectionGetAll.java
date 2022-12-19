package uz.cargostream.entity.news.projection;

import java.util.UUID;

public interface NewsProjectionGetAll {

    UUID getNewsId();

    String getTitleRu();
    String getTitleEn();

    String getOriginalName();

    String getUrlName();

//    PhotoProjection getPhoto();
}
