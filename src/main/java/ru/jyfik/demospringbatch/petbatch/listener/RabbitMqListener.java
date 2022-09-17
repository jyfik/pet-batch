package ru.jyfik.demospringbatch.petbatch.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ru.jyfik.demospringbatch.petbatch.batch.jobservice.JobStarterService;
import ru.jyfik.demospringbatch.petbatch.dto.EmployeeRequestDto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniil Vlasov (vlasov.daniil@otr.ru)
 */

@Slf4j
@Component
@RequiredArgsConstructor
public class RabbitMqListener {

    private final JobStarterService jobStarterService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @RabbitListener(queues = "employee-queue-demo-batch")
    public void handle(Message message) {
        log.info("Received new message from queue: employee-queue-demo-batch");
        try {

            List<EmployeeRequestDto> dtos =
                    getListOfEmployees(objectMapper
                            .readValue(message.getBody(), EmployeeRequestDto.class));

            jobStarterService.startJob(dtos);
        } catch (IOException ignore) {

        }
    }

    private List<EmployeeRequestDto> getListOfEmployees(EmployeeRequestDto source) {
        List<EmployeeRequestDto> result = new ArrayList<>(100);

        for (int i = 0; i < 100; i++) {
            result.add(copyDto(source));
            result.get(i).setId(source.getId() + (i * 10));
        }

        return result;
    }

    private EmployeeRequestDto copyDto(EmployeeRequestDto source) {
        EmployeeRequestDto target = new EmployeeRequestDto();

        target.setDocumentNumber(source.getDocumentNumber());
        target.setDocumentSerial(source.getDocumentSerial());
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());

        return target;
    }
}
