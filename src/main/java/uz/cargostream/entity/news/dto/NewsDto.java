package uz.cargostream.entity.news.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewsDto {

    @NotNull(message = "Required field")
    @NotBlank(message = "Title cannot be blank")
    private String title;

    @NotNull(message = "Required field")
    @NotBlank(message = "Title cannot be blank")
    private String text;

}
