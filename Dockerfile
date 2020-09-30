FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-DMYSQL_HOST=dockerhost","-jar","/app.jar"]
