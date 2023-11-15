pipeline {
    agent any
    tools {
        maven "MAVEN_HOME"
        jdk "Java17"
    }

    stages {
        stage("Build") {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }

        stage("Test") {
            steps {
                sh 'mvn test'
            }
        }

        stage("Deploy") {
            steps {
                sh 'mvn deploy'
            }
        }

        stage("Deploy to Docker Container") {
            steps {
                script {
                    sh 'docker rm -f spring-backend || true'
                    sh 'docker build -t spring-backend:latest -f Dockerfile .'
                    sh 'docker run -d -p 8080:8080 --name spring-backend spring-backend:latest'
                }
            }
        }
    }
}
