package uz.cargostream.entity.aboutCompany.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EditAboutCompanyDto {

    @NotNull(message = "Field cannot be null")
    @NotBlank(message = "Field cannot be blank")
    private UUID aboutCompanyId;

    @NotNull(message = "Field cannot be null")
    @NotBlank(message = "Field cannot be blank")
    private String text_ru;

    @NotNull(message = "Field cannot be null")
    @NotBlank(message = "Field cannot be blank")
    private String text_en;
}
