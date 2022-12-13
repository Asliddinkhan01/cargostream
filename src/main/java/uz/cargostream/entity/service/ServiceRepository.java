package uz.cargostream.entity.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.mail.Service;
import java.util.List;
import java.util.UUID;

public interface ServiceRepository extends JpaRepository<Service, UUID> {

    @Query(nativeQuery = true,
            value = "select ss.services as services\n" +
                    "from services_services ss\n" +
                    "where ss.services_id = :serviceId")
    List<String> getServicesByServiceId(UUID serviceId);
}
