package ru.jyfik.demospringbatch.petbatch.services;

import org.springframework.stereotype.Service;
import ru.jyfik.demospringbatch.petbatch.batch.entity.EmployeeEntity;

/**
 * @author Daniil Vlasov (vlasov.daniil@otr.ru)
 */

@Service
public interface EmployeeService {

    void createEmployee(EmployeeEntity employee);
}
