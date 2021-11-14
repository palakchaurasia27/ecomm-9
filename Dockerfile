FROM openjdk:8-jdk
COPY ./target/SportyShoes-Ecom-0.0.1-SNAPSHOT.jar SportyShoes-Ecom-0.0.1-SNAPSHOT.jar 
CMD ["java" ,"-jar","SportyShoes-Ecom-0.0.1-SNAPSHOT.jar "]
RUN echo "jenkins ALL=(ALL) NOPASSWD: ALL" >> /etc/sudoers
