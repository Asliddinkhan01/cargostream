package uz.cargostream.entity.news.projection;

import java.util.UUID;

public interface NewsProjectionGetById {
    UUID getNewsId();

    String getTitleRu();

    String getTitleEn();

    String getTextRu();

    String getTextEn();

    String getOriginalName();

    String getUrlName();
}
