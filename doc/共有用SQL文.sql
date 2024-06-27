//usersテーブル
create table users(
    id int primary key auto_increment,
    user_name varchar(20) not null,
    password varchar(32) not null,
    child_birthday date,
    child_name varchar(20)
    );
//recordsテーブル
create table records(
    id int primary key auto_increment,
    user_id int ,
    date date(8),
    temperature varchar(4)
);
//record_mealsテーブル
create table record_meals(
    meal_id int primary key auto_increment,
    user_id int,
    meal_time time,
    milk boolean,
    baby_food boolean,
    milk_quantity varchar(6),
    meal_comment varchar(100),
    meal_timestamp timestamp
);
//record_sleepsテーブル
create table record_sleeps(
    sleep_id int primary key auto_increment,
    user_id int,
    sleep_time time,
    sleep_comment varchar(100),
    sleep_timestamp timestamp
);
//record_excretionsテーブル
create table record_excretions(
    excretion_id int primary key auto_increment,
    user_id int,
    excretion_time time,
    excretion_comment varchar(100),
    poop boolean,
    pee boolean,
    excretion_timestamp timestamp
);
/record_commentsテーブル
create table record_comments(
    comment_id int primary key auto_increment,
    user_id int,
    comment varchar(200),
    comment_timestamp timestamp
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
CREATE TABLE handbook (
id int AUTO_INCREMENT(1) ,
channel_id int,
item_id int,
 item_name VARCHAR(50),
 item_icon VARCHAR(100) ,
explanation VARCHAR(1000),
 PRIMARY KEY (id)
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
//photosテーブル
create table photos(
    id int primary key auto_increment,
    user_id int,
    img_timestamp timestamp,
    imgPath1 varchar(200),
    imgPath2 varchar(200),
    imgPath3 varchar(200),
    imgPath4 varchar(200),
    imgPath5 varchar(200)   
);