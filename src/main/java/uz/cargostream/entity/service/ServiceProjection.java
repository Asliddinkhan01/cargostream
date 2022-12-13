package uz.cargostream.entity.service;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.UUID;

public interface ServiceProjection {

    UUID getServicesId();

    @Value("#{@serviceRepository.getServicesByServiceId(target.seriviceId)}")
    List<String> getServices();

    String getOriginalName();

    String getUrlName();
}
