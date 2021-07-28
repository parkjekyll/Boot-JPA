--call next value for hibernate_sequence;
insert into user (id, name, email, created_at, updated_at) values (1, 'pinggu', 'pinggu@naver.com', now(), now());

--call next value for hibernate_sequence;
insert into user (id, name, email, created_at, updated_at) values (2, 'dubu', 'dubu@naver.com', now(), now());

--call next value for hibernate_sequence;
insert into user (id, name, email, created_at, updated_at) values (3, 'angmu', 'angmu@naver.com', now(), now());

--call next value for hibernate_sequence;
insert into user (id, name, email, created_at, updated_at) values (4, 'hyong', 'hyong@naver.com', now(), now());

--call next value for hibernate_sequence;
insert into user (id, name, email, created_at, updated_at) values (5, 'pinggu', 'pinggu@another.com', now(), now());

insert into publisher(id, name) values(1, '박맹컴퍼니');

insert into book(id, name, publisher_id, deleted) values(1, '핑구달래기', 1, false);

insert into book(id, name, publisher_id, deleted) values(2, '두부달래기', 1, false);

insert into book(id, name, publisher_id, deleted) values(3, '앵무달래기', 1, true);