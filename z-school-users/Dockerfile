FROM gradle:6.8.3-jdk11 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM openjdk:8-jre-slim
EXPOSE 8081
COPY --from=build /home/gradle/src/build/libs/z-school-users-0.0.3.RELEASE.jar users.jar
ENTRYPOINT [ "sh", "-c", "java -jar /users.jar" ]