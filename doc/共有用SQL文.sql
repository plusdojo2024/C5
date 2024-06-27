//ドライバクラス
org.h2.Driver

//JDBC URL
jdbc:h2:file:C:/pleiades/workspace/data/C5

//ユーザー名・パスワード
ユーザー名：sa
パスワード：pw

//usersテーブル
create table users(
    id int primary key auto_increment,
    user_name varchar(20) not null,
    password varchar(32) not null,
    child_birthday date,
    child_name varchar(20)
    );

//ログイン用仮user
insert into users (id, user_name, password, child_birthday, child_name) values(
    null, 'ikumi', 'a', '2024-06-27', 'kumi'
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

//consulsテーブル
create table consuls(
    id int primary key auto_increment,
    user_id int,
    channel_id int,
    consul_content varchar(100),
    consul_time timestamp
);

//commentsテーブル
create table comments(
    id int primary key auto_increment,
    user_id int,
    consul_id int,
    comment_content varchar(100),
    comment_time timestamp
); 

//booksテーブル
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

//gamesテーブルデータ
INSERT INTO Games  (id, quiz, choice_1, choice_2, choice_3, choice_4, correct, score)VALUES (
'1',
'おむつを替える手順として正しい順番は次の打つどれですか？1新しいおむつをあてる
2新しいおむつを敷く
3汚れたおむつを引き抜く
4おむつを外しておしりを拭く


',
'3→1→4→2',

'1→2→3→4
',

'2→4→3→1',

'2→1→4→3
',

'3',
'10'
);


INSERT INTO Games  (id, quiz, choice_1, choice_2, choice_3, choice_4, correct, score)VALUES (
'2',
'赤ちゃんを外出させる際に持参すべきものは次のうちどれですか？
',
'おむつ',
'ミルク',
'おしりふき',
'すべて',
'4',
'10'
);



INSERT INTO Games  (id, quiz, choice_1, choice_2, choice_3, choice_4, correct, score)VALUES (
'3',
'赤ちゃんに食べさせてはいけない食べ物は？
',
'にんじん',
'とうふ',
'さつまいも',
'はちみつ',
'4',
'10'
);

INSERT INTO Games  (id, quiz, choice_1, choice_2, choice_3, choice_4, correct, score)VALUES (
'4',
'赤ちゃんが食べるべきでない栄養素は次のうちどれですか？
',
'タンパク質',
'ビタミンC',
'鉄分',
'過剰な塩分',
'4',
'10'
);

INSERT INTO Games  (id, quiz, choice_1, choice_2, choice_3, choice_4, correct, score)VALUES (
'5',
'赤ちゃんにミルクを与える際、次のうちどの方法が適切ですか？',
'食前に一度に多く与える',
'食前に少しずつ与える',
'食後に少しずつこまめに与える',
'食事と同時に与える',
'3',
'10'
);

INSERT INTO Games  (id, quiz, choice_1, choice_2, choice_3, choice_4, correct, score)VALUES (
'6',
'粉ミルクを溶かすときのお湯は何度？
',
'0度',
'15度',
'70度以上',
'決まっていない',
'3',
'10'
);

INSERT INTO Games  (id, quiz, choice_1, choice_2, choice_3, choice_4, correct, score)VALUES (
'7',
'赤ちゃんがいる家庭で避けるべき家具は次のうちどれですか?',
'安全ロック機能の付いたベビーゲート
',
'高さの低い安定したテーブル
',
'小さな隙間のないベッド',
'尖った角のあるテーブル',
'4',
'10'
);

//scoresテーブルデータ
create table scores(
	id int primary key,
	user_id int,
	score int
);
