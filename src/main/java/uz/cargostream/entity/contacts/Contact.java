package uz.cargostream.entity.contacts;


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
@Entity(name = "contacts")
public class Contact extends EntityClass {

    @ElementCollection(fetch = FetchType.LAZY)
    private List<String> numbers;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String location;

    @OneToOne
    private Photo photo;
}
