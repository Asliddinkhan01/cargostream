package uz.cargostream.entity.news;


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
@Entity(name = "news")
public class News extends EntityClass {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String text;

    @OneToOne
    private Photo photo;
}
