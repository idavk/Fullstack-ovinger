package no.ntnu.IDATT2105.oving_5_backend.repo;

import no.ntnu.IDATT2105.oving_5_backend.models.Calculator.Calculation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CalculationsRepo extends JpaRepository<Calculation, Long> {
    List<Calculation> findAllByidUser(int id_user);
}
