package uz.cargostream.entity.news;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.cargostream.entity.news.projection.NewsProjectionGetAll;
import uz.cargostream.entity.news.projection.NewsProjectionGetById;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface NewsRepository extends JpaRepository<News, UUID> {

    @Query(nativeQuery = true,
            value = "select cast(n.id as varchar) as newsId,\n" +
                    "       n.title_ru               as titleRu,\n" +
                    "       n.title_En               as titleEn,\n" +
                    "       p.original_name       as originalName,\n" +
                    "       p.url_name            as urlName\n" +
                    "from news n\n" +
                    "         join photos p on p.id = n.photo_id")
    List<NewsProjectionGetAll> getAllNews();


    @Query(nativeQuery = true,
            value = "select cast(n.id as varchar)   as newsId,\n" +
                    "       n.title_ru              as titleRu,\n" +
                    "       n.title_en              as titleEn,\n" +
                    "       n.text_ru               as textRu,\n" +
                    "       n.text_en               as textEn,\n" +
                    "       p.original_name         as originalName,\n" +
                    "       p.url_name              as urlName\n" +
                    "from news n\n" +
                    "         join photos p on n.photo_id = p.id\n" +
                    "where n.id = :newsId")
    Optional<NewsProjectionGetById> getNewsById(UUID newsId);
}
