create table "BM"."USER"
(
  id integer not null constraint user_pkey primary key,
  first_name varchar(200),
  last_name varchar(200),
  start_number integer,
  start_sector INTEGER,
  team varchar(500),
  country VARCHAR(10),
  age integer,
  sex varchar(1),
  group_id integer
);

create SEQUENCE "BM"."USER_SEQ" START WITH 1 INCREMENT BY 1 NOCACHE;

create table "BM"."EVENT"
(
  id integer not null constraint event_pkey primary key,
  name varchar(500),
  place varchar(100),
  start_date time
);

create table "BM"."AGE_GROUP"
(
  id integer not null constraint group_pkey primary key,
  name varchar(500),
  description varchar(100)
);
