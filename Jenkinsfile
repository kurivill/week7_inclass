pipeline {
    agent any

    environment {
    IMAGE_NAME = 'villeaku/week7_inclass'
    IMAGE_TAG = 'latest'
    }




    stages {

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t %IMAGE_NAME%:%IMAGE_TAG% .'
            }
        }

        stage('Login to Docker') {
        steps {
            withCredentials([usernamePassword(credentialsId: 'DOCKERHUB_CREDENTIALS', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                script {
                bat 'echo %PASSWORD% | docker login --username %USERNAME% --password-stdin'
                }
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                bat "docker push $IMAGE_NAME:$IMAGE_TAG"
            }
        }


        stage('Test') {
            steps {
                bat 'mvn clean test'
            }
        }
        stage('Code Coverage') {
            steps {
                bat 'mvn jacoco:report'
            }
        }
        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }
        stage('Publish Coverage Report') {
            steps {
                recordCoverage(tools: [[parser: 'JACOCO']])
            }
        }
    }
}