package ru.jyfik.demospringbatch.petbatch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.jyfik.demospringbatch.petbatch.batch.entity.EmployeeEntity;

/**
 * @author Daniil Vlasov (vlasov.daniil@otr.ru)
 */

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
