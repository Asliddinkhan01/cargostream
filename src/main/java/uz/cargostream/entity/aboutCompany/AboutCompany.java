package uz.cargostream.entity.aboutCompany;


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
@Entity(name = "about_company")
public class AboutCompany extends EntityClass {

    @Column(nullable = false)
    private String text_ru;

    @Column(nullable = false)
    private String text_en;

    @OneToOne
    private Photo photo;
}
