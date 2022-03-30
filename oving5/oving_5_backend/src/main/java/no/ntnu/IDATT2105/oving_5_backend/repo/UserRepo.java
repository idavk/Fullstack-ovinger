package no.ntnu.IDATT2105.oving_5_backend.repo;

import no.ntnu.IDATT2105.oving_5_backend.models.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
