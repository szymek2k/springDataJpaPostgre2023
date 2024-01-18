create table person
(
    email        varchar(100),
    first_name   varchar(100),
    last_name    varchar(100),
    phone_number varchar(100),
    id           bigint not null
        constraint person_pk
            primary key
);

alter table person
    owner to marcin;

create table job
(
    company_name varchar(255),
    experience   double precision,
    title        varchar(500),
    max_salary   integer,
    min_salary   integer,
    id           bigint not null
        constraint job_pk
            primary key
);

alter table job
    owner to marcin;

create table job_history
(
    date_from date,
    date_to   date,
    salary    integer,
    job_id    bigint
        constraint job_history_job_id_fk
            references job,
    id        bigint not null
        constraint job_history_pk
            primary key,
    person_id bigint not null
        constraint job_history_person_id_fk
            references person
);

alter table job_history
    owner to marcin;
	
insert into public.job (company_name, experience, title, max_salary, min_salary, id) values ('microsoft', 5, 'senior', 150000, 10000, 1);
insert into public.person (email, first_name, last_name, phone_number, id) values ('jan_kowalski@o2.pl', 'jan', 'kowalski', '123456789', 1);
insert into public.job_history (date_from, date_to, salary, job_id, id, person_id) values ('2020-01-06', '2024-01-04', 12000, 1, 1, 1);	