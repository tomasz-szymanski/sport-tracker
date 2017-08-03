-- Database: "tracker-db"

-- DROP DATABASE "tracker-db";

CREATE DATABASE "tracker-db"
WITH OWNER = postgres
             ENCODING = 'UTF8'
             TABLESPACE = pg_default
             LC_COLLATE = 'Polish_Poland.1250'
           LC_CTYPE = 'Polish_Poland.1250'
           CONNECTION LIMIT = -1;

CREATE ROLE "tracker-admin" LOGIN
  ENCRYPTED PASSWORD 'md52f8258dcc70099ab673a43f7308077c1'
  NOSUPERUSER INHERIT NOCREATEDB NOCREATEROLE NOREPLICATION;


GRANT USAGE ON SCHEMA "BM" TO "tracker-admin";

grant all on all tables in schema "BM" to "tracker-admin";

grant all on all sequences in schema "BM" to "tracker-admin";

ALTER DEFAULT PRIVILEGES
GRANT INSERT, SELECT, UPDATE, DELETE, TRUNCATE, REFERENCES, TRIGGER ON TABLES
TO postgres;

ALTER DEFAULT PRIVILEGES
GRANT INSERT, SELECT, UPDATE, DELETE, TRUNCATE, REFERENCES, TRIGGER ON TABLES
TO "tracker-admin";

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

create SEQUENCE "BM"."USER_SEQ" START WITH 1 INCREMENT BY 1;

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
