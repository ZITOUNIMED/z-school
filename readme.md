In this project there is 4 microservices:
* users microservice: provides user api rest services;
* library microservices: provides library rest api services;
* administration microservice: provides administration rest api services;
* app microservice: an angular node microservice a web application to manage users, books, students, ...
<br/>

To pull last images from docker hub use following commands:
* $ docker pull mzitouni/z-school-user:0.0.4.RELEASE
* $ docker pull mzitouni/z-school-user:0.0.4.RELEASE
* $ docker pull mzitouni/z-school-user:0.0.4.RELEASE
* $ docker pull mzitouni/z-school-administration:0.0.3.RELEASE
<br/>

Run docker services using docker-compose and access from the browser localy to the different microservices on:
* App microservice: http://localhost:8080/
* Users microservice: http://localhost:8081/swagger-ui.html
* Library microservice: http://localhost:8082/swagger-ui.html
* Administration microservice: http://localhost:8083/swagger-ui.html