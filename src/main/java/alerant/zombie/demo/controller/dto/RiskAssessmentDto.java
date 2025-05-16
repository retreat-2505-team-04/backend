package alerant.zombie.demo.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RiskAssessmentDto {
    private String risk_level;
    private String explanation;

    // Konstruktor, getterek
}
