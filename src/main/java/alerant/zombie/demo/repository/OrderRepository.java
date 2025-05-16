package alerant.zombie.demo.repository;

import alerant.zombie.demo.dao.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID; /**
 * Repository for Order entities.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
    @Modifying
    @Query("UPDATE Order o SET o.status = :status, o.description = :description WHERE o.id = :orderId")
    int updateStatus(@Param("orderId") String orderId, @Param("status") String status, @Param("description") String description);
}
