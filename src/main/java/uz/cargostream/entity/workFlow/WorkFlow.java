package uz.cargostream.entity.workFlow;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.cargostream.entity.template.EntityClass;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "workflows")
public class WorkFlow extends EntityClass {
    private String orderNumber;
    private String title;
    private String description;
}
