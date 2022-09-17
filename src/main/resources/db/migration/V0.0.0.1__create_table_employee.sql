create table employee
(
    id                  bigint not null,
    last_name           varchar(20) not null,
    first_name          varchar(20) not null,
    document_number     varchar(4) not null,
    document_serial     varchar(6) not null
);

comment on table employee is 'Сотрудники';
comment on column employee.id is 'Идентификатор сотрудника, согласно глобальной БД';
comment on column employee.last_name is 'Фамилия сотрудника';
comment on column employee.first_name is 'Имя сотрудника';
comment on column employee.document_number is 'Номер паспорта сотрудника';
comment on column employee.document_serial is 'Серия паспорта сотрудника';