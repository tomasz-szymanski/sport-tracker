-- Database: "tracker-db"

-- DROP DATABASE "tracker-db";

CREATE ROLE "tracker-admin" LOGIN
  ENCRYPTED PASSWORD 'md52f8258dcc70099ab673a43f7308077c1'
  NOSUPERUSER INHERIT NOCREATEDB NOCREATEROLE NOREPLICATION;

ALTER DEFAULT PRIVILEGES
GRANT INSERT, SELECT, UPDATE, DELETE, TRUNCATE, REFERENCES, TRIGGER ON TABLES
TO "tracker-admin";



drop TABLE "user";

CREATE TABLE "user"
(
  id           INTEGER NOT NULL CONSTRAINT user_pkey PRIMARY KEY,
  first_name   VARCHAR(200),
  last_name    VARCHAR(200),
  start_number INTEGER,
  start_sector INTEGER,
  team         VARCHAR(500),
  country      VARCHAR(10),
  city         VARCHAR(100),
  gender       VARCHAR(1),
  elite        BOOLEAN,
  group_id     INTEGER,
  age_group    VARCHAR(20),
  birth_year   INTEGER
);

DROP SEQUENCE "user_seq";
DROP SEQUENCE "event_seq";
DROP SEQUENCE "results_seq";

create sequence "user_seq" start with 1 increment by 1;
create sequence "event_seq" start with 1 increment by 1;
create sequence "results_seq" start with 1 increment by 1;

create table "event"
(
  id integer not null constraint event_pkey primary key,
  name varchar(500),
  city varchar(100),
  start_date date,
  start_time time
);

create table "age_group"
(
  id integer not null constraint group_pkey primary key,
  name varchar(500),
  description varchar(100)
);

drop table "result";

create table "result"
(
  id integer not null constraint result_pkey primary key,
  user_id INTEGER REFERENCES user(id),
  event_id INTEGER REFERENCES event(id),
  start_time time
);

grant all on all tables in schema "public" to "tracker-admin";

grant all on all sequences in schema "public" to "tracker-admin";