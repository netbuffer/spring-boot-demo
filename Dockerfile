FROM openjdk:8
LABEL author="netbuffer" version="1.0"
COPY help/docker-entrypoint.sh /
RUN mkdir /docker-entrypoint.d
ENTRYPOINT ["/docker-entrypoint.sh"]
WORKDIR /
ENV JAVA_OPTS=
ADD target/*.jar /app.jar
EXPOSE 9100
CMD java ${JAVA_OPTS} -jar /app.jar