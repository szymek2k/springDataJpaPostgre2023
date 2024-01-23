create table person
(
    id           bigint not null,
    email        varchar(100),
    first_name   varchar(100),
    last_name    varchar(100),
    phone_number varchar(100),
    constraint person_pk PRIMARY KEY (id)
);

alter table person
    owner to marcin;

create table job
(
    id           bigint not null,
    company_name varchar(255),
    experience   double precision,
    title        varchar(500),
    max_salary   integer,
    min_salary   integer,
    constraint job_pk PRIMARY KEY (id)
);

alter table job
    owner to marcin;

create table job_history
(
    id        bigint not null,
    date_from date,
    date_to   date,
    salary    integer,
    job_id    bigint not null,
    person_id bigint not null,
    constraint job_history_pk PRIMARY KEY (id),
    CONSTRAINT job_history_person_id_fk FOREIGN KEY (person_id) REFERENCES person(id),
    CONSTRAINT job_history_job_id_fk FOREIGN KEY (job_id) REFERENCES job(id)
--     constraint job_history_job_id_fk references job,
--     person_id bigint not null constraint job_history_person_id_fk references person
);

alter table job_history
    owner to marcin;

-- insert into public.job ( id,company_name, experience, title, max_salary, min_salary) values (1,'MICROSOFT', 5, 'senior', 150000, 10000);
-- insert into public.person (id, email, first_name, last_name, phone_number) values (1,'jan_kowalski@o2.pl', 'jan', 'kowalski', '123456789');
-- insert into public.job_history (id, date_from, date_to, salary, job_id, person_id) values (1,'2020-01-06', '2024-01-04', 12000, 1, 1);