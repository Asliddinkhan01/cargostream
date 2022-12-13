package uz.cargostream.entity.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.cargostream.entity.service.projection.ServiceProjection;

import java.util.List;
import java.util.UUID;

public interface ServiceRepository extends JpaRepository<Services, UUID> {

    @Query(nativeQuery = true,
    value = "select *\n" +
            "from services s\n" +
            "         join photos p on p.id = s.photo_id\n" +
            "         join services_services ss on s.id = ss.services_id")
    List<ServiceProjection> getAllServices();
}
