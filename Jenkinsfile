pipeline{
    agent any
    environment {
        DOCKERHUB_CREDENTIALS = credentials('docker-hub-cred')
    }
    tools{
        maven 'maven_3_8_6'
    }
    
    
    stages {
        stage('Maven Build') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/hussainshahzad250/jenkins-automation.git']]])
                sh 'mvn clean install'
            }
        }
        
        stage('Build docker image') {
            steps {  
                sh 'docker build -t shahzadsastech/spring-boot-actuator-1.0.0.jar:$BUILD_NUMBER .'
            }
        }
        stage('Docker Login') {
            steps{
                sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
            }
        }
        stage('Push Image') {
            steps {
                sh 'docker push shahzadsastech/spring-boot-actuator-1.0.0.jar:$BUILD_NUMBER'
            }
        }
    }
     post {
        always {
            sh 'docker logout'
        }
    }
}
