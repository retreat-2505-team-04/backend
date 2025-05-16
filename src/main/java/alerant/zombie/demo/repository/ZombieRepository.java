package alerant.zombie.demo.repository;

import alerant.zombie.demo.dao.Zombie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository for Zombie entities.
 */
@Repository
public interface ZombieRepository extends JpaRepository<Zombie, UUID> {
    @Query("SELECT z FROM Zombie z JOIN z.orders o WHERE o.id = :orderId ORDER BY z.energyLevel DESC LIMIT 1")
    Zombie assignBestZombie(@Param("orderId") UUID orderId);
}

