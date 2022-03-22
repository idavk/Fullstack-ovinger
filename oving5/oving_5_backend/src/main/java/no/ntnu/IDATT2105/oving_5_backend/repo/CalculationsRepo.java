package no.ntnu.IDATT2105.oving_5_backend.repo;

import no.ntnu.IDATT2105.oving_5_backend.models.Calculator.CalculatorResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CalculationsRepo extends JpaRepository<CalculatorResponse, Long> {
    Optional<CalculatorResponse> findById(Long id);
}
