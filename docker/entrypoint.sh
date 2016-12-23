#!/bin/bash

# this script is an entry point for docker container running
# this application (in AWS staging/production environment)
echo $(java -version)
exec gradle run
