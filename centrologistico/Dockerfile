FROM openjdk:8-jdk
VOLUME /centro-logistico
EXPOSE 9999

ENV TZ=America/Sao_Paulo
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
COPY target/centro.logistico-1.0-SNAPSHOT.jar centrologistico.jar
RUN bash -c 'touch centrologistico.jar'
ENTRYPOINT ["java", "-server","-jar", "centrologistico.jar"]