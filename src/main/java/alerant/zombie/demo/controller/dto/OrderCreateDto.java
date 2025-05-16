package alerant.zombie.demo.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class OrderCreateDto {
    @NotBlank
    private String sender;
    @NotBlank private String recipient;
    @NotBlank private String description;
    @NotBlank private String datetime;

    // Getterek, setterek, konstruktorok
}

