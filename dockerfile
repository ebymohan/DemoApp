FROM tomcat:8-jdk11
MAINTAINER devsecops
COPY ./java-sec-code-1.0.0.war /usr/local/tomcat/webapps
COPY ./tomcat-users.xml /usr/local/tomcat/conf/tomcat-users.xml
