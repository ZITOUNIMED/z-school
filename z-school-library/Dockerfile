FROM gradle:6.8.3-jdk11 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM openjdk:8-jre-slim
EXPOSE 8082
COPY --from=build /home/gradle/src/build/libs/z-school-library-0.0.2.RELEASE.jar library.jar
ENTRYPOINT [ "sh", "-c", "java -jar /library.jar" ]