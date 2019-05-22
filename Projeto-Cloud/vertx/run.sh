#!/bin/sh

export JAVA_HOME=$HOME/desenvolvimento/jdk-11.0.2+9_openj9-0.12.1
export PATH=${JAVA_HOME}/bin:${PATH}
export MAVEN_HOME=$HOME/desenvolvimento/apache-maven-3.6.0
export PATH=${MAVEN_HOME}/bin:${PATH}

# Download Terraform
mkdir $HOME/terraform
#wget https://releases.hashicorp.com/terraform/0.11.14/terraform_0.11.14_linux_amd64.zip -P /$HOME/terraform/ && cd $HOME/terraform && unzip terraform_0.11.14_linux_amd64.zip

export TERRAFORM=$HOME/terraform
export PATH=${TERRAFORM}/:${PATH}

# build maven 

mvn clean package 

cp manifest.json target/ && cd target/ && zip -g vertx-sample.zip libs/*.jar vertx-sample.jar manifest.json && rm manifest.json

cd ..

mv ./target/vertx-sample.zip ./

ls

echo 'EXECUTANDO O TERRAFORM'

#terraform init -input=false

#terraform apply -input=false -auto-approve

$SHELL