#### Stage 1: Build the application
FROM azul/zulu-openjdk:17 as build

# Set the current working directory inside the image
WORKDIR /app

# Copy maven executable to the image
COPY mvnw .
COPY .mvn .mvn

# Copy the pom.xml file
COPY pom.xml .

# Build all the dependencies in preparation to go offline.
# This is a separate step so the dependencies will be cached unless
# the pom.xml file has changed.

# Copy the project source
COPY src src
RUN ./mvnw spring-boot:build-image
CMS ["java","-cp","app:app/lib/*","com.unicard.usermanagement.UserManagementCloudApplication"]