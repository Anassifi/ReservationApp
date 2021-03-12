create table role
(
    id_role  bigserial not null
        constraint role_pkey
            primary key,
    rolename varchar(254)
);

alter table role
    owner to postgres;

create table "User"
(
    id_user   bigserial not null
        constraint "User_pkey"
            primary key,
    firstname varchar(254),
    lastname  varchar(254),
    email     varchar(254),
    password  varchar(254),
    phone     varchar(254),
    id_role   bigint
        constraint fk_role
            references role
            on delete set null
);

alter table "User"
    owner to postgres;

create table typereservation
(
    id_limit        bigserial not null
        constraint typereservation_pkey
            primary key,
    numbermax       bigint,
    dateoflimit     varchar(254),
    typereservation varchar(254)
);

alter table typereservation
    owner to postgres;

create table reservation
(
    id_reservation  bigserial not null
        constraint reservation_pkey
            primary key,
    id_user         bigint,
    datereservation varchar(254),
    confirmation    boolean,
    typeres         bigint
        constraint fk_type
            references typereservation
            on delete set null
);

alter table reservation
    owner to postgres;

create table admin
(
    id_user bigserial not null
        constraint admin_pkey
            primary key
        constraint fk_user
            references "User"
            on delete set null
);

alter table admin
    owner to postgres;

create table student
(
    id_user        bigserial not null
        constraint student_pkey
            primary key
        constraint fk_user
            references "User"
            on delete set null,
    reservationmax bigint
);

alter table student
    owner to postgres;


