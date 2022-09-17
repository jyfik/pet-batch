package ru.jyfik.demospringbatch.petbatch.batch.reader;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;
import ru.jyfik.demospringbatch.petbatch.dto.EmployeeRequestDto;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniil Vlasov (vlasov.daniil@otr.ru)
 */

@Component
@RequiredArgsConstructor
public class BatchReader implements ItemReader<EmployeeRequestDto> {

    private List<EmployeeRequestDto> data;

    @Override
    public EmployeeRequestDto read() {
        if (data == null) {
            return null;
        }
        return this.data.isEmpty() ? null : this.data.remove(0);
    }

    public void setDto(List<EmployeeRequestDto> source) {
        this.data = new ArrayList<>();
        this.data.addAll(source);
    }
}
