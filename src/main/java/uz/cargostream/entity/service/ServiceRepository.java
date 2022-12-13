package uz.cargostream.entity.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.cargostream.entity.service.projection.ServiceProjection;

import java.util.List;
import java.util.UUID;

public interface ServiceRepository extends JpaRepository<Services, UUID> {

    @Query(nativeQuery = true,
            value = "select ss.services as services\n" +
                    "from services_services ss\n" +
                    "where ss.services_id = :serviceId")
    List<String> getServicesByServiceId(UUID serviceId);

    @Query(nativeQuery = true,
            value = "select cast(s.id as varchar) as serviceId,\n" +
                    "       p.original_name       as originalName,\n" +
                    "       p.url_name            as urlName\n" +
                    "from services s\n" +
                    "         join photos p on s.photo_id = p.id")
    List<ServiceProjection> getAllServices();
}
