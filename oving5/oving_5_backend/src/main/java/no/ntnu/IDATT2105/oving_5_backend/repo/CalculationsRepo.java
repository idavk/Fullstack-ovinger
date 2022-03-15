package no.ntnu.IDATT2105.oving_5_backend.repo;

import no.ntnu.IDATT2105.oving_5_backend.models.Calculations;

import java.util.List;

public interface CalculationsRepo {
    int save(Calculations result);
    int update(Calculations result);
    Calculations findById(long id);
    int deleteById(long id);
    List<Calculations> findAll();
    int deleteAll();
}
