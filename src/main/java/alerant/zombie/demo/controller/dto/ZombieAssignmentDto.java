package alerant.zombie.demo.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ZombieAssignmentDto {
    private String zombie_id;
    private String zombie_name;
    private double suitability_score;

    // Konstruktor, getterek
}