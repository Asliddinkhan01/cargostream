package uz.cargostream.entity.email.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDto {

    @NotNull(message = "Name cannot be null.")
    @NotBlank(message = "Name cannot be blank.")
    private String name;

    @NotNull(message = "Phone number cannot be null.")
    @NotBlank(message = "Phone number cannot be blank.")
    private String phoneNumber;

    @NotNull(message = "Message cannot be null.")
    @NotBlank(message = "Message cannot be blank.")
    private String message;

}
