FROM maven:3.8.1-jdk-8
EXPOSE 8081
WORKDIR /app
COPY . ./
CMD ["mvn", "clean"]
CMD ["mvn", "spring-boot:run", "-DskipTests"]