package uz.cargostream.entity.partners;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.cargostream.entity.partners.projection.PartnerProjection;

import java.util.List;
import java.util.UUID;

public interface PartnerRepository extends JpaRepository<Partner, UUID> {

    @Query(nativeQuery = true,
            value = "select *\n" +
                    "from partners p\n" +
                    "         join photos p2 on p.photo_id = p2.id")
    List<PartnerProjection> getAllPartner();
}
