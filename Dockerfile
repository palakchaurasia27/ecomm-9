FROM openjdk:8-jdk
COPY ./target/ecomm-9-0.0.1-SNAPSHOT.jar ecomm-9-0.0.1-SNAPSHOT.jar
CMD ["java" ,"-jar","ecomm-9-0.0.1-SNAPSHOT.jar"]
RUN echo "jenkins ALL=(ALL) NOPASSWD: ALL" >> /etc/sudoers
