package alerant.zombie.demo.dao;

import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "risk_assessment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RiskAssessment {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zombie_id", nullable = false)
    private Zombie zombie;

    @Column(name = "risk_level", nullable = false)
    private String riskLevel;

    @Column(name = "explanation", columnDefinition = "TEXT")
    private String explanation;
}
