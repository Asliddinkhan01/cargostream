package uz.cargostream.entity.partners;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.cargostream.entity.partners.projection.PartnerProjection;

import java.util.List;
import java.util.UUID;

public interface PartnerRepository extends JpaRepository<Partner, UUID> {

    @Query(nativeQuery = true,
            value = "select cast(p.id as varchar) as partnerId,\n" +
                    "       p.site_link           as siteLink,\n" +
                    "       p2.original_name      as originalName,\n" +
                    "       p2.url_name           as urlName\n" +
                    "from partners p\n" +
                    "         join photos p2 on p2.id = p.photo_id")
    List<PartnerProjection> getAllPartner();
}
