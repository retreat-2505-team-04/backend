package alerant.zombie.demo.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RiskAssessmentDto {
    private String risk_level;
    private String explanation;

    // Konstruktor, getterek
}
