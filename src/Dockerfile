FROM amazoncorretto:17-al2-jdk
WORKDIR /app
COPY . .
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","target/tag-messenger-0.0.1-SNAPSHOT.jar"]