FROM java:8-jre
MAINTAINER Aleksei Vekovshinin <vekovshinin.aiu@gmail.com>

ADD ./target/service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/service.jar"]

EXPOSE 8080