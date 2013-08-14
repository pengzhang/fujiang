# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table image (
  id                        bigint not null,
  ititle                    varchar(255),
  iurl                      varchar(255),
  constraint pk_image primary key (id))
;

create table message (
  id                        bigint not null,
  name                      varchar(255),
  email                     varchar(255),
  mobile                    varchar(255),
  message                   varchar(255),
  status                    boolean,
  constraint pk_message primary key (id))
;

create table question (
  id                        bigint not null,
  qtitle                    varchar(255),
  qoption_a                 varchar(255),
  qoption_b                 varchar(255),
  qoption_c                 varchar(255),
  qoption_d                 varchar(255),
  right                     varchar(255),
  constraint pk_question primary key (id))
;

create table video (
  id                        bigint not null,
  vtitle                    varchar(255),
  vdesc                     varchar(255),
  vurl                      varchar(255),
  status                    boolean,
  constraint pk_video primary key (id))
;

create sequence image_seq;

create sequence message_seq;

create sequence question_seq;

create sequence video_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists image;

drop table if exists message;

drop table if exists question;

drop table if exists video;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists image_seq;

drop sequence if exists message_seq;

drop sequence if exists question_seq;

drop sequence if exists video_seq;

