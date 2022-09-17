package ru.jyfik.demospringbatch.petbatch.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.jyfik.demospringbatch.petbatch.batch.entity.EmployeeEntity;
import ru.jyfik.demospringbatch.petbatch.dto.EmployeeRequestDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-18T01:09:41+0300",
    comments = "version: 1.5.0.Beta2, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeEntity dtoToEntity(EmployeeRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        EmployeeEntity employeeEntity = new EmployeeEntity();

        employeeEntity.setId( dto.getId() );
        employeeEntity.setLastName( dto.getLastName() );
        employeeEntity.setFirstName( dto.getFirstName() );
        employeeEntity.setDocumentNumber( dto.getDocumentNumber() );
        employeeEntity.setDocumentSerial( dto.getDocumentSerial() );

        return employeeEntity;
    }
}
