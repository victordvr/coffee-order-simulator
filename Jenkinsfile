pipeline {
    agent any

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
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo 'Running unit tests'
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                echo 'Packaging application'
                sh 'mvn package'
            }
        }

        stage('Docker Build') {
            when {
                expression { return fileExists('Dockerfile') }
            }
            steps {
                echo 'Dockerfile found, so a Docker image will be built (this is an optional step)'
                sh 'docker build -t coffee-machine-simulator-app .'
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
