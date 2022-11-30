package uz.cargostream.entity.partners.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PartnerDto {
    @NotNull(message = "Required field")
    @NotBlank(message = "Title cannot be blank")
    private String siteLink;
}
