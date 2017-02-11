drop table if exists Students;
drop table if exists Courses;
drop table if exists Attendances;
drop table if exists student_course;

create table Students(
id              integer auto_increment,
student_name 		varchar(255),
CIN 	integer(10),
primary key (id)
);


insert into Students(student_name,CIN) value('Olin',558);
insert into Students(student_name,CIN) value('Michael',579);
insert into Students(student_name,CIN) value('Chris',001);
insert into Students(student_name,CIN) value('Giovanni',144);
insert into Students(student_name,CIN) value('Jose',986);

create table Courses(
id              integer auto_increment,
course_name 		varchar(255),
time_and_date 	varchar(255),
units 	int,
section      int,
location 	varchar(255),
instructor	 varchar(255),
primary key (id)
);

insert into Courses(course_name,time_and_date,units,section,location,instructor) value('Math 2148','Monday 10 am',2,3,'King Hall C4550','Michael Hsu');
insert into Courses(course_name,time_and_date,units,section,location,instructor) value('Science 2220','Monday 5 pm',4,1,'E&T A220','Richard Nixon');
insert into Courses(course_name,time_and_date,units,section,location,instructor) value('History 210B','Friday 10 am',3,3,'Salzahar Hall C123','Sue Woo Blood');

create table student_course(
course_id 		integer references Course(id),
student_id 		integer references Student(id)
);

insert into student_course(course_id,student_id) value(1,1);
insert into student_course(course_id,student_id) value(1,5);
insert into student_course(course_id,student_id) value(1,3);
insert into student_course(course_id,student_id) value(2,3);
insert into student_course(course_id,student_id) value(2,5);
insert into student_course(course_id,student_id) value(2,4);
insert into student_course(course_id,student_id) value(3,2);
insert into student_course(course_id,student_id) value(3,4);
insert into student_course(course_id,student_id) value(3,1);

create table Attendances(
id              integer auto_increment,
course_id 		integer references Course(id),
student_id 		integer references Student(id),
activity_name 	varchar(255),
status_   varchar(255),

primary key (id)
);

insert into Attendances(course_id,student_id,activity_name, status_) value(2,5,'lab5','absent');
insert into Attendances(course_id,student_id,activity_name, status_) value(2,3,'lab5','absent');
insert into Attendances(course_id,student_id,activity_name, status_) value(2,4,'lab5','present');
insert into Attendances(course_id,student_id,activity_name, status_) value(1,1,'lab8','absent');
insert into Attendances(course_id,student_id,activity_name, status_) value(1,5,'lab8','present');
insert into Attendances(course_id,student_id,activity_name, status_) value(1,3,'lab8','absent');
insert into Attendances(course_id,student_id,activity_name, status_) value(3,2,'quiz','absent');
insert into Attendances(course_id,student_id,activity_name, status_) value(3,4,'quiz','present');
insert into Attendances(course_id,student_id,activity_name, status_) value(3,1,'quiz','present');
insert into Attendances(course_id,student_id,activity_name, status_) value(2,5,'finals','present');
insert into Attendances(course_id,student_id,activity_name, status_) value(2,3,'finals','present');
insert into Attendances(course_id,student_id,activity_name, status_) value(2,4,'finals','present');

