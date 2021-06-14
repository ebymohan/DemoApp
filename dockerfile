FROM alpine AS builder
RUN apk update
RUN apk add git
RUN apk add maven
RUN apk add openjdk11
WORKDIR /tmp
RUN git clone https://github.com/ebymohan/DemoApp
WORKDIR /tmp/DemoApp
RUN mvn package -f "pom.xml"

FROM tomcat:8-jdk11
COPY --from=builder /tmp/DemoApp/target/java-sec-code-1.0.0.war /usr/local/tomcat/webapps
COPY --from=builder /tmp/DemoApp/tomcat-users.xml /usr/local/tomcat/conf/tomcat-users.xml