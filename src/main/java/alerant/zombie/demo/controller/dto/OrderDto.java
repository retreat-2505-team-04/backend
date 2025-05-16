package alerant.zombie.demo.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private String id;
    private String sender;
    private String recipient;
    private String description;
    private String datetime;
    private String status;

    // Konstruktor, getterek
}
