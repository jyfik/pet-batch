package ru.jyfik.demospringbatch.petbatch.batch.writer;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;
import ru.jyfik.demospringbatch.petbatch.batch.entity.EmployeeEntity;
import ru.jyfik.demospringbatch.petbatch.services.EmployeeService;
import java.util.List;

/**
 * @author Daniil Vlasov (vlasov.daniil@otr.ru)
 */

@Component
@RequiredArgsConstructor
public class BatchWriter implements ItemWriter<EmployeeEntity> {

    private final EmployeeService employeeService;

    @Override
    public void write(@NonNull List<? extends EmployeeEntity> employees) {
        if (employees.size() == 0) {
            return;
        }

        employees.forEach(employeeService::createEmployee);
    }
}
