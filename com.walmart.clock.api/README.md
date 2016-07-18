# logistics-walmart

O projeto foi criado com as seguintes ferramentas e o motivo do uso:

- Maven: Gerenciador de projeto mais utilizado

- Spring Boot: Utilizado pela facilidade de iniciar o sistema sem a necessidade de um servidor de aplicação (o tomcat é embutido) e pelo uso do Spring

- PowerMock e EasyMock: Ferramentas de testes simples para criar diversões cenários.

- Hsql Embedded Database: Database embutido criado em cada vez que o aplicativo começar


#Para executar o programa, é só seguir os passos abaixo:

- Instalar o projeto usando maven:

	mvn clean install

- Rodar o projeto

	java -jar target/com.walmart.clock.api-0.0.1-SNAPSHOT.jar
