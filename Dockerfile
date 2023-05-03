FROM amazoncorretto:8

MAINTAINER MoraCastelliGaraycochea
COPY target/portafolio-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
