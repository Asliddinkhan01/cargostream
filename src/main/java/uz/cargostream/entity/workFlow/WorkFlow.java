package uz.cargostream.entity.workFlow;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.cargostream.entity.template.EntityClass;

import javax.persistence.Column;
import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "workflows")
public class WorkFlow extends EntityClass {
    @Column(nullable = false)
    private String orderNumber;

    @Column(nullable = false)
    private String title_ru;

    @Column(nullable = false)
    private String title_en;

    @Column(nullable = false)
    private String description_ru;

    @Column(nullable = false)
    private String description_en;
}
