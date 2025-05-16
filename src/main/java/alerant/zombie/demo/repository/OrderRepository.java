package alerant.zombie.demo.repository;

import alerant.zombie.demo.dao.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID; /**
 * Repository for Order entities.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
    // Example custom finder methods (optional):
    // List<Order> findByStatus(String status);
    // List<Order> findByAssignedZombieId(UUID zombieId);
}
