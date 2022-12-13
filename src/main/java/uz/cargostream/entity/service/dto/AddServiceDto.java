package uz.cargostream.entity.service.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddServiceDto {
    @NotNull(message = "Field cannot be null")
    @NotBlank(message = "Field cannot be blank")
    private List<String> services;
}
