FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
RUN mkdir /certs
CMD ["java","-DMYSQL_HOST=dockerhost","-XX:MaxMetaspaceSize=75M","-Xms25M","-Xmx75M","-XX:ReservedCodeCacheSize=10M","-XX:MaxDirectMemorySize=10M","-Xss256k","-jar","/app.jar"]
