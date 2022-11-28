package uz.cargostream.entity.partners;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PartnerRepository extends JpaRepository<Partner, UUID> {
}
