package ru.jyfik.demospringbatch.petbatch.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.jyfik.demospringbatch.petbatch.batch.entity.EmployeeEntity;
import ru.jyfik.demospringbatch.petbatch.repositories.EmployeeRepository;
import ru.jyfik.demospringbatch.petbatch.services.EmployeeService;
import javax.transaction.Transactional;

/**
 * @author Daniil Vlasov (vlasov.daniil@otr.ru)
 */

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public void createEmployee(EmployeeEntity employee) {
        if (employee == null) {
            return;
        }

        employeeRepository.save(employee);
    }
}
