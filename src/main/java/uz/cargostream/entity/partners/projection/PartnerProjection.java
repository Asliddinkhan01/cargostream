package uz.cargostream.entity.partners.projection;

import uz.cargostream.entity.photo.projection.PhotoProjection;

public interface PartnerProjection {

    String getSiteLink();

    PhotoProjection getPhoto();
}
