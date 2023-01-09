package uz.cargostream.entity.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.cargostream.entity.photo.Photo;
import uz.cargostream.entity.template.EntityClass;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "services")
public class Services extends EntityClass {

    @Column(nullable = false)
    private String title_ru;

    @Column(nullable = false)
    private String description_ru;

    @Column(nullable = false)
    private String title_en;

    @Column(nullable = false)
    private String description_en;

    @OneToOne
    private Photo photo;
}
