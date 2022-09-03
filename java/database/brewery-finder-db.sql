-- begin transaction;

-- drop table if exists
--     br_user,
--     brewery,
--     beer,
--     review,
--     hours_of_operation;

-- drop sequence if exists
--     seq_user_id,
--     seq_brewery_id,
--     seq_beer_id,
--     seq_review_id,
--     seq_hoo_id;


-- Define enums
create type user_role as enum (
    'admin',
    'brewmaster',
    'lover');

create type type_of_beer as enum (
    'lager',
    'ipa',
    'pale ale',
    'pilsner',
    'stout',
    'porter',
    'belgian beer',
    'wheat beer');

create type day_of_week as enum (
    'monday',
    'tuesday',
    'wednesday',
    'thursday',
    'friday',
    'saturday',
    'sunday');

create type rating as enum ('1', '2', '3', '4', '5');


-- Define tables and sequences
-- User
create sequence seq_user_id
    increment by 1
    start with 1001
    no maxvalue;

create table br_user (
    user_id int not null default nextval('seq_user_id'),
    username varchar(50) not null,
    password_hash varchar(200),
    password_salt varchar(50),
    account_type user_role,
    constraint pk_brewery_user primary key (user_id),
    constraint uq_username unique (username)
);

-- Brewery
create sequence seq_brewery_id
    increment by 1
    start with 2001
    no maxvalue;

create table brewery (
    brewery_id int not null default nextval('seq_brewery_id'),
    days_hours_operation varchar(50),
    brewer_id int not null,
    brewery_name varchar(50),
    contact_info varchar(200),
    address varchar(200),
    history_desc varchar(500),
    brewery_images varchar(500),
    is_active boolean,
    constraint pk_brewery_id primary key (brewery_id),
    constraint fk_brewery_br_user foreign key (brewer_id) references br_user (user_id)
);

-- Beer
create sequence seq_beer_id
    increment by 1
    start with 3001
    no maxvalue;

create table beer (
    beer_id int not null default nextval('seq_beer_id'),
    brewery_id int not null,
    beer_name varchar(50) NOT NULL,
    description varchar(1000),
    image varchar(100) NOT NULL,
    abv decimal,
    beer_type type,
    is_active boolean,
    constraint pk_beer_id primary key (beer_id),
    constraint fk_beer_brewery foreign key (brewery_id) references brewery (brewery_id)
);

-- Review
create sequence seq_review_id
    increment by 1
    start with 4001
    no maxvalue;

create table review (
    review_id int not null default nextval('seq_user_id'),
    rating rating,
    review_text varchar(1000),
    beer_id int not null,
    user_id int not null,
    constraint pk_review_id primary key (review_id),
    constraint fk_review_beer foreign key (beer_id) references beer (beer_id),
    constraint fk_review_user foreign key (user_id) references br_user (user_id)
);

-- Hours of operation
create sequence seq_hoo_id
    increment by 1
    start with 5001
    no maxvalue;

create table hours_of_operation (
    hoo_id int not null default nextval('seq_hoo_id'),
    brewery_id int not null,
    day day_of_week,
    open_time time,
    close_time time,
    constraint pk_hoo_id primary key (hoo_id),
    constraint fk_hours_of_operation_brewery foreign key (brewery_id) references brewery (brewery_id)
);

-- Add starting data (optional)


-- commit;