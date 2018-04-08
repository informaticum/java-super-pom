#!/bin/bash

# mvn clean install
mvn --projects example-ejb-project-impl --also-make verify
