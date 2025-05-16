package alerant.zombie.demo.repository;

import alerant.zombie.demo.dao.EventLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID; /**
 * Repository for EventLog entities.
 */
@Repository
public interface EventLogRepository extends JpaRepository<EventLog, UUID> {
}
