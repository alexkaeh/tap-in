begin transaction;

drop table if exists user, brewery, beer, review;
drop sequence if exists seq_user_id, seq_brewery_id, seq_beer_id, seq_review_id;

-- Define enums
create type user_role as enum ('admin', 'brewmaster', 'lover');
create type type_of_beer as enum ('lager', 'ipa', 'pale ale','pilsner', 'stout', 'porter', 'belgian beer', 'wheat beer');
create type days_of_week as enum ('monday', 'tuesday', 'wednesday', 'thursday', 'friday', 'saturday', 'sunday');

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
    constraint pk_brewery_user primary key (user_id)
    constraint uq_username unique (username)
);

create sequence seq_brewery_id
    increment by 1
    start with 2001
    no maxvalue;

create table brewery (
    brewery_id int not null default nextval('seq_brewery_id'),,
    days_hours_operation varchar(50),
    brewer_id int not null
    name varchar(50) NOT NULL,
    contact_info varchar(200) NOT NULL,
    address varchar(200) NOT NULL,
    history_desc varchar(500) NOT NULL,
    brewery_images varchar(500) NOT NULL,
    is_active boolean
    constraint pk_brewery_id primary key (brewery_id)
    constraint fk_brewery_br_user foreign key (brewer_id) references br_user (user_id)
);

create sequence seq_beer_id
    increment by 1
    start with 3001
    no maxvalue;

create table beer (
    beer_id int not null default nextval('seq_beer_id'),
    brewery_id int not null
    name varchar(50) NOT NULL,
    description
    image varchar(100) NOT NULL,
    abv
    beer type
    is_active boolean
    constraint pk_beer_id primary key (beer_id)
    constraint fk_beer_brewery foreign key (brewery_id) references brewery (brewery_id)
);

create sequence seq_review_id
    increment by 1
    start with 4001
    no maxvalue;

create table review (
    review_id int not null default nextval('seq_user_id'),
    rating
    review_text
    beer_id int not null
    user_id int not null
    constraint pk_review_id primary key (review_id),
    constraint fk_review_beer foreign key (beer_id) references beer (beer_id),
    constraint fk_review_user foreign key (user_id) references user (user_id)
);

create sequence seq_hoo_id
    increment by 1
    start with 5001
    no maxvalue;

create table hours_of_operation (
    hoo_id int not null default nextval('seq_hoo_id'),
    brewery_id int not null,
    day_of_week 
    open_time
    close_time
    constraint pk_hoo_id primary key,
    constraint fk_
);