package uz.cargostream.entity.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.cargostream.entity.service.projection.ServiceProjection;

import java.util.List;
import java.util.UUID;

public interface ServiceRepository extends JpaRepository<Services, UUID> {

//    @Query(nativeQuery = true,
//            value = "select s.services_en as serviceEn\n" +
//                    "from services_services_en s\n" +
//                    "where s.services_id = :serviceId")
//    List<String> getServicesEnByServiceId(UUID serviceId);
//
//    @Query(nativeQuery = true,
//            value = "select s.services_ru as serviceRu\n" +
//                    "from services_services_ru s\n" +
//                    "where s.services_id = :serviceId")
//    List<String> getServicesRuByServiceId(UUID serviceId);

    @Query(nativeQuery = true,
            value = "select cast(s.id as varchar) as serviceId,\n" +
                    "       s.title_ru            as titleRu,\n" +
                    "       s.title_en            as titleEn,\n" +
                    "       s.description_ru      as descriptionRu,\n" +
                    "       s.description_en      as descriptionEn,\n" +
                    "       p.original_name       as originalName,\n" +
                    "       p.url_name            as urlName\n" +
                    "from services s\n" +
                    "         join photos p on s.photo_id = p.id")
    List<ServiceProjection> getAllServices();
}
