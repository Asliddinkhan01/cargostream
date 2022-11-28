package uz.cargostream.entity.service;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.cargostream.entity.photo.Photo;

import java.util.UUID;

public interface ServiceRepository extends JpaRepository<Service, UUID> {
}
