package uz.cargostream.entity.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.cargostream.entity.photo.Photo;
import uz.cargostream.entity.template.EntityClass;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "services")
public class Service extends EntityClass {

    @ElementCollection(fetch = FetchType.LAZY)
    private List<String> services;


    @OneToOne
    private Photo photo;
}
