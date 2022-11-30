package uz.cargostream.entity.contacts.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddContactDto {

    @NotNull(message = "Field cannot be null")
    @NotBlank(message = "Field cannot be blank")
    private List<String> phoneNumbers;

    @NotNull(message = "Field cannot be null")
    @NotBlank(message = "Field cannot be blank")
    private String email;

    @NotNull(message = "Field cannot be null")
    @NotBlank(message = "Field cannot be blank")
    private String location;
}
