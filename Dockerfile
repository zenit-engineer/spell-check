FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=out/artifacts/spell_check_jar/spell-check.jar
COPY ${JAR_FILE} spell-check.jar
ENTRYPOINT ["java","-jar","/spell-check.jar"]
