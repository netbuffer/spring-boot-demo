FROM openjdk:8
LABEL author="netbuffer" version="1.0"
WORKDIR /
ENV JAVA_OPTS=
ADD target/spring-boot-demo.jar /
EXPOSE 9100
ENTRYPOINT java ${JAVA_OPTS} -jar /spring-boot-demo.jar