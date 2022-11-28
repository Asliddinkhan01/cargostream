package uz.cargostream.entity.service;

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
@Entity(name = "services")
public class Service extends EntityClass {

    @Column(nullable = false)
    @OneToOne
    private Photo photo;
}
