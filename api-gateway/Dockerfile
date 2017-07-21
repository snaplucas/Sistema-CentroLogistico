FROM openjdk:8-jdk
VOLUME /api-gateway
EXPOSE 8888

ENV TZ=America/Sao_Paulo
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
COPY target/api-gateway-1.0-SNAPSHOT.jar api-gateway.jar
RUN bash -c 'touch gateway.jar'
ENTRYPOINT ["java", "-server","-jar", "api-gateway.jar"]