package alerant.zombie.demo.dao;

import lombok.*;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "zombie")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Zombie {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "energy_level")
    private Integer energyLevel;

    @Column(name = "speed")
    private Float speed;

    @Column(name = "last_delivery_time")
    private LocalDateTime lastDeliveryTime;

    @Column(name = "bite_count")
    private Integer biteCount;

    @OneToMany(mappedBy = "zombie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RiskAssessment> riskAssessments;

    @OneToMany(mappedBy = "assignedZombie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;
}
