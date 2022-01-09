FROM openjdk:8
LABEL author="netbuffer" version="1.0"
WORKDIR /
ADD target/spring-boot-demo.jar /
EXPOSE 9100
ENTRYPOINT java -jar /spring-boot-demo.jar