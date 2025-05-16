package alerant.zombie.demo.controller.dto;

import alerant.zombie.demo.dao.Zombie;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ZombieAssignmentDto {
    private String zombie_id;
    private String zombie_name;
    private double suitability_score;

    // Konstruktor, getterek



    public static ZombieAssignmentDto from(Zombie assignment) {
        return new ZombieAssignmentDto(
                assignment.getId().toString(),
                assignment.getName(),
                0.0
        );
    }

}