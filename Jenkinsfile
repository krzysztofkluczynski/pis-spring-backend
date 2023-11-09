pipeline {
    agent any

    stages {
        stage('build') {
            steps {
                // Replace this with your build commands
                sh 'echo "Building the application"'
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('test') {
            steps {
                // Replace this with your test commands
                sh 'echo "Running tests"'
                sh 'mvn test'
            }
        }

        stage('deploy') {
            steps {
                // Replace this with your deployment commands
                sh 'echo "Deploying the application"'
                //sh 'cd /var/lib/jenkins/workspace/target
                //sh 'java -jar spring-backend-0.0.1-SNAPSHOT.jar'
                //sh 'mvn spring-boot:run'
                //mvn deploy??
            }
        }
    }

    post {
        success {
            // Actions to perform if the pipeline succeeds
            echo 'Pipeline succeeded!'
        }
        failure {
            // Actions to perform if the pipeline fails
            echo 'Pipeline failed!'
        }
    }
}
