create table user(
    userID smallint not null,
    firstName char(20) not null,
    lastName char (20) not null,
    userName char (20) not null,
    e-mail char (40) not null,
    phonenumber ,
    country char (20)
    primary key (userID));

create table demo(
    demoID smallint not null,
    producer smallint not null,
    title char (20),
    descriptionDemo char (300),
    favorite char (1) check(favorite = 'Y' or null),
    primary key (demoID)
    foreign key (producer) references user);

create table backoffice(
    ID int not null,
    firstName char(20) not null,
    lastName char (20) not null,
    e-mail char (40) not null,
    primary key (ID));