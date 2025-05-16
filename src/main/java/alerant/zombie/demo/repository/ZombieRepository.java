package alerant.zombie.demo.repository;

import alerant.zombie.demo.dao.Zombie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository for Zombie entities.
 */
@Repository
public interface ZombieRepository extends JpaRepository<Zombie, UUID> {
    // Example custom finder methods (optional):
    // List<Zombie> findByEnergyLevelGreaterThan(int level);
}

