package uz.cargostream.entity.service.projection;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.UUID;

public interface ServiceProjection {

    UUID getServiceId();

    @Value("#{@serviceRepository.getServicesByServiceId(target.serviceId)}")
    List<String> getServices();

    String getOriginalName();

    String getUrlName();
}
