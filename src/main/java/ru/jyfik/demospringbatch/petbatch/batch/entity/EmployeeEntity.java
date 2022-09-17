package ru.jyfik.demospringbatch.petbatch.batch.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Daniil Vlasov (vlasov.daniil@otr.ru)
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "employee")
public class EmployeeEntity {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "document_serial", nullable = false)
    private String documentSerial;

    @Column(name = "document_number", nullable = false)
    private String documentNumber;

}
