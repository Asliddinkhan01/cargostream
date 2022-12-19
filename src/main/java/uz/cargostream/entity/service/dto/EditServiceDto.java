package uz.cargostream.entity.service.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EditServiceDto {

    @NotNull(message = "Field cannot be null")
    @NotBlank(message = "Field cannot be blank")
    private UUID servicesId;

    @NotNull(message = "Field cannot be null")
    @NotBlank(message = "Field cannot be blank")
    private List<String> services_ru;

    @NotNull(message = "Field cannot be null")
    @NotBlank(message = "Field cannot be blank")
    private List<String> services_en;
}
