-- AccountType
-- BeerType
-- Day
-- Rating

DROP CAST IF EXISTS (character varying AS account_type_enum);
DROP CAST IF EXISTS (character varying AS beer_type_enum);
DROP CAST IF EXISTS (character varying AS day_enum);
DROP CAST IF EXISTS (character varying AS rating_enum);

DROP TYPE IF EXISTS account_type_enum,
beer_type_enum,
day_enum,
rating_enum;

CREATE TYPE account_type_enum AS ENUM ('ADMIN', 'BREWMASTER', 'USER');
CREATE TYPE beer_type_enum as ENUM (
        'LAGER',
        'IPA',
        'PALE_ALE',
        'PILSNER',
        'STOUT',
        'PORTER',
        'BELGIAN_BEER',
        'WHEAT_BEER');
CREATE TYPE day_enum AS ENUM (
    'SUNDAY',
    'MONDAY',
    'TUESDAY',
    'WEDNESDAY',
    'THURSDAY',
    'FRIDAY',
    'SATURDAY'
);
CREATE TYPE rating_enum as ENUM (
    'ONE',
    'TWO',
    'THREE',
    'FOUR',
    'FIVE'
);

CREATE CAST (character varying AS transfer_type_enum) WITH INOUT AS ASSIGNMENT;
CREATE CAST (character varying AS transfer_status_enum) WITH INOUT AS ASSIGNMENT;
CREATE CAST (character varying AS transfer_type_enum) WITH INOUT AS ASSIGNMENT;
CREATE CAST (character varying AS transfer_status_enum) WITH INOUT AS ASSIGNMENT;

