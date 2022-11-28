package uz.cargostream.entity.photo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PhotoRepository extends JpaRepository<Photo, UUID> {
}
