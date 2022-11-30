package uz.cargostream.entity.partners.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PartnerUuidDto {

    @NotNull(message = "Field cannot be null")
    @NotBlank(message = "Field cannot be blank")
    private UUID partner;

}
