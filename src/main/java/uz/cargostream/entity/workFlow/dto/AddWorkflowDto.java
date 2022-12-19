package uz.cargostream.entity.workFlow.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddWorkflowDto {


    @NotNull(message = "Field cannot be null")
    @NotBlank(message = "Field cannot be blank")
    private String orderNumber;

    @NotNull(message = "Field cannot be null")
    @NotBlank(message = "Field cannot be blank")
    private String title_ru;

    @NotNull(message = "Field cannot be null")
    @NotBlank(message = "Field cannot be blank")
    private String title_en;

    @NotNull(message = "Field cannot be null")
    @NotBlank(message = "Field cannot be blank")
    private String description_ru;

    @NotNull(message = "Field cannot be null")
    @NotBlank(message = "Field cannot be blank")
    private String description_en;

}
