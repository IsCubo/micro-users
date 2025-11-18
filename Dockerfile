# =====================================================================
# Etapa 1: Build - Compila la aplicación con Maven y JDK
# =====================================================================
# Usamos una imagen oficial de Maven con la versión de Java 17.
# Esta imagen contiene todas las herramientas necesarias para compilar.
FROM maven:3.9-eclipse-temurin-17 AS build

# Establecemos el directorio de trabajo dentro del contenedor.
WORKDIR /app

# Copiamos primero el pom.xml para aprovechar el cache de capas de Docker.
# Si las dependencias no cambian, Docker no las volverá a descargar.
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiamos el resto del código fuente de la aplicación.
COPY src ./src

# Compilamos la aplicación y generamos el .jar, omitiendo los tests.
RUN mvn clean package -DskipTests

# =====================================================================
# Etapa 2: Run - Crea la imagen final solo con el JRE y la aplicación
# =====================================================================
# Usamos una imagen ligera de solo el entorno de ejecución de Java (JRE).
FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

# Exponemos el puerto en el que correrá la aplicación (definido por la variable SERVER_PORT).
EXPOSE 8081

# Copiamos el .jar compilado desde la etapa de 'build'.
# El nombre del .jar debe coincidir con el generado en tu pom.xml.
COPY --from=build /app/target/*.jar app.jar

# Comando para ejecutar la aplicación cuando se inicie el contenedor.
ENTRYPOINT ["java", "-jar", "app.jar"]
