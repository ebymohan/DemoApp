#!/bin/bash
rm -r "/mnt/c/Program Files/Apache Software Foundation/Tomcat 8.5/webapps/java-sec-code"*
cp /mnt/c/DemoApp/target/java-sec-code-1.0.0.war "/mnt/c/Program Files/Apache Software Foundation/Tomcat 8.5/webapps/"
cp -r /mnt/c/DemoApp/target/java-sec-code-1.0.0 "/mnt/c/Program Files/Apache Software Foundation/Tomcat 8.5/webapps/"
