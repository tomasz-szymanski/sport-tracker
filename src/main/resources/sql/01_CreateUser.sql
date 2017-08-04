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
  age          INTEGER,
  gender       VARCHAR(1),
  elite        INTEGER,
  group_id     INTEGER,
  age_group    VARCHAR(20)
);

create sequence "user_seq" start with 1 increment by 1;

create table "event"
(
  id integer not null constraint event_pkey primary key,
  name varchar(500),
  place varchar(100),
  start_date time
);

create table "age_group"
(
  id integer not null constraint group_pkey primary key,
  name varchar(500),
  description varchar(100)
);

grant all on all tables in schema "public" to "tracker-admin";

grant all on all sequences in schema "public" to "tracker-admin";