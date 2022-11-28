package uz.cargostream.entity.photo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.cargostream.entity.template.EntityClass;

import javax.persistence.Column;
import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "photos")
public class Photo extends EntityClass {

    @Column(nullable = false)
    private String originalName;

    @Column(nullable = false)
    private String urlName;

}
