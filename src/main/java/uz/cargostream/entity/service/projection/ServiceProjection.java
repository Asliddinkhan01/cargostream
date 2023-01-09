package uz.cargostream.entity.service.projection;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.UUID;

public interface ServiceProjection {

    UUID getServiceId();

//    @Value("#{@serviceRepository.getServicesEnByServiceId(target.serviceId)}")
//    List<String> getServicesEn();
//
//    @Value("#{@serviceRepository.getServicesRuByServiceId(target.serviceId)}")
//    List<String> getServicesRu();
    String getTitleRu();
    String getTitleEn();
    String getDescriptionRu();
    String getDescriptionEn();
    String getOriginalName();

    String getUrlName();
}
