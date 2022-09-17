package ru.jyfik.demospringbatch.petbatch.batch.jobservice;

import ru.jyfik.demospringbatch.petbatch.dto.EmployeeRequestDto;
import java.util.List;

/**
 * @author Daniil Vlasov (vlasov.daniil@otr.ru)
 */
public interface JobStarterService {

    void startJob(List<EmployeeRequestDto> dto);
}
