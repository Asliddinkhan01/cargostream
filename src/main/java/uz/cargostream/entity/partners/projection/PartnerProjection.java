package uz.cargostream.entity.partners.projection;

import uz.cargostream.entity.photo.projection.PhotoProjection;

import java.util.UUID;

public interface PartnerProjection {
    UUID getPartnerId();

    String getSiteLink();

    String getOriginalName();

    String getUrlName();
}
