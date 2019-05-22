#!/bin/sh

export JAVA_HOME=/home/danieldiasjava/desenvolvimento/jdk-11.0.2+9_openj9-0.12.1
export PATH=${JAVA_HOME}/bin:${PATH}
export MAVEN_HOME=/home/danieldiasjava/desenvolvimento/apache-maven-3.6.0
export PATH=${MAVEN_HOME}/bin:${PATH}

# Download Terraform
mkdir $HOME/terraform
#wget https://releases.hashicorp.com/terraform/0.11.14/terraform_0.11.14_linux_amd64.zip -P /$HOME/terraform/ && cd $HOME/terraform && unzip terraform_0.11.14_linux_amd64.zip

export TERRAFORM=$HOME/terraform
export PATH=${TERRAFORM}/:${PATH}

terraform --version

java --version

mvn --version
# build maven 

#mvn clean package