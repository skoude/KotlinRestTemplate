#!/bin/bash

# this script is an entry point for docker container running
# this application (in AWS staging/production environment)
echo $(java -version)
exec java -server \
          -Denvironment=$ENVIRONMENT \
          -Djava.io.tmpdir=/var/tmp \
          -Dfile.encoding=UTF-8 \
          -jar /opt/kotlin-rest-template/kotlin-rest-template.jar
