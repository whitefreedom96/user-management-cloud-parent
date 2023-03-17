#### Stage 1: Build the application
FROM azul/zulu-openjdk:17 as build

# Set the current working directory inside the image
WORKDIR /app

RUN curl -L -o parent-pom.xml https://raw.githubusercontent.com/<username>/<repository>/<branch>/parent-pom.xml


# Copy maven executable to the image
COPY mvnw .
COPY .mvn .mvn
# Copy the pom.xml file
COPY pom.xml .
COPY ../pom.xml /app

RUN dir -s
RUN ls
# Build all the dependencies in preparation to go offline.
# This is a separate step so the dependencies will be cached unless
# the pom.xml file has changed.
RUN ./mvnw dependency:go-offline -B

# Copy the project source
COPY src src

# Package the application
RUN ./mvnw package -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

#### Stage 2: A minimal docker image with command to run the app
FROM azul/zulu-openjdk:17

ARG DEPENDENCY=/app/target/dependency

# Copy project dependencies from the build stage
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["java","-cp","app:app/lib/*","com.unicard.usermanagement.DiscoveryServiceApplication"]