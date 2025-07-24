FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copia apenas os arquivos essenciais para baixar dependências e otimizar cache
COPY pom.xml mvnw ./
COPY .mvn .mvn

# Dá permissão para executar o Maven Wrapper
RUN chmod +x ./mvnw

# Baixa dependências offline para acelerar o build
RUN ./mvnw dependency:go-offline

# Copia o código fonte completo
COPY src src

# Build da aplicação, pulando testes
RUN ./mvnw clean package -DskipTests

EXPOSE 8081

CMD ["java", "-jar", "target/projetoApiProdutos-0.0.1-SNAPSHOT.jar"]