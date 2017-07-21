# Sistema-CentroLogistico
## Deploy
	
Em ambientes windows sem suporte a Hyper-V instalar docker toolbox, que pode ser obtido em https://www.docker.com/products/docker-toolbox.
Apos a instalação rodar o QuickStart e executar os passos abaixo na ordem que aparecem.

### docker
  *  com o docker instalado, abrir um terminal e executar os seguintes comandos para especificar a shell a ser usada
      - docker-machine start <nomeDaMachine>
      - docker-machine env --shell cmd <nomeDaMachine>
      - @FOR /f "tokens=*" %i IN ('docker-machine env --shell cmd teste') DO @%i
  *  os proximos comandos deverão ser executados no terminal onde a docker-machine esta rodando

### eureka-server
  * ir para a pasta do projeto
  * buildar o projeto executando o comando "mvn clean install"
  * executar o comando "docker build -t eureka-server ." para montar a imagem
  * executar o comando "docker images" e verificar a imagem recem criada	
  * apos a imagem ser contruida, executar o comando "docker run -p 8761:8761 -d eureka-server" para rodar o container
  * verificar o eureka rodando em http://192.168.99.100:8761/ (ou http://localhost:8761/)

### mongodb
  * executar o comando "docker run -p 27017:27017 -d bitnami/mongodb", ele irá baixar a imagem do mongodb e executar o container

### centro-logistico
  * ir para a pasta do projeto
  * buildar o projeto executando o comando "mvn clean install"
  * executar o comando "docker build -t centro-logistico ."	para montar a imagem
  * executar o comando "docker images" e verificar a imagem recem criada	
  * apos a imagem ser contruida, executar o comando "docker run -p 9999:9999 -d centro-logistico" para rodar o container
  * executar o comando "docker run -p 6666:9999 -d centro-logistico", para rodar outro container e poder se fazer uso do load ballance

### api-gateway
  * ir para a pasta do projeto
  * buildar o projeto executando o comando "mvn clean install"
  * executar o comando "docker build -t api-gateway ." para montar a imagem
  * executar o comando "docker images" e verificar a imagem recem criada
  * apos a imagem ser contruida, executar o comando "docker run -p 8888:8888 -d api-gateway" para rodar o container

Obs: o IP da maquina virtual do docker costuma ser 192.168.99.100, para confirmar isso rodar o comando "docker-machine ip <nomeDaMachine"
Caso o IP seja diferente será necessário alterar os arquivos application.yml para apontar para o IP correto.


documentação da api estará em http://192.168.99.100:9999/swagger-ui.html

a rota para a api-gateway será http://192.168.99.100:8888
