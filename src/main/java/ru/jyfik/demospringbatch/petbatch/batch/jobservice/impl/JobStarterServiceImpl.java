package ru.jyfik.demospringbatch.petbatch.batch.jobservice.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.stereotype.Service;
import ru.jyfik.demospringbatch.petbatch.batch.jobservice.JobStarterService;
import ru.jyfik.demospringbatch.petbatch.batch.reader.BatchReader;
import ru.jyfik.demospringbatch.petbatch.dto.EmployeeRequestDto;
import java.time.Instant;
import java.util.Date;
import java.util.List;

/**
 * @author Daniil Vlasov (vlasov.daniil@otr.ru)
 */
@Service
@RequiredArgsConstructor
public class JobStarterServiceImpl implements JobStarterService {

    private final JobLauncher jobLauncher;

    private final Job firstJob;

    private final BatchReader batchReader;

    @Override
    public void startJob(List<EmployeeRequestDto> dto) {
        try {
            batchReader.setDto(dto);
            jobLauncher.run(firstJob, new JobParametersBuilder().addDate("someKey", Date.from(Instant.now())).toJobParameters());
        } catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException | JobParametersInvalidException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
