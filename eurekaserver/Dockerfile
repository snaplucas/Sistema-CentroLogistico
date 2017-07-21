FROM openjdk:8-jdk
VOLUME /eureka-server
EXPOSE 8761

ENV TZ=America/Sao_Paulo
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
COPY target/eureka.server-1.0-SNAPSHOT.jar eureka.jar
RUN bash -c 'touch eureka.jar'
ENTRYPOINT ["java", "-server","-jar", "eureka.jar"]