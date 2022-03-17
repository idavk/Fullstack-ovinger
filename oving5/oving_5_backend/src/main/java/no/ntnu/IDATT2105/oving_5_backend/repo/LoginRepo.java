package no.ntnu.IDATT2105.oving_5_backend.repo;

import no.ntnu.IDATT2105.oving_5_backend.models.LoginRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface LoginRepo extends JpaRepository<LoginRequest, Long> {
    @Override
    List<LoginRequest> findAll();
}
