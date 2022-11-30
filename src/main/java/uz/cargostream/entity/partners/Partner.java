package uz.cargostream.entity.partners;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.cargostream.entity.photo.Photo;
import uz.cargostream.entity.template.EntityClass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "partners")
public class Partner extends EntityClass {
    @OneToOne
    private Photo photo;

    @Column(nullable = false)
    private String siteLink;
}
