create table users
(
    id          uuid not null primary key,
    create_time timestamp(6) with time zone,
    username    varchar(255) unique,
    password    varchar(255),
    roles       varchar(255) array
);

create table messages
(
    id           uuid not null primary key,
    create_time  timestamp(6) with time zone,
    message      varchar(255) unique,
    hashtag          varchar(255),
    publisher_id uuid not null,
    constraint fk_publisher_id
        foreign key (publisher_id)
            references users
);

create table users_messages
(
    messages_id uuid not null unique,
    user_id     uuid not null,
    constraint fk_messages_id
        foreign key (messages_id)
            references messages,
    constraint fk_user_id
        foreign key (user_id)
            references users
);
