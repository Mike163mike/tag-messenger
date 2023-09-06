insert into users (id, create_time, username, password, roles)
values ('2291f10f-980f-4e0e-8d3b-0e733339039b',
        '2023-08-04T08:00',
        'Bender',
        '$2a$12$VYyz3G4IYGrSVgxGqChtCeKpPuK8tZApC6jKGfIi6EKUm.tOM1DCW',
        '{ROLE_USER}'),
       ('5f4c576d-e22f-457c-87f1-f8ca64e36164',
        '2023-08-06T09:00',
        'Fry',
        '$2a$12$VYyz3G4IYGrSVgxGqChtCeKpPuK8tZApC6jKGfIi6EKUm.tOM1DCW',
        '{ROLE_USER}');

insert into messages (id, create_time, message, hashtag, publisher_id)
values ('99c97ae0-e601-4bfa-a92a-b5f91a17a1d0',
        '2023-08-04T09:00',
        'Bender the best! Kiss my shiny metal a**!',
        '#Bender the best',
        '2291f10f-980f-4e0e-8d3b-0e733339039b'),
       ('91c1172e-4294-4614-9b7e-40083c08dca4',
        '2023-08-04T10:00',
        'Remember me!!!',
        '#Bender the best',
        '2291f10f-980f-4e0e-8d3b-0e733339039b'),
       ('67e2b4a2-c016-49d2-a5d4-b72787137d9b',
        '2023-08-04T11:00',
        'I love Leela! Any Leela!',
        '#Love Leela',
        '5f4c576d-e22f-457c-87f1-f8ca64e36164');

insert into users_messages (messages_id, user_id)
values ('99c97ae0-e601-4bfa-a92a-b5f91a17a1d0',
        '2291f10f-980f-4e0e-8d3b-0e733339039b'),
       ('91c1172e-4294-4614-9b7e-40083c08dca4',
        '2291f10f-980f-4e0e-8d3b-0e733339039b'),
       ('67e2b4a2-c016-49d2-a5d4-b72787137d9b',
        '5f4c576d-e22f-457c-87f1-f8ca64e36164');