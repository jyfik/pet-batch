package ru.jyfik.demospringbatch.petbatch.batch.processor;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;
import ru.jyfik.demospringbatch.petbatch.batch.entity.EmployeeEntity;
import ru.jyfik.demospringbatch.petbatch.dto.EmployeeRequestDto;
import ru.jyfik.demospringbatch.petbatch.mapper.EmployeeMapper;

/**
 * @author Daniil Vlasov (vlasov.daniil@otr.ru)
 */

@Component
@RequiredArgsConstructor
public class BatchProcessor implements ItemProcessor<EmployeeRequestDto, EmployeeEntity> {

    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeEntity process(@NonNull EmployeeRequestDto dto) {
        return employeeMapper.dtoToEntity(dto);
    }
}
