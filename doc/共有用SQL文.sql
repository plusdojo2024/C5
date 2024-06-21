//usersテーブル

create table users(
    id int primary key auto_increment,
    user_name varchar(20) not null,
    password varchar(32) not null,
    child_birthday date,
    child_name varchar(20),
    sum int
    );
    
//recordsテーブル(藤本君変更お願いします)

create table records(
    id int primary key auto_increment,
    user_id int ,
    photo varchar(50),
    date datetime(8),
    temperature varchar(4),
    comment varchar(100)
);

//record_timesテーブル

create table record_times(
    record_id int primary key,
    meal_time timestamp,
    excretion_time timestamp,
    sleep_time timestamp
);

//record_mealsテーブル

create table record_meals(
    record_id int primary key,
    meal_time timestamp ,
    milk boolean,
    baby_food boolean,
    milk_quantity varchar(6),
    meal_comment varchar(100)
);

//record_sleepsテーブル

create table record_sleeps(
    record_id int primary key,
    sleep_time timestamp,
    sleep_comment varchar(100)
);

//record_excretionsテーブル

create table record_excretions(
    record_id int primary key,
    excretion_time timestamp,
    excretion_comment varchar(100),
    poop boolean,
    pee boolean
);

//consulsテーブル

create table consuls(
    id int primary key auto_increment,
    user_id int,
    channel_id int,
    post_id int,
    post_number int,
    post_content varchar(500),
    post_time timestamp
);

//booksテーブル(小野ちゃん変更お願いします)

create table books(
    id int primary key auto_increment,
    channel_id int,
    item_id int,
    explanation varchar(1000)
);

//channelsテーブル

create table channels(
    id int primary key auto_increment,
    channel_name varchar,
    channel_color varchar(100)
);

//gamesテーブル

create table games(
    id int primary key,
    quiz varchar(100),
    choice_1 varchar(100),
    choice_2 varchar(100),
    choice_3 varchar(100),
    choice_4 varchar(100),
    correct varchar(1),
    score int
);