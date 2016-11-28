# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table course (
  id                            serial not null,
  name                          varchar(255),
  constraint pk_course primary key (id)
);

create table student (
  id                            serial not null,
  name                          varchar(255),
  class_id                      integer,
  constraint pk_student primary key (id)
);

alter table student add constraint fk_student_class_id foreign key (class_id) references course (id) on delete restrict on update restrict;
create index ix_student_class_id on student (class_id);


# --- !Downs

alter table if exists student drop constraint if exists fk_student_class_id;
drop index if exists ix_student_class_id;

drop table if exists course cascade;

drop table if exists student cascade;

