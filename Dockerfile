FROM alibabadragonwell/dragonwell:8-ubuntu
LABEL author="netbuffer" version="1.0" org.opencontainers.image.source="https://github.com/netbuffer/spring-boot-demo" org.opencontainers.image.description="Spring Boot 2.7 demo webapp" org.opencontainers.image.licenses="MIT"
WORKDIR /
COPY help/docker-entrypoint.sh /docker-entrypoint.sh
RUN mkdir /docker-entrypoint.d
ENTRYPOINT ["/docker-entrypoint.sh"]
ENV JAVA_OPTS=
ADD target/*.jar /app.jar
EXPOSE 9100
CMD ["sh", "-c", "java ${JAVA_OPTS} -jar /app.jar"]