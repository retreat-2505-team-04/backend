package alerant.zombie.demo.repository;

import alerant.zombie.demo.dao.RiskAssessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID; /**
 * Repository for RiskAssessment entities.
 */
@Repository
public interface RiskAssessmentRepository extends JpaRepository<RiskAssessment, UUID> {
}
