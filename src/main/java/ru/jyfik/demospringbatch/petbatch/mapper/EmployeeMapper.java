package ru.jyfik.demospringbatch.petbatch.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.jyfik.demospringbatch.petbatch.batch.entity.EmployeeEntity;
import ru.jyfik.demospringbatch.petbatch.dto.EmployeeRequestDto;

/**
 * @author Daniil Vlasov (vlasov.daniil@otr.ru)
 */

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "documentNumber", target = "documentNumber")
    @Mapping(source = "documentSerial", target = "documentSerial")
    EmployeeEntity dtoToEntity(EmployeeRequestDto dto);
}
