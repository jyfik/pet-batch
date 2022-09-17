package ru.jyfik.demospringbatch.petbatch.batch.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.jyfik.demospringbatch.petbatch.batch.entity.EmployeeEntity;
import ru.jyfik.demospringbatch.petbatch.batch.processor.BatchProcessor;
import ru.jyfik.demospringbatch.petbatch.batch.reader.BatchReader;
import ru.jyfik.demospringbatch.petbatch.batch.writer.BatchWriter;
import ru.jyfik.demospringbatch.petbatch.dto.EmployeeRequestDto;

/**
 * @author Daniil Vlasov (vlasov.daniil@otr.ru)
 */
@Configuration
@EnableBatchProcessing
@RequiredArgsConstructor
public class BatchConfiguration {


    private final StepBuilderFactory stepBuilderFactory;

    @Bean("firstJob")
    public Job firstJob(JobBuilderFactory jobBuilderFactory,
                         @Qualifier("firstStep") Step firstStep) {

        return jobBuilderFactory.get("firstJob")
                                .incrementer(new RunIdIncrementer())
                                .flow(firstStep)
                                .end()
                                .build();
    }@Bean("secondJob")
    public Job secondJob(JobBuilderFactory jobBuilderFactory,
                         @Qualifier("firstStep") Step firstStep) {

        return jobBuilderFactory.get("secondJob")
                                .incrementer(new RunIdIncrementer())
                                .flow(firstStep)
                                .end()
                                .build();
    }

    @Bean("firstStep")
    public Step firstStep(@Qualifier("batchReader") BatchReader batchReader,
                          @Qualifier("batchProcessor") BatchProcessor batchProcessor,
                          @Qualifier("batchWriter") BatchWriter batchWriter) {

        return stepBuilderFactory.get("firstStep")
                                 .<EmployeeRequestDto, EmployeeEntity>chunk(200)
                                 .reader(batchReader)
                                 .processor(batchProcessor)
                                 .writer(batchWriter)
                                 .build();
    }

}
