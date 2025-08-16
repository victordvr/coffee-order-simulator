pipeline {
    agent {
        docker {
            image 'maven:3.9.9-eclipse-temurin-17'
        }
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Cloning repository from GitHub'
                git branch: 'main',
                    url: 'https://github.com/victordvr/coffee-order-simulator.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Compiling code'
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo 'Running unit tests'
                bat 'mvn test'
            }
        }

        stage('Package') {
            steps {
                echo 'Packaging application'
                bat 'mvn package'
            }
        }

        stage('Docker Build') {
            when {
                expression { return fileExists('Dockerfile') }
            }
            steps {
                echo 'Dockerfile found, so a Docker image will be built (this is an optional step)'
                bat 'docker build -t coffee-machine-simulator-app .'
            }
        }
    }

    post {
        always {
            echo 'Pipeline execution finished.'
        }
        failure {
            echo 'Build failed.'
        }
        success {
            echo 'Build succeeded.'
        }
    }
}
