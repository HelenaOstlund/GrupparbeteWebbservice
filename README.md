# GrupparbeteWebbservice
Team3

How to get started:

Run following script in terminal:

-----
docker pull mysql

docker run --name restaurangdb -p 3306:3306 -e MYSQL_ROOT_PASSWORD=grupp3 -d mysql

docker exec -it restaurangdb bash

mysql -uroot -pgrupp3

create database restaurangdb;

----

Run Spring boot project.
