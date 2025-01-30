# Use a imagem base do OpenJDK, versão 17
FROM openjdk:17-jdk-slim

# Diretório onde a aplicação será copiada dentro do container
WORKDIR /app

# Copia o arquivo .jar (gerado pelo Maven) para dentro do container
COPY target/gerenciamento_projetos-0.0.1-SNAPSHOT.jar /app/app.jar

# Expondo a porta 8080
EXPOSE 8080

# Comando para rodar a aplicação
CMD ["java", "-jar", "/app/app.jar"]